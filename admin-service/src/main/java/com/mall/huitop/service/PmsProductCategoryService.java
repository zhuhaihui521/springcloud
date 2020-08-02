package com.mall.huitop.service;

import com.mall.huitop.entity.PmsProductCategoryWithChildrenItem;

import java.util.List;

public interface PmsProductCategoryService {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();


}
