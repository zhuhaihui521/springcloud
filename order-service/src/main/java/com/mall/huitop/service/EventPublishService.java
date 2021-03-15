package com.mall.huitop.service;

/**
 * 事件发布service
 * @param <T>
 */
public interface EventPublishService<T> {
  /**
   * 发布事件
   * @param event
   */
  void publishEvent(T event);
}
