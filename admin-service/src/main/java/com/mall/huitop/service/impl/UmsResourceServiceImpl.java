package com.mall.huitop.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.mall.huitop.entity.UmsResourceExample;
import com.mall.huitop.entity.UserResource;
import com.mall.huitop.mapper.UmsResourceMapper;
import com.mall.huitop.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-15 21:56
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {
    @Autowired(required = false)
    private UmsResourceMapper resourceMapper;

    /**
     * 查询全部资源
     */
    @Override
    public List<UserResource> listAll() {
        return resourceMapper.listAll();
    }

    @Override
    public List<UserResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        UmsResourceExample example = new UmsResourceExample();
        UmsResourceExample.Criteria criteria = example.createCriteria();
        if (categoryId != null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if (StrUtil.isNotEmpty(nameKeyword)){
            criteria.andNameLike('%'+nameKeyword+'%');
        }
        if (StrUtil.isNotEmpty(urlKeyword)){
            criteria.andUrlLike('%'+urlKeyword+'%');
        }
        return resourceMapper.selectByExample(example);
    }
}

