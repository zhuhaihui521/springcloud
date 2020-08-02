package com.mall.huitop.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.huitop.entity.PmsProductAttributeCategory;
import com.mall.huitop.entity.PmsProductAttributeCategoryExample;
import com.mall.huitop.mapper.PmsProductAttributeCategoryMapper;
import com.mall.huitop.service.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:35
 */
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

    @Override
    public List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsProductAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());

    }
}
