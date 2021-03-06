package com.mall.huitop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:04
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.mall.huitop.mapper")
@ComponentScan("com.mall.huitop.*")
public class AdminSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminSpringBootApplication.class);
    }

}
