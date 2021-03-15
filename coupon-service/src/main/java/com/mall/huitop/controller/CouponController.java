package com.mall.huitop.controller;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeCoupon;
import com.mall.huitop.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuhaihui
 * @date 2020-06-08 14:47
 */
@RestController
@RequestMapping("")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/findOneByCouponId")
    public TradeCoupon findOneByCouponId(@RequestParam("couponId")Long couponId){
        return couponService.findOneByCouponId(couponId);
    }

    @PostMapping("/updateCouponStatus")
    Result updateCouponStatus(@RequestBody TradeCoupon coupon){
        return couponService.updateCouponStatus(coupon);
    }
}
