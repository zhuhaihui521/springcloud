package com.mall.huitop.mapper;

import com.mall.huitop.entity.UmsResourceCategory;
import com.mall.huitop.entity.UmsResourceCategoryExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-19 22:57
 */
@Mapper
public interface UmsResourceCategoryMapper {

    List<UmsResourceCategory> selectByExample(UmsResourceCategoryExample example);
}
