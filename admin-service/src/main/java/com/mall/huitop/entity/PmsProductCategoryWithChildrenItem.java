package com.mall.huitop.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 19:43
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
}
