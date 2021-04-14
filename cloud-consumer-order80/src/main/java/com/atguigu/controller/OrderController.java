package com.atguigu.controller;

import com.atguigu.entity.Payment;
import com.atguigu.entity.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {
    public static  String PAYMENT_URL="http://localhost:8001";

    @Resource
    public RestTemplate restTemplate;

    @RequestMapping("/getPayment")
    public Result<Payment> getPayment(@RequestParam("id") int id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/getElementById?id="+id,Result.class);
    };


    @PostMapping("/createPayment")
    public Result createPayment(@RequestBody Payment payment){
       return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,Result.class);
    }
}
