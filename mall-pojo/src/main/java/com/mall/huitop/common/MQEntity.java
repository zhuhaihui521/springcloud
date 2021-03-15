package com.mall.huitop.common;

import java.math.BigDecimal;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-15 20:29
 */
public class MQEntity {
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 优惠卷id
     */
    private Long couponId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户金额
     */
    private BigDecimal userMoney;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品总数
     */
    private Integer goodsNum;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
