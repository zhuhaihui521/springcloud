package com.mall.huitop.service.impl;

import com.mall.huitop.entity.CmsSubject;
import com.mall.huitop.entity.CmsSubjectExample;
import com.mall.huitop.mapper.CmsSubjectMapper;
import com.mall.huitop.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:16
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return cmsSubjectMapper.selectByExample(new CmsSubjectExample());
    }
}
