package com.mall.huitop.mapper;


import com.mall.huitop.dto.PmsProductResult;
import com.mall.huitop.entity.CmsPrefrenceAreaProductRelation;
import com.mall.huitop.entity.CmsSubjectProductRelation;
import com.mall.huitop.entity.PmsProduct;
import com.mall.huitop.entity.PmsProductExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PmsProductMapper {
    /**
     * 根据条件查询商品
     * @param pmsProductExample
     * @return
     */
    List<PmsProduct> selectByExample(PmsProductExample pmsProductExample);

    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    PmsProductResult getUpdateInfo(@Param("id") Long id);

    void updateByPrimaryKeySelective(PmsProduct product);

    CmsPrefrenceAreaProductRelation selectPrefrenceAreaProductRelationByProductId(@Param("productId")Long productId);

    CmsSubjectProductRelation selectSubjectProductRelationByProductId(@Param("productId") Long productId);

}
