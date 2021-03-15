package com.mall.huitop.service.impl;

import com.mall.huitop.service.EventPublishService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

/**
 * spring提供的事件发布机制 发布事件类型大多都是ApplicationEvent; 就相当于放到服务器消息
 */
@Service
public class EventPublishServiceImpl implements EventPublishService<ApplicationEvent>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
