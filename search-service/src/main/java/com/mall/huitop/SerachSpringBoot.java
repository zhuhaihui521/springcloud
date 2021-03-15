package com.mall.huitop;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan(basePackages = "com.mall.huitop.dao")
public class SerachSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(SerachSpringBoot.class,args);
    }
}
