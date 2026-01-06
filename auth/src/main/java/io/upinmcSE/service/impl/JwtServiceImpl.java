package io.upinmcSE.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import io.upinmcSE.entity.Account;
import io.upinmcSE.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secretKey}")
    private String SIGNER_KEY;

    @Value("${jwt.accessExpiryMinutes}")
    private long ACCESS_EXPIRY_SECONDS;

    @Value("${jwt.refreshExpiryMinutes}")
    private long REFRESH_EXPIRY_SECONDS;

    @Override
    public String generateJwt(Account account, boolean isRefresh) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        long expiryTimeInSeconds = isRefresh ? REFRESH_EXPIRY_SECONDS : ACCESS_EXPIRY_SECONDS;

        JWTClaimsSet.Builder claimsBuilder = new JWTClaimsSet.Builder()
                .subject(account.getId().toString())
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(expiryTimeInSeconds, ChronoUnit.SECONDS).toEpochMilli()))
                .jwtID(UUID.randomUUID().toString());

        if (!isRefresh) {
            claimsBuilder.claim("roles", buildScope(account));
        }

        JWTClaimsSet claimsSet = claimsBuilder.build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isJwtValid(String token, boolean isRefresh) throws JOSEException, ParseException {
        if (token == null || token.trim().isEmpty()) return false;

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = (isRefresh)
                ? new Date(signedJWT.getJWTClaimsSet()
                .getIssueTime()
                .toInstant()
                .plus(REFRESH_EXPIRY_SECONDS, ChronoUnit.HOURS)
                .toEpochMilli())
                : signedJWT.getJWTClaimsSet().getExpirationTime();

        if (expiryTime.before(new Date())) {
            return false;
        }

        return signedJWT.verify(verifier);
    }

    @Override
    public String extractAccountName(String token) throws ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        if (signedJWT.getJWTClaimsSet() != null && signedJWT.getJWTClaimsSet().getSubject() != null) {
            return signedJWT.getJWTClaimsSet().getSubject();
        }
        return "";
    }

    @Override
    public Date extractExpiration(String token) {
        SignedJWT signedJWT = null;
        try {
            signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

            // TODO check null
            return claimsSet.getExpirationTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildScope(Account account){
        return  "";
    }

}
