package com.mall.huitop.service;

import com.mall.huitop.entity.PmsProductAttributeCategory;

import java.util.List;

public interface PmsProductAttributeCategoryService {
    /**
     * 分页查询属性分类
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);
}
