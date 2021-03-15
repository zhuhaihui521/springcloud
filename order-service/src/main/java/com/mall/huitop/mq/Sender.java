//package com.mall.huitop.mq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author zhuhaihui
// * @date 2020-06-02 10:27
// */
//@Service
//@Slf4j
//public class Sender {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    //@Scheduled(fixedDelay = 1000L)
//    public void send(Long productId){
//        log.info("抢单成功。。。");
//        this.rabbitTemplate.convertAndSend("miaoshatest",productId);
//
//    }
//}
