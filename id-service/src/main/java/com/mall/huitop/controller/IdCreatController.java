package com.mall.huitop.controller;

import com.mall.huitop.service.OrderIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther zhuhaihui
 * @Date 2021-03-15 22:25
 */
@RestController
@RequestMapping("")
public class IdCreatController {

     @Autowired
     private OrderIdService orderIdService;

     @RequestMapping("/getNo")
     public long getNo(){
         return orderIdService.getOrderNo();
     }
}
