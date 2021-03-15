package com.mall.huitop;

import com.mall.huitop.event.OrderEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Observable;

/**
 * 它们两者之间需要什么关联呢
 */
@Component
public class MessageListener implements SmartApplicationListener {
    /**
     * 支持的事件类型
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == OrderEvent.class;
    }

    /**
     * 支持的事件源所在的类
     * @param sourceType
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

    /**
     * 定义事件监听器的顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        OrderEvent orderEvent = (OrderEvent) event;
        System.out.println("=====短信发送成功=====");
    }

}
