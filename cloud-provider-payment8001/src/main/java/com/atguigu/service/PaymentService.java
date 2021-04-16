package com.atguigu.service;

import com.atguigu.entity.Payment;
import com.atguigu.vo.reqvo.PaymentCreateReqVo;

public interface PaymentService {

    public int createPayment(PaymentCreateReqVo req);

    public Payment queryPaymentById(int id);

    public String paymentInfo_timeout() ;
}
