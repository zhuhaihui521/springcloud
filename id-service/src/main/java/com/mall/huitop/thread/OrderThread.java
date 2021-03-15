package com.mall.huitop.thread;

import com.mall.huitop.service.OrderIdService;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther zhuhaihui
 * @Date 2021-03-15 20:41
 */
public class OrderThread implements Runnable {

    private CountDownLatch latch;
    private OrderIdService orderIdService;

    public OrderThread(CountDownLatch latch,OrderIdService orderIdService){
        this.latch=latch;
        this.orderIdService=orderIdService;
    }
    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"订单号："+orderIdService.getOrderNo());
    }
}
