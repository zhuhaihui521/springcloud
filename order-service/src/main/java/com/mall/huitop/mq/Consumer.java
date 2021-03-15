//package com.mall.huitop.mq;
//
//import com.mall.huitop.service.OrderService;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
///**
// * @author zhuhaihui
// * @date 2020-06-02 10:28
// */
//@Service
//@RabbitListener(queues = "miaoshatest")
//public class Consumer {
//    @Autowired
//    private OrderService orderService;
//    @RabbitHandler
//    public void process(@Payload Long productId){
//        orderService.seckill(productId);
//    }
//}
