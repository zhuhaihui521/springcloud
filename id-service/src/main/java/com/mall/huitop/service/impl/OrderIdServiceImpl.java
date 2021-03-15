package com.mall.huitop.service.impl;

import com.mall.huitop.service.OrderIdService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 生成 自增ID 时间不变 后面ID自增;
 * @Auther zhuhaihui
 * @Date 2021-03-15 20:30
 */
@Service
public class OrderIdServiceImpl implements OrderIdService {
    private AtomicLong atomicLong=new AtomicLong();
    static volatile long orderId=1000000l;
    public static void main(String[] args) {
        System.out.println(orderId);
    }
    @Override
    public long getOrderNo() {
        long b = 0l;
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMddHHmm");
            LocalDateTime localDateTime = LocalDateTime.now();
            b = Long.valueOf(dtf.format(localDateTime) + String.valueOf(orderId+atomicLong.incrementAndGet()));
            System.out.println(Thread.currentThread().getName()+"流水号："+b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    @Override
    public void upOrderId() {
        this.atomicLong = new AtomicLong(0);
    }

}
