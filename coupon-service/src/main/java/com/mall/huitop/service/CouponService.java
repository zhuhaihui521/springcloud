package com.mall.huitop.service;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeCoupon;

/**
 * @author zhuhaihui
 * @date 2020-06-08 14:56
 */
public interface CouponService {
    TradeCoupon findOneByCouponId(Long userId);
     Result updateCouponStatus(TradeCoupon coupon);

}
