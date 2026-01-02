package io.upinmcSE.service;

import io.grpc.stub.StreamObserver;
import io.upinmcSE.entity.Account;
import io.upinmcSE.entity.AccountPassword;
import io.upinmcSE.exception.AccountExistException;
import io.upinmcSE.grpc.gen.*;
import io.upinmcSE.repository.AccountPwdRepository;
import io.upinmcSE.repository.AccountRepository;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@GrpcService
public class AuthServiceImpl extends AuthGrpcServiceGrpc.AuthGrpcServiceImplBase {
    private final AccountRepository accountRepository;
    private final AccountPwdRepository accountPwdRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(
            AccountRepository accountRepository,
            AccountPwdRepository accountPwdRepository,
            PasswordEncoder passwordEncoder){
        this.accountRepository = accountRepository;
        this.accountPwdRepository = accountPwdRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void createAccount(CreateAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        if(true) throw new AccountExistException("Account already exist");

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
    public void createSession(CreateSessionRequest request, StreamObserver<CreateSessionResponse> responseObserver) {
        super.createSession(request, responseObserver);
    }

    @Override
    public void verifySession(VerifySessionRequest request, StreamObserver<VerifySessionResponse> responseObserver) {
        super.verifySession(request, responseObserver);
    }
}
