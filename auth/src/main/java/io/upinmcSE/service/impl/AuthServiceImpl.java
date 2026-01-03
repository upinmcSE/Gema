package io.upinmcSE.service.impl;

import com.nimbusds.jose.JOSEException;
import io.grpc.stub.StreamObserver;
import io.upinmcSE.entity.Account;
import io.upinmcSE.entity.AccountPassword;
import io.upinmcSE.exception.AccountExistException;
import io.upinmcSE.exception.AccountNotFoundException;
import io.upinmcSE.grpc.gen.*;
import io.upinmcSE.repository.AccountPwdRepository;
import io.upinmcSE.repository.AccountRepository;
import io.upinmcSE.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@GrpcService
@Slf4j
public class AuthServiceImpl extends AuthGrpcServiceGrpc.AuthGrpcServiceImplBase {
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
    public void createAccount(CreateAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        // check account name
        boolean existAccount = accountRepository.existsAccountByAccountName(request.getAccountName());
        if(existAccount) throw new AccountExistException("Account already exist");

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

        responseObserver.onNext(
                CreateAccountResponse.newBuilder()
                        .setAccountId(account.getId())
                        .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void createSession(CreateSessionRequest request, StreamObserver<CreateSessionResponse> responseObserver) {
        // check account
        Account account = accountRepository.findByAccountName(request.getAccountName())
                .orElseThrow(() -> new AccountNotFoundException("Not found account"));

        // check password
        AccountPassword accountPwd = accountPwdRepository.findAccountPasswordByOfAccountId(account.getId())
                .orElseThrow(() -> new AccountNotFoundException("Not found account"));
        boolean checkPwd = passwordEncoder.matches(request.getPassword(), accountPwd.getPassword());
        if(!checkPwd) throw new AccountNotFoundException("Not found account");

        // create access token
        String accessToken = jwtService.generateJwt(account, false);

        // create refresh token
        String refreshToken = jwtService.generateJwt(account, true);
        redisTemplate.opsForValue().set(String.valueOf(account.getId()), refreshToken, calculateExpirationInMillis(jwtService.extractExpiration(refreshToken)), TimeUnit.SECONDS);

        responseObserver.onNext(CreateSessionResponse.newBuilder()
                        .setToken(accessToken)
                        .setAccount(io.upinmcSE.grpc.gen.Account.newBuilder()
                                .setId(account.getId())
                                .setAccountName(account.getAccountName())
                                .build())
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void verifySession(VerifySessionRequest request, StreamObserver<VerifySessionResponse> responseObserver) {
        boolean isValid;

        try {
            isValid = jwtService.isJwtValid(request.getToken(), false);
        } catch (JOSEException | ParseException e) {
            throw new RuntimeException(e); // TODO handle
        }

        responseObserver.onNext(VerifySessionResponse.newBuilder()
                        .setIsValid(isValid)
                .build());
        responseObserver.onCompleted();
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
