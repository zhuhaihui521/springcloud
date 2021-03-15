package com.mall.huitop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Auther zhuhaihui
 * @Date 2021-03-15 18:48
 */
@SpringBootApplication
@EnableScheduling
public class IDWorkerSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(IDWorkerSpringBootApplication.class,args);
    }
}
