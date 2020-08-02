package com.mall.huitop.service.impl;

import com.mall.huitop.entity.CmsPrefrenceArea;
import com.mall.huitop.entity.CmsPrefrenceAreaExample;
import com.mall.huitop.mapper.CmsPrefrenceAreaMapper;
import com.mall.huitop.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:42
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
