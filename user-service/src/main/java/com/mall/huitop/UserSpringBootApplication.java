package com.mall.huitop;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhuhaihui
 * @date 2020-06-08 13:33
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSpringBootApplication.class,args);
    }
}
