package com.mall.huitop.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:35
 */
@Data
@EqualsAndHashCode
public class PmsProductAttributeCategory implements Serializable {
    private Long id;

    private String name;

    @ApiModelProperty(value = "属性数量")
    private Integer attributeCount;

    @ApiModelProperty(value = "参数数量")
    private Integer paramCount;

    private static final long serialVersionUID = 1L;
}
