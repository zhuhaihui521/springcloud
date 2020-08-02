package com.mall.huitop.mapper;

import com.mall.huitop.entity.PmsProductAttributeCategory;
import com.mall.huitop.entity.PmsProductAttributeCategoryExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:37
 */
@Mapper
public interface PmsProductAttributeCategoryMapper {
     List<PmsProductAttributeCategory> selectByExample(PmsProductAttributeCategoryExample pmsProductAttributeCategoryExample);

}
