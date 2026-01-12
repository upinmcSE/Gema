package io.upinmcSE.filter.security;

import io.micrometer.common.util.StringUtils;
import io.upinmcSE.VerifySessionReq;
import io.upinmcSE.exception.enums.GlobalErrorCodeConstants;
import io.upinmcSE.pojo.CommonResult;
import io.upinmcSE.repository.IdentityClient;
import io.upinmcSE.util.SecurityFrameworkUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import tools.jackson.databind.ObjectMapper;

@Component
public class TokenAuthenticationFilter implements GlobalFilter, Ordered {

    ObjectMapper objectMapper;

    private final IdentityClient identityClient;

    public TokenAuthenticationFilter(IdentityClient identityClient) {
        this.identityClient = identityClient;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = SecurityFrameworkUtils.obtainAuthorization(exchange);
        if (StringUtils.isEmpty(token)) {
            return chain.filter(exchange);
        }

        return identityClient.introspect(VerifySessionReq.builder().token(token).build()).flatMap(introspectResponse -> {
            if (introspectResponse.getData().isValid())
                return chain.filter(exchange);
            else
                return unauthenticated(exchange.getResponse());
        }).onErrorResume(throwable -> unauthenticated(exchange.getResponse()));

    }

    @Override
    public int getOrder() {
        return -100;
    }

    Mono<Void> unauthenticated(ServerHttpResponse response){
        CommonResult<?> apiResponse = CommonResult.error(GlobalErrorCodeConstants.UNAUTHORIZED);

        String body = null;
        try {
            body = objectMapper.writeValueAsString(apiResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return response.writeWith(
                Mono.just(response.bufferFactory().wrap(body.getBytes())));
    }
}
