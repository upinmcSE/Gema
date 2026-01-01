package io.upinmcSE.service;

import io.grpc.stub.StreamObserver;
import io.upinmcSE.grpc.gen.*;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AuthServiceImpl extends AuthGrpcServiceGrpc.AuthGrpcServiceImplBase {
    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        super.createAccount(request, responseObserver);
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
