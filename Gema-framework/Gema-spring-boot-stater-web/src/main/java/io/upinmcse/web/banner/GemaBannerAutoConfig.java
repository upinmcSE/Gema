package io.upinmcse.web.banner;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class GemaBannerAutoConfig {
    @Bean
    public GemaSpringBootStaterWebApplication staterWebApplication(){
        return new GemaSpringBootStaterWebApplication();
    }
}
