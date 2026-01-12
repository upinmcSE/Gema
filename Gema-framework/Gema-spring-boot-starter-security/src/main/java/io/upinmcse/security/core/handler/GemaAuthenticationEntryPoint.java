package io.upinmcse.security.core.handler;

import io.upinmcSE.pojo.CommonResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import io.upinmcSE.util.ServletUtils;

import java.io.IOException;

import static io.upinmcSE.exception.enums.GlobalErrorCodeConstants.UNAUTHORIZED;

@Slf4j
public class GemaAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {
        log.warn("hí hí");
        ServletUtils.writeJson(response, CommonResult.error(UNAUTHORIZED));
    }
}
