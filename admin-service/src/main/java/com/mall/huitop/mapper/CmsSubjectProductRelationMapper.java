package com.mall.huitop.mapper;


import com.mall.huitop.entity.CmsSubjectProductRelation;
import com.mall.huitop.entity.CmsSubjectProductRelationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CmsSubjectProductRelationMapper {
    CmsSubjectProductRelation selectSubjectProductRelationByProductId(@Param("productId") Long productId);

    int deleteByExample(CmsSubjectProductRelationExample subjectProductRelationExample);
}
