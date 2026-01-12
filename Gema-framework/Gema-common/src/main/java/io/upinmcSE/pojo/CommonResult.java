package io.upinmcSE.pojo;

import io.upinmcSE.exception.ErrorCode;
import io.upinmcSE.exception.ServiceException;
import io.upinmcSE.exception.enums.GlobalErrorCodeConstants;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public static <T> CommonResult<T> success(T data){
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorCodeConstants.SUCCESS.getCode();
        result.data = data;
        result.msg = "";
        return result;
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
//        Assert.notEquals(GlobalErrorCodeConstants.SUCCESS.getCode(), code, "code xxx");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }

    public static boolean isSuccess(Integer code) {
        return Objects.equals(code, GlobalErrorCodeConstants.SUCCESS.getCode());
    }

    public static <T> CommonResult<T> error(ServiceException serviceException) {
        return error(serviceException.getCode(), serviceException.getMessage());
    }
}
