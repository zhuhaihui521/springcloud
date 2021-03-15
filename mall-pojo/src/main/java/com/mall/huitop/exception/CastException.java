package com.mall.huitop.exception;

import com.mall.huitop.common.ShopCode;

/**
 * 异常抛出类
 */
public class CastException {
    public static void cast(ShopCode shopCode) {
        throw new CustomerException(shopCode);
    }
}
