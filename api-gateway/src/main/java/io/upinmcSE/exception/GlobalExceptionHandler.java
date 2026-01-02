package io.upinmcSE.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.upinmcSE.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<ApiResponse> convertExceptionGrpc2Http(StatusRuntimeException e){
        int statusCode = extractStatusCode(e.getStatus());
        ApiResponse apiResponse = ApiResponse.builder()
                .code(statusCode)
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(statusCode).body(apiResponse);

    }

    private int extractStatusCode(Status status){
        return switch (status.getCode().value()) {
            case 6 -> 403;
            case 5 -> 404;
            default -> 500;
        };
    }
}
