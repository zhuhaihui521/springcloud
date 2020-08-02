package com.mall.huitop.mapper;

import com.mall.huitop.entity.PmsProductAttributeValueExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsProductAttributeValueMapper {
    int deleteByExample(PmsProductAttributeValueExample productAttributeValueExample);
}
