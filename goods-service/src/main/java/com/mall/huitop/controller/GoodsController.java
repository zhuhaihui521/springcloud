package com.mall.huitop.controller;


import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeGoods;
import com.mall.huitop.entity.TradeGoodsNumberLog;
import com.mall.huitop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/findOne")
    public TradeGoods findOne(@RequestParam("longId")Long longId){
       return goodsService.findOne(longId);
    }

    @PostMapping("/reduceGoodsNum")
    public Result reduceGoodsNum(@RequestBody TradeGoodsNumberLog goodsNumberLog){
        System.out.println(Integer.MAX_VALUE);
        return goodsService.reduceGoodsNum(goodsNumberLog);
    }

    public static void main(String[] args) {
        testLock();
    }
    public static void testLock(){
        ReentrantLock reentrantLock= new ReentrantLock(true);
        reentrantLock.lock();
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread());
        Integer a= 200;
        Integer b= 200;
        System.out.println(a.intValue() == b.intValue());
        reentrantLock.unlock();
    }

}
