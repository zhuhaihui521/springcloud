package com.mall.huitop.mapper;


import com.mall.huitop.entity.PmsProductLadderExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsProductLadderMapper {
    int deleteByExample(PmsProductLadderExample ladderExample);

}
