package com.mall.huitop.mapper;


import com.mall.huitop.entity.PmsProductAttribute;
import com.mall.huitop.entity.PmsProductAttributeExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsProductAttributeMapper {
    List<PmsProductAttribute> selectByExample(PmsProductAttributeExample example);
}
