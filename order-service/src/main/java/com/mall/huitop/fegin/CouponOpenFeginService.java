package com.mall.huitop.fegin;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeCoupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuhaihui
 * @date 2020-06-08 13:23
 */
@Component
@FeignClient(value = "coupon-service")
public interface CouponOpenFeginService {
    @PostMapping("/findOneByCouponId")
    TradeCoupon findOneByCouponId(@RequestParam("couponId")Long couponId);
    @PostMapping("/updateCouponStatus")
    Result updateCouponStatus(@RequestBody TradeCoupon coupon);
}
