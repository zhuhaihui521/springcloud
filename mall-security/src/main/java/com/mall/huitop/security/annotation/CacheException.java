package com.mall.huitop.security.annotation;
import java.lang.annotation.*;

/**
 * 自定义注解，有该注解的缓存方法会抛出异常
 * @author zhuhaihui
 *  @date 2020-07-16 13:38
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
