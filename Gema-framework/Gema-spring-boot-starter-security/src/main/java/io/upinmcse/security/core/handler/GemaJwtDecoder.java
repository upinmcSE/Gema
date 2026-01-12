package io.upinmcse.security.core.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

@Slf4j
public class GemaJwtDecoder implements JwtDecoder {
    @Override
    public Jwt decode(String token) throws JwtException {
        return null;
    }
}
