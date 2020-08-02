package com.mall.huitop.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.mall.huitop.entity.PmsBrand;
import com.mall.huitop.entity.PmsBrandExample;
import com.mall.huitop.mapper.PmsBrandMapper;
import com.mall.huitop.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 19:29
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        pmsBrandExample.setOrderByClause("sort desc");
        PmsBrandExample.Criteria criteria = pmsBrandExample.createCriteria();
        if (StrUtil.isNotEmpty(keyword)){
            criteria.andNameLike("%" + keyword + "%");
        }
        return pmsBrandMapper.selectByExample(pmsBrandExample);
    }
}
