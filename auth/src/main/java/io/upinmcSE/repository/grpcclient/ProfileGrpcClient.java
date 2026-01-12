package io.upinmcSE.repository.grpcclient;

import io.upinmcSE.grpc.gen.ProfileCreationRequest;
import io.upinmcSE.grpc.gen.ProfileGrpcServiceGrpc;
import io.upinmcSE.grpc.gen.UserProfileResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class ProfileGrpcClient {
    @GrpcClient("profile-service")
    private ProfileGrpcServiceGrpc.ProfileGrpcServiceBlockingStub profileStub;

    // TODO change type pram and return value
    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        ProfileCreationRequest req = ProfileCreationRequest.newBuilder()
                .setUserId(request.getUserId())
                .setFullName(request.getFullName())
                .build();
        return profileStub.createProfile(req);
    }
}
