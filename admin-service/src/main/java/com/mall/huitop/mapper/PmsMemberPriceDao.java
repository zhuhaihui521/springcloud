package com.mall.huitop.mapper;

import com.mall.huitop.entity.PmsMemberPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PmsMemberPriceDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
