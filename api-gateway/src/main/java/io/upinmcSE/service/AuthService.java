package io.upinmcSE.service;

import io.upinmcSE.dto.request.AccountRequest;
import io.upinmcSE.dto.response.CreateAccountResponse;
import io.upinmcSE.dto.response.CreateSessionResponse;
import io.upinmcSE.grpc.gen.AuthGrpcServiceGrpc;
import io.upinmcSE.grpc.gen.CreateAccountRequest;
import io.upinmcSE.grpc.gen.CreateSessionRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @GrpcClient("auth-service")
    private AuthGrpcServiceGrpc.AuthGrpcServiceBlockingStub authGrpcServiceBlockingStub;

    public CreateAccountResponse createAccount(AccountRequest request){
        CreateAccountRequest accountRequest = CreateAccountRequest.newBuilder()
                .setAccountName(request.getAccountName())
                .setPassword(request.getPassword())
                .build();
        io.upinmcSE.grpc.gen.CreateAccountResponse response = authGrpcServiceBlockingStub.createAccount(accountRequest);

        return CreateAccountResponse.builder()
                .accountId(response.getAccountId())
                .build();
    }

    public CreateSessionResponse createSession(AccountRequest request){
        CreateSessionRequest accountRequest = CreateSessionRequest.newBuilder()
                .setAccountName(request.getAccountName())
                .setPassword(request.getPassword())
                .build();

        io.upinmcSE.grpc.gen.CreateSessionResponse response = authGrpcServiceBlockingStub.createSession(accountRequest);

        return CreateSessionResponse.builder()
                .token(response.getToken())
                .accountName(response.getAccount().getAccountName())
                .build();
    }
}
