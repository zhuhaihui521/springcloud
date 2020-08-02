package com.mall.huitop.mapper;


import com.mall.huitop.entity.CmsPrefrenceArea;
import com.mall.huitop.entity.CmsPrefrenceAreaExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsPrefrenceAreaMapper {
    List<CmsPrefrenceArea> selectByExample(CmsPrefrenceAreaExample cmsPrefrenceAreaExample);
}
