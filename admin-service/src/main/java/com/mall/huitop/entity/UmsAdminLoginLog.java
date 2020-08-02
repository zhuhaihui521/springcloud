package com.mall.huitop.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-15 20:53
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class UmsAdminLoginLog implements Serializable {
    private Long id;

    private Long adminId;

    private Date createTime;

    private String ip;

    private String address;

    @ApiModelProperty(value = "浏览器登录类型")
    private String userAgent;

    private static final long serialVersionUID = 1L;
}
