package com.mall.huitop.common.api;

public enum StatusType implements IErrorCode {
    /**
     * 禁用,隐藏,失败,锁定
     */
    ENABLE(0),
    /**
     * 可用,显示,成功
     */
    DISABLE(1),

    /**
     * 显示
     */
    SHOW(1),

    /**
     * 隐藏
     */
    HIDDEN(0);

    private int value;

    private StatusType(int value) {
        this.value = value;
    }
    @Override
    public long getCode() {
        return value;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
