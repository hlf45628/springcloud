package com.atguigu.controller;

import com.atguigu.entity.Payment;
import com.atguigu.entity.Result;
import com.atguigu.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private PaymentService paymentService;


    @GetMapping("/getPaymentById")
    public Result<Payment> getPaymentById(@RequestParam("id") Integer id){
        return  paymentService.getElementById(id);
    }

    @GetMapping("/read/timeOut")
    public String readTimeOut(@RequestParam("id") int id){
        return paymentService.readTimeOut(id);
    }
}
