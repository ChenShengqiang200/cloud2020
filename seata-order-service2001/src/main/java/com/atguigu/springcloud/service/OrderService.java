package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
