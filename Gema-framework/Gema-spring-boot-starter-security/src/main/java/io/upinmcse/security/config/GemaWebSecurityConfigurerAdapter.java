package io.upinmcse.security.config;

import io.upinmcse.security.core.handler.GemaAccessDeniedHandler;
import io.upinmcse.security.core.handler.GemaAuthenticationEntryPoint;
import io.upinmcse.security.core.handler.GemaJwtDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@AutoConfiguration
@AutoConfigureOrder(-1)
@EnableMethodSecurity(securedEnabled = true)
public class GemaWebSecurityConfigurerAdapter {
    @Autowired
    private GemaAccessDeniedHandler gemaAccessDeniedHandler;

    @Autowired
    private GemaAuthenticationEntryPoint  gemaAuthenticationEntryPoint;

    @Autowired
    private GemaJwtDecoder gemaJwtDecoder;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(oauth2ResourceServer -> {
                    oauth2ResourceServer.jwt(jwtConfigurer -> jwtConfigurer
                            .decoder(gemaJwtDecoder)
                            .jwtAuthenticationConverter(jwtAuthenticationConverter()))
                            .accessDeniedHandler(gemaAccessDeniedHandler)
                            .authenticationEntryPoint(gemaAuthenticationEntryPoint);
                });

        // TODO: allow endpoint
        http.authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests.anyRequest().authenticated());

        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter  jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }
}
