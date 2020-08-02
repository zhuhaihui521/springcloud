package com.mall.huitop.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:49
 */
public class PmsProductResult extends PmsProductParam {
    @Getter
    @Setter
    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}
