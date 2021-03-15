package com.mall.huitop.service;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeOrder;

public interface IOrderService {
    /**
     * 下单接口
     * @param order
     * @return
     */
     Result confirmOrder(TradeOrder order);
}
