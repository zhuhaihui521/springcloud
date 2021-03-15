package com.mall.huitop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhuhaihui
 * @date 2020-06-08 13:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CouponSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponSpringBootApplication.class,args);
    }
}
