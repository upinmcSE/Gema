package io.upinmcSE.service;

import io.upinmcSE.dto.request.AccountRequest;
import io.upinmcSE.dto.response.CreateAccountResponse;
import io.upinmcSE.grpc.gen.AuthGrpcServiceGrpc;
import io.upinmcSE.grpc.gen.CreateAccountRequest;
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
}
