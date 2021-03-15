package com.mall.huitop;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-15 17:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderSpringBootTest {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Test
    public void send(){
        Message message = new Message("test","hello".getBytes());
        System.out.println("=============1111");
        try {
            rocketMQTemplate.getProducer().send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
