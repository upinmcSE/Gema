package io.upinmcSE.exception;

import io.upinmcSE.exception.enums.GlobalErrorCodeConstants;

public class ServiceExceptionUtil {
    public static ServiceException exception(ErrorCode errorCode) {
        return exception0(errorCode.getCode(), errorCode.getMsg());
    }

    public static ServiceException exception(ErrorCode errorCode, Object... params) {
        return exception0(errorCode.getCode(), errorCode.getMsg(), params);
    }

    public static ServiceException exception0(Integer code, String messagePattern, Object... params) {
        String message = doFormat(code, messagePattern, params);
        return new ServiceException(code, message);
    }

    public static ServiceException invalidParamException(String messagePattern, Object... params) {
        return exception0(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), messagePattern, params);
    }

    public static String doFormat(int code, String messagePattern, Object... params) {
        return String.format(messagePattern, params); // TODO handle late
    }
}
