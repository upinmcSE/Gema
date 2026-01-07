package io.upinmcSE.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.upinmcSE.dto.ApiResponse;
import io.upinmcSE.dto.request.VerifySessionReq;
import io.upinmcSE.service.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter implements Ordered {

    private final ObjectMapper objectMapper;
    private final AuthService authService;

    public AuthenticationFilter(
            ObjectMapper objectMapper,
            AuthService authService
    ){
        this.objectMapper = objectMapper;
        this.authService = authService;
    }

    private final String[] publicEndpoints = {
            "/auth/account",
            "/auth/session",
//            "/auth/.*"
    };

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        log.info("Enter authentication filter....");

        if(isPublicEndpoint(request)){
            filterChain.doFilter(request, response);
        }

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if((authHeader == null) || !authHeader.startsWith("Bearer ")){
            unauthenticated(response);
            return;
        }

        String token = authHeader.substring(7);
        if(!authService.verifySession(VerifySessionReq.builder().token(token).build()).isValid()){
            unauthenticated(response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    private boolean isPublicEndpoint(HttpServletRequest request){
        String path = request.getRequestURI();
        return Arrays.stream(publicEndpoints)
                .anyMatch(path::matches);
    }

    private void unauthenticated(HttpServletResponse response) throws IOException {
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(401)
                .message("Unauthenticated")
                .build();

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
        response.getWriter().flush();
    }

}
