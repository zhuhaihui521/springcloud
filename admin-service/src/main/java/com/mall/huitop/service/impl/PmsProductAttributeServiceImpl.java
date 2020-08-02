package com.mall.huitop.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.huitop.entity.PmsProductAttribute;
import com.mall.huitop.entity.PmsProductAttributeExample;
import com.mall.huitop.mapper.PmsProductAttributeMapper;
import com.mall.huitop.service.PmsProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:26
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;

    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return productAttributeMapper.selectByExample(example);
    }
}
