package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    // http://localhost:8001/payment/create?serial=alllttae直接插入
    // 如果是order80调用，传payment需要加@RequestBody!
    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);

        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功" + port, null);
        }
        return new CommonResult<>(444, "插入数据库失败" + port, null);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果: " + payment);

        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功" + port, payment);
        }
        return new CommonResult<Payment>(444, "查询失败" + port, null);
    }

}
