package com.mall.huitop.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-15 17:55
 */
@Component
@RocketMQMessageListener(topic = "test",consumerGroup = "test")
public class TestMQ implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt messageExt) {
        System.out.println("hahahahahahhahahaaha");
    }
}
