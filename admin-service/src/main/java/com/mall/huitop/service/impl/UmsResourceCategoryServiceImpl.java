package com.mall.huitop.service.impl;

import com.mall.huitop.entity.UmsResourceCategory;
import com.mall.huitop.entity.UmsResourceCategoryExample;
import com.mall.huitop.mapper.UmsResourceCategoryMapper;
import com.mall.huitop.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源分类service
 * @Auther zhuhaihui
 * @Date 2020-07-19 22:56
 */
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    @Autowired(required = false)
    private UmsResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<UmsResourceCategory> listAll() {
        UmsResourceCategoryExample example = new UmsResourceCategoryExample();
        example.setOrderByClause("sort desc");
        return resourceCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(UmsResourceCategory umsResourceCategory) {
        return 0;
    }

    @Override
    public int update(Long id, UmsResourceCategory umsResourceCategory) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
