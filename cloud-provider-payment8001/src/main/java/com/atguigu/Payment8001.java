package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class Payment8001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class);
    }
}
