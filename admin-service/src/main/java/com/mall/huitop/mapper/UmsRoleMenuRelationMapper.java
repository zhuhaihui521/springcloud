package com.mall.huitop.mapper;


import com.mall.huitop.entity.UmsRoleMenuRelation;
import com.mall.huitop.entity.UmsRoleMenuRelationExample;
import com.mall.huitop.entity.UmsRoleResourceRelationExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsRoleMenuRelationMapper {

    void deleteByExample(UmsRoleMenuRelationExample example);

    void insert(UmsRoleMenuRelation relation);
}
