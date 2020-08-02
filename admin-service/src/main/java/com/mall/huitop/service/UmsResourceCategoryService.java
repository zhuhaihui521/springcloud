package com.mall.huitop.service;

import com.mall.huitop.entity.UmsResourceCategory;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-19 22:55
 */
public interface UmsResourceCategoryService {
    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(UmsResourceCategory umsResourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, UmsResourceCategory umsResourceCategory);

    /**
     * 删除资源分类
     */
    int delete(Long id);
}
