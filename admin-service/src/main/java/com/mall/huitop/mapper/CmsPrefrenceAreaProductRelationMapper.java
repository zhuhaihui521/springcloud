package com.mall.huitop.mapper;


import com.mall.huitop.entity.CmsPrefrenceAreaProductRelation;
import com.mall.huitop.entity.CmsPrefrenceAreaProductRelationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CmsPrefrenceAreaProductRelationMapper {
    int deleteByExample(CmsPrefrenceAreaProductRelationExample prefrenceAreaExample);

    CmsPrefrenceAreaProductRelation selectPrefrenceAreaProductRelationByProductId(@Param("productId")Long productId);
}
