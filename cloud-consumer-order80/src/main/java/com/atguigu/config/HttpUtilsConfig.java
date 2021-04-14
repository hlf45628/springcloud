package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class HttpUtilsConfig {

    @Bean
    public RestTemplate getRestTemplte(){
        return  new RestTemplate();
    }
}
