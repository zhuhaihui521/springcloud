package com.mall.huitop.service.impl;

import com.mall.huitop.common.Result;
import com.mall.huitop.common.ShopCode;
import com.mall.huitop.entity.TradeCoupon;
import com.mall.huitop.exception.CastException;
import com.mall.huitop.mapper.TradeCouponMapper;
import com.mall.huitop.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuhaihui
 * @date 2020-06-08 14:56
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private TradeCouponMapper tradeCouponMapper;

    @Override
    public TradeCoupon findOneByCouponId(Long couponId) {
        return tradeCouponMapper.selectByPrimaryKey(couponId);
    }

    @Override
    @Transactional
    public Result updateCouponStatus(TradeCoupon coupon) {
        if(coupon==null||coupon.getCouponId()==null){
            Result.ofFail(ShopCode.SHOP_REQUEST_PARAMETER_VALID.getCode(),ShopCode.SHOP_REQUEST_PARAMETER_VALID.getMessage());
        }
        //更新优惠券状态
        tradeCouponMapper.updateByPrimaryKey(coupon);
        return Result.ofSuccess(ShopCode.SHOP_SUCCESS.getMessage());
    }
}
