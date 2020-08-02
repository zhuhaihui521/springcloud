package com.mall.huitop.mapper;


import com.mall.huitop.entity.PmsBrand;
import com.mall.huitop.entity.PmsBrandExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsBrandMapper {
    /**
     * 根据条件查询
     * @param pmsBrandExample
     * @return
     */
    List<PmsBrand> selectByExample(PmsBrandExample pmsBrandExample);
}
