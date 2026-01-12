package io.upinmcse.security.config;

import io.upinmcse.security.core.handler.GemaAccessDeniedHandler;
import io.upinmcse.security.core.handler.GemaAuthenticationEntryPoint;
import io.upinmcse.security.core.handler.GemaJwtDecoder;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AutoConfiguration
@AutoConfigureOrder(-1)
public class GemaSecurityAutoConfiguration {
    @Bean
    public GemaAccessDeniedHandler  gemaAccessDeniedHandler() {
        return new GemaAccessDeniedHandler();
    }

    @Bean
    public GemaAuthenticationEntryPoint gemaAuthenticationEntryPoint() {
        return new GemaAuthenticationEntryPoint();
    }

    @Bean
    public GemaJwtDecoder gemaJwtDecoder() {
        return new GemaJwtDecoder();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
