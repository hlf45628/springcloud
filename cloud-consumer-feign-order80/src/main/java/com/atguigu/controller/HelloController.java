package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${application.user.name}")
    private  String username;

    @Value("${application.user.password}")
    private  String password;

    @RequestMapping("/hello")
    public String getHello(){
        return "username="+username+"))((password="+password;
    }
}
