package com.mall.huitop.mapper;


import com.mall.huitop.entity.PmsProductLadder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PmsProductLadderDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
