package com.atguigu.service;

import com.atguigu.entity.Payment;
import com.atguigu.entity.Result;
import com.atguigu.vo.PaymentCreateReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(value ="cloud-payment-service",fallback =PaymentFallbackService.class)
@Component
public interface PaymentService {

    @RequestMapping(value = "payment/getElementById",method = RequestMethod.GET)
    public Result<Payment> getElementById(@RequestParam(value ="id") int id);

    @RequestMapping(value ="payment/create",method = RequestMethod.POST)
    public Result createPayment(@RequestBody PaymentCreateReqVo req);

    @GetMapping("payment/read/timeout")
    public String readTimeOut(@RequestParam("id") int id);

}
