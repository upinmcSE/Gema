package io.upinmcSE.service;

import io.grpc.stub.StreamObserver;
import io.upinmcSE.grpc.gen.AuthGrpcServiceGrpc;
import io.upinmcSE.grpc.gen.PingRequest;
import io.upinmcSE.grpc.gen.PingResponse;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AuthServiceImpl extends AuthGrpcServiceGrpc.AuthGrpcServiceImplBase {
    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        PingResponse response = PingResponse.newBuilder()
                .setResponse("Hello " + request.getName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
