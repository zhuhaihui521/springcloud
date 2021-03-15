package com.mall.huitop.exception;


import com.mall.huitop.common.ShopCode;

/**
 * 自定义异常
 */
public class CustomerException extends RuntimeException{

    private ShopCode shopCode;

    public CustomerException(ShopCode shopCode) {
        this.shopCode = shopCode;
    }
}
