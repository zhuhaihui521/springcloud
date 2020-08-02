package com.mall.huitop.mapper;

import com.mall.huitop.entity.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
