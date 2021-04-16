package com.atguigu.service;

import com.atguigu.entity.Payment;
import com.atguigu.entity.Result;
import com.atguigu.vo.PaymentCreateReqVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class PaymentFallbackService  implements  PaymentService{
    @Override
    public Result<Payment> getElementById(int id) {
        return new Result<>("500","PaymentFallbackService getElementById fallback o(╥﹏╥)o",null);
    }

    @Override
    public Result createPayment(PaymentCreateReqVo req) {
        return new Result<>("500","PaymentFallbackService createPayment fallback o(╥﹏╥)o",null);
    }

    @Override
    public String readTimeOut(@RequestParam("id") int id) {
        return "PaymentFallbackService  readTimeOut o(╥﹏╥)o";
    }
}
