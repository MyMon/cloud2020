package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentCallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK 备选方法";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {

        return "paymentInfo_TimeOut 备选方法";
    }
}
