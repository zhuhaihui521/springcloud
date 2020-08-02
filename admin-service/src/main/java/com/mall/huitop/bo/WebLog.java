package com.mall.huitop.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuhaihui
 * @date 2020-07-16 13:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebLog {
    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    private Long startTime;

    /**
     * 消耗时间
     */
    private Integer spendTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    private Object parameter;

    private Object result;
}
