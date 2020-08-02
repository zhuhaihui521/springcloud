package com.mall.huitop.mapper;

import com.mall.huitop.entity.UmsResourceExample;
import com.mall.huitop.entity.UserResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-15 21:57
 */
@Mapper
public interface UmsResourceMapper {


    @Select("select * from ums_resource")
    List<UserResource> listAll();

    List<UserResource> selectByExample(UmsResourceExample example);
}
