package com.mall.huitop.controller;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeUser;
import com.mall.huitop.entity.TradeUserMoneyLog;
import com.mall.huitop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuhaihui
 * @date 2020-06-08 13:41
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findOneByUserId")
    public TradeUser findOneByUserId(@RequestParam("userId")Long userId){
        return userService.findOneByUserId(userId);
    }

    @PostMapping("/updateMoneyPaid")
    Result updateMoneyPaid(@RequestBody TradeUserMoneyLog userMoneyLog){
       return userService.updateMoneyPaid(userMoneyLog);
    }
}
