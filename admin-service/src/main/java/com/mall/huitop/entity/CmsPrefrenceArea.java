package com.mall.huitop.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:42
 */
@Data
@EqualsAndHashCode
public class CmsPrefrenceArea implements Serializable {
    private Long id;

    private String name;

    private String subTitle;

    private Integer sort;

    private Integer showStatus;

    @ApiModelProperty(value = "展示图片")
    private byte[] pic;

    private static final long serialVersionUID = 1L;
}
