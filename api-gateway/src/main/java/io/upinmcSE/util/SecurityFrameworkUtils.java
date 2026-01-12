package io.upinmcSE.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
public class SecurityFrameworkUtils {
    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String AUTHORIZATION_BEARER = "Bearer";

    private SecurityFrameworkUtils() {}

    public static String obtainAuthorization(ServerWebExchange exchange){
        String authorization = exchange.getRequest().getHeaders().getFirst(AUTHORIZATION_HEADER);
        if(!StringUtils.hasText(authorization)){
            return null;
        }
        int index = authorization.indexOf(AUTHORIZATION_BEARER);
        if(index == -1){
            return null;
        }
        return authorization.substring(index + AUTHORIZATION_BEARER.length()).trim();
    }


}
