package io.upinmcSE.service;

import io.upinmcSE.grpc.gen.AuthGrpcServiceGrpc;
import io.upinmcSE.grpc.gen.PingRequest;
import io.upinmcSE.grpc.gen.PingResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @GrpcClient("auth-service")
    private AuthGrpcServiceGrpc.AuthGrpcServiceBlockingStub authGrpcServiceBlockingStub;

    public PingResponse ping(PingRequest request){
        return authGrpcServiceBlockingStub.ping(request);
    }
}
