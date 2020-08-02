package com.mall.huitop.mapper;


import com.mall.huitop.entity.UmsRoleResourceRelation;
import com.mall.huitop.entity.UmsRoleResourceRelationExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsRoleResourceRelationMapper {


    void insert(UmsRoleResourceRelation relation);

    void deleteByExample(UmsRoleResourceRelationExample example);
}
