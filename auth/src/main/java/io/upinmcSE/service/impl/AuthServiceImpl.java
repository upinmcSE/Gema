package io.upinmcSE.service.impl;

import com.nimbusds.jose.JOSEException;
import io.upinmcSE.dto.request.AccountRequest;
import io.upinmcSE.dto.request.VerifySessionReq;
import io.upinmcSE.dto.response.CreateAccountResponse;
import io.upinmcSE.dto.response.CreateSessionResponse;
import io.upinmcSE.dto.response.VerifySessionRes;
import io.upinmcSE.entity.Account;
import io.upinmcSE.entity.AccountPassword;
import io.upinmcSE.exception.enums.GlobalErrorCodeConstants;
import io.upinmcSE.grpc.gen.*;
import io.upinmcSE.repository.AccountPwdRepository;
import io.upinmcSE.repository.AccountRepository;
import io.upinmcSE.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.upinmcSE.exception.ServiceExceptionUtil.exception;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService{
    private final AccountRepository accountRepository;
    private final AccountPwdRepository accountPwdRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RedisTemplate<String, Object> redisTemplate;

    public AuthServiceImpl(
            AccountRepository accountRepository,
            AccountPwdRepository accountPwdRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            RedisTemplate<String, Object> redisTemplate){
        this.accountRepository = accountRepository;
        this.accountPwdRepository = accountPwdRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.redisTemplate = redisTemplate;
    }

    @Override
    @Transactional
    public CreateAccountResponse createAccount(AccountRequest request) {
        // check account name
        boolean existAccount = accountRepository.existsAccountByAccountName(request.getAccountName());
        if(existAccount) throw exception(GlobalErrorCodeConstants.NOT_FOUND);

        // created account
        Account account = Account.builder()
                .accountName(request.getAccountName())
                .build();
        account = accountRepository.save(account);

        // created account password
        String passwordHash = passwordEncoder.encode(request.getPassword());
        AccountPassword accountPwd = AccountPassword.builder()
                .ofAccountId(account.getId())
                .password(passwordHash)
                .build();
        accountPwdRepository.save(accountPwd);

        return CreateAccountResponse.builder()
                .accountId(account.getId())
                .build();
    }

    @Override
    @Transactional
    public CreateSessionResponse createSession(AccountRequest request) {
        // check account
        Account account = accountRepository.findByAccountName(request.getAccountName())
                .orElseThrow(() -> exception(GlobalErrorCodeConstants.NOT_FOUND));

        // check password
        AccountPassword accountPwd = accountPwdRepository.findAccountPasswordByOfAccountId(account.getId())
                .orElseThrow(() -> exception(GlobalErrorCodeConstants.NOT_FOUND));
        boolean checkPwd = passwordEncoder.matches(request.getPassword(), accountPwd.getPassword());
        if(!checkPwd) throw exception(GlobalErrorCodeConstants.BAD_REQUEST);

        // create access token
        String accessToken = jwtService.generateJwt(account, false);

        // create refresh token
        String refreshToken = jwtService.generateJwt(account, true);
        redisTemplate.opsForValue().set(String.valueOf(account.getId()), refreshToken, calculateExpirationInMillis(jwtService.extractExpiration(refreshToken)), TimeUnit.SECONDS);

        return CreateSessionResponse.builder()
                .token(accessToken)
                .accountName(account.getAccountName())
                .build();
    }

    @Override
    public VerifySessionRes verifySession(VerifySessionReq request) {
        boolean isValid;

        try {
            isValid = jwtService.isJwtValid(request.getToken(), false);
        } catch (JOSEException | ParseException e) {
            throw exception(GlobalErrorCodeConstants.UNAUTHORIZED); // TODO handle
        }

        return VerifySessionRes.builder()
                .isValid(isValid)
                .build();
    }


    private long calculateExpirationInMillis(Date expiration) {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationTimeMillis = expiration.getTime();
        long durationInMillis = expirationTimeMillis - currentTimeMillis;
        long expirationInSeconds = TimeUnit.MILLISECONDS.toSeconds(durationInMillis);

        if (expirationInSeconds <= 0) {
            throw new IllegalArgumentException("Token has already expired");
        }
        return expirationInSeconds;
    }
}
