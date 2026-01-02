package io.upinmcSE.service;

import io.grpc.stub.StreamObserver;
import io.upinmcSE.grpc.gen.*;
import io.upinmcSE.repository.AccountPwdRepository;
import io.upinmcSE.repository.AccountRepository;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AuthServiceImpl extends AuthGrpcServiceGrpc.AuthGrpcServiceImplBase {
    private final AccountRepository accountRepository;
    private final AccountPwdRepository accountPwdRepository;

    public AuthServiceImpl(AccountRepository accountRepository, AccountPwdRepository accountPwdRepository){
        this.accountRepository = accountRepository;
        this.accountPwdRepository = accountPwdRepository;
    }

    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        super.createAccount(request, responseObserver);
        // check account name

        // created account
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
