package com.mall.huitop.mapper;


import com.mall.huitop.entity.PmsProductFullReductionExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsProductFullReductionMapper {
    int deleteByExample(PmsProductFullReductionExample fullReductionExample);
}
