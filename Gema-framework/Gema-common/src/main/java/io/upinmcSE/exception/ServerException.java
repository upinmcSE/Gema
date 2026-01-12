package io.upinmcSE.exception;

import lombok.Data;

@Data
public class ServerException extends RuntimeException {
    private Integer code;
    private String msg;

    public ServerException(){}

    public ServerException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServerException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}
