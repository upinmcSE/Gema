package io.upinmcSE.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {
    private Integer code;

    private String msg;

    public ServiceException() {
    }

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
