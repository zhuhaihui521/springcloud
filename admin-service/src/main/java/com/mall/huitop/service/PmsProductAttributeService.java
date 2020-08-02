package com.mall.huitop.service;

import com.mall.huitop.entity.PmsProductAttribute;

import java.util.List;

public interface PmsProductAttributeService {
    /**
     *根据分类分页获取商品属性
     * @param cid    分类id
     * @param type  0->属性；2->参数
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);
}
