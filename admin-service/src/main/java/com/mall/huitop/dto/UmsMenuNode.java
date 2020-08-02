package com.mall.huitop.dto;

import com.mall.huitop.entity.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-18 11:17
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}
