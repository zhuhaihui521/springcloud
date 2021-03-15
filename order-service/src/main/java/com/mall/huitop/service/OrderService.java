package com.mall.huitop.service;

import com.mall.huitop.entity.Order;

/**
 * @author zhuhaihui
 * @date 2020-06-02 10:11
 */

public interface OrderService {
    public void seckill(Long productId);
    public int saveOrder(Order order);
}
