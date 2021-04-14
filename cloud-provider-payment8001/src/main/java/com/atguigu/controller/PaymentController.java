package com.atguigu.controller;

import com.atguigu.entity.Payment;
import com.atguigu.entity.Result;
import com.atguigu.service.PaymentService;
import com.atguigu.vo.reqvo.PaymentCreateReqVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController()
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/getElementById",method = RequestMethod.GET)
    public Result<Payment> getElementById(@RequestParam(value ="id") int id){
        return  new Result<>("查询成功","200",paymentService.queryPaymentById(id));
    };

    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public Result createPayment(@RequestBody PaymentCreateReqVo req){
        int result=paymentService.createPayment(req);
        if(result>0){
            return new Result("200","创建成功", null);
        }else {
            System.out.println(111);
            return  new Result("333","创建失败",null);
        }
    }
}
