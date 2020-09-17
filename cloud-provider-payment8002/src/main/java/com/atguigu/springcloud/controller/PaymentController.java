package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@ResponseBody
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody  Payment payment) {
        int result=paymentService.create(payment);
        log.info("*********插入结果2"+result);
        if(result>0){
            return new CommonResult(200,"插入成功 port:"+port,result);
        }else {
            return new CommonResult(444, "插入失败port:"+port,null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment=paymentService.getPaymentById(id);
        log.info("*********插入结果"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功port:"+port,payment);
        }else {
            return new CommonResult(444, "没有对应记录，查询id"+id+"---port:"+port, null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }
}
