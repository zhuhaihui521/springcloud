package com.mall.huitop.controller;


import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeOrder;
import com.mall.huitop.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private IOrderService iorderService;

    @RequestMapping("/confirm")
    public Result confirmOrder(@RequestBody TradeOrder tradeOrder)
    {
        return iorderService.confirmOrder(tradeOrder);
    }
}
