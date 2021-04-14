package com.atguigu.mapper;

import com.atguigu.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    /**
     * 创建支付订单
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 通过支付的id查询支付单
     * @param id
     * @return
     */
    public  Payment getPaymentById(int id);
}
