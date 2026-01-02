package io.upinmcSE.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GlobalExceptionHandler {

    @GrpcExceptionHandler(AccountNotFoundException.class)
    public StatusRuntimeException handleAccountNotFoundException(AccountNotFoundException exception){
        return Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException();

    }

    @GrpcExceptionHandler(AccountExistException.class)
    public StatusRuntimeException handleAccountExistException(AccountExistException exception){
        return Status.ALREADY_EXISTS.withDescription(exception.getMessage()).asRuntimeException();

    }
}
