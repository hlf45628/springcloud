package com.atguigu.service.impl;

import com.atguigu.entity.Payment;
import com.atguigu.mapper.PaymentMapper;
import com.atguigu.service.PaymentService;
import com.atguigu.vo.reqvo.PaymentCreateReqVo;
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
}
