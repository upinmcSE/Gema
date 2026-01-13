package io.upinmcse.security.core.handler;

import io.upinmcSE.pojo.CommonResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import io.upinmcSE.util.ServletUtils;
import static io.upinmcSE.exception.enums.GlobalErrorCodeConstants.FORBIDDEN;

@Slf4j
public class GemaAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException, ServletException {
        ServletUtils.writeJson(response, CommonResult.error(FORBIDDEN));
    }
}
