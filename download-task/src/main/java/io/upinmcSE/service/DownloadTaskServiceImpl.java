package io.upinmcSE.service;

import io.grpc.stub.StreamObserver;
import io.upinmcSE.grpc.gen.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DownloadTaskServiceImpl extends DownloadTaskGrpcServiceGrpc.DownloadTaskGrpcServiceImplBase {
    @Override
    public void createDownloadTask(CreateDownloadTaskRequest request, StreamObserver<CreateDownloadTaskResponse> responseObserver) {
        super.createDownloadTask(request, responseObserver);
    }

    @Override
    public void getDownloadTask(GetDownloadTaskRequest request, StreamObserver<GetDownloadTaskResponse> responseObserver) {
        super.getDownloadTask(request, responseObserver);
    }

    @Override
    public void getDownloadTaskList(GetDownloadTaskListRequest request, StreamObserver<GetDownloadTaskListResponse> responseObserver) {
        super.getDownloadTaskList(request, responseObserver);
    }

    @Override
    public void updateDownloadTask(UpdateDownloadTaskRequest request, StreamObserver<UpdateDownloadTaskResponse> responseObserver) {
        super.updateDownloadTask(request, responseObserver);
    }

    @Override
    public void deleteDownloadTask(DeleteDownloadTaskRequest request, StreamObserver<DeleteDownloadTaskResponse> responseObserver) {
        super.deleteDownloadTask(request, responseObserver);
    }
}
