package com.mall.huitop.mapper;

import com.mall.huitop.entity.PmsProductCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 19:46
 */
@Mapper
public interface PmsProductCategoryMapper {
    /**
     * 获取商品分类及其子分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
