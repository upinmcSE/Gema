package io.upinmcSE.exception;

import io.grpc.StatusRuntimeException;
import io.upinmcSE.dto.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StatusRuntimeException.class)
    public ApiResponse<Void> convertExceptionGrpc2Http(StatusRuntimeException e){
        System.out.printf("message" + e.getMessage());
        return ApiResponse.<Void>builder()
                .code(e.getStatus().getCode().value())
                .message(e.getMessage())
                .build();
    }
}
