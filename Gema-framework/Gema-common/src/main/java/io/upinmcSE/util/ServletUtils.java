package io.upinmcSE.util;

import io.upinmcSE.pojo.CommonResult;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ServletUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void writeJson(HttpServletResponse response, Object object) throws IOException {
        if (object instanceof CommonResult<?> result) {
            response.setStatus(result.getCode());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(objectMapper.writeValueAsString(result));
            response.flushBuffer();
            return;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(objectMapper.writeValueAsString(object));
        response.flushBuffer();
    }
}
