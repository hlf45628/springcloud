package com.atguigu.service.impl;

import com.atguigu.entity.Payment;
import com.atguigu.mapper.PaymentMapper;
import com.atguigu.service.PaymentService;
import com.atguigu.vo.reqvo.PaymentCreateReqVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl  implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int createPayment(PaymentCreateReqVo req) {
        return paymentMapper.create(new Payment(null,req.getSerial()));
    }

    @Override
    public Payment queryPaymentById(int id) {
        return paymentMapper.getPaymentById(id);
    }

    @HystrixCommand(fallbackMethod = "paymentInfoHandle",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "1"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String paymentInfo_timeout(){
        try {

        }catch (Exception e){
           e.printStackTrace();
        }
        return Thread.currentThread().getName()+"调用成功";
    }

    public String paymentInfoHandle(){
       return  Thread.currentThread().getName()+"异常处理信息，请稍后再试，/(ㄒoㄒ)/-->";
    }
}
