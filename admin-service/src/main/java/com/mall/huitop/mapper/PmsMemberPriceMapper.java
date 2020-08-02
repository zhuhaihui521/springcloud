package com.mall.huitop.mapper;

import com.mall.huitop.entity.PmsMemberPriceExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsMemberPriceMapper {
    int deleteByExample(PmsMemberPriceExample pmsMemberPriceExample);
}
