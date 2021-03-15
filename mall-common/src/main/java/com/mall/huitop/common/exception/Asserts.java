package com.mall.huitop.common.exception;

import com.mall.huitop.common.api.IErrorCode;

/**
 * @author zhuhaihui
 * @date 2020-07-16 13:37
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
