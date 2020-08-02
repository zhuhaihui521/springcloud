package com.mall.huitop.mapper;


import com.mall.huitop.entity.CmsSubject;
import com.mall.huitop.entity.CmsSubjectExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsSubjectMapper {
    List<CmsSubject> selectByExample(CmsSubjectExample cmsSubjectExample);
}
