package com.mall.huitop.mq;

import com.alibaba.fastjson.JSON;
import com.mall.huitop.common.MQEntity;
import com.mall.huitop.common.ShopCode;
import com.mall.huitop.entity.TradeOrder;
import com.mall.huitop.mapper.TradeOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-15 16:57
 */
@Slf4j
@Component
@RocketMQMessageListener(nameServer = "${rocketmq.nameserver}",topic = "orderTopic",consumerGroup = "order_orderTopic_cancel_group",messageModel = MessageModel.BROADCASTING)
public class CancelMQListener implements RocketMQListener<MessageExt> {

    @Autowired
    private TradeOrderMapper orderMapper;
    @Override
    public void onMessage(MessageExt messageExt) {
        try {
            //1. 解析消息内容
            String body = new String(messageExt.getBody(),"UTF-8");
            MQEntity mqEntity = JSON.parseObject(body, MQEntity.class);
            log.info("接受消息成功"+body);
            //2. 查询订单
            TradeOrder order = orderMapper.selectByPrimaryKey(mqEntity.getOrderId());
            //3.更新订单状态为取消
            order.setOrderStatus(ShopCode.SHOP_ORDER_CANCEL.getCode());
            orderMapper.updateByPrimaryKey(order);
            log.info("订单状态设置为取消");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.info("订单取消失败");
        }
    }

}
