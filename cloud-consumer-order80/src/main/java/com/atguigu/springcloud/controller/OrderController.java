package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@Slf4j
@RequestMapping("/consumer/payment")
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

//    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL="http://cloud-payment-service";

    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @RequestMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}


