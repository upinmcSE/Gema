package io.upinmcSE.service;

import io.grpc.stub.StreamObserver;
import io.upinmcSE.grpc.gen.ProfileCreationRequest;
import io.upinmcSE.grpc.gen.ProfileGrpcServiceGrpc;
import io.upinmcSE.grpc.gen.UserProfileResponse;

public class ProfileServiceImpl extends ProfileGrpcServiceGrpc.ProfileGrpcServiceImplBase {
    @Override
    public void createProfile(ProfileCreationRequest request, StreamObserver<UserProfileResponse> responseObserver) {
        super.createProfile(request, responseObserver);
    }
}
