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
 * @Date 2020-07-15 19:50
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class UserResource implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源URL")
    private String url;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "资源分类ID")
    private Long categoryId;

    private static final long serialVersionUID = 1L;
}
