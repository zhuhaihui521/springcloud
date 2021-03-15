package com.mall.huitop.event;

import com.mall.huitop.dto.OrderDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 下单完成发短信事件
 */
public class OrderEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    @Getter
    private OrderDto orderDto;
    public OrderEvent(Object source, OrderDto orderDto) {
        super(source);
        this.orderDto=orderDto;
    }
}
