package com.mall.huitop.service.impl;

import com.mall.huitop.entity.PmsProductCategoryWithChildrenItem;
import com.mall.huitop.mapper.PmsProductCategoryMapper;
import com.mall.huitop.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 19:42
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;


    /**
     * 以层级形式获取商品分类
     */
    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return pmsProductCategoryMapper.listWithChildren();
    }
}
