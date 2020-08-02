package com.mall.huitop.mapper;

import com.mall.huitop.entity.PmsSkuStock;
import com.mall.huitop.entity.PmsSkuStockExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsSkuStockMapper {
    int deleteByExample(PmsSkuStockExample skuStockExample);

    List<PmsSkuStock> selectByExample(PmsSkuStockExample skuStockExample);

    int updateByPrimaryKeySelective(PmsSkuStock pmsSkuStock);
}
