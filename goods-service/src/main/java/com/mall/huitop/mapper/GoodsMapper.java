package com.mall.huitop.mapper;

import com.mall.huitop.entity.TradeGoods;
import com.mall.huitop.entity.TradeGoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface GoodsMapper {
    int countByExample(TradeGoodsExample example);

    int deleteByExample(TradeGoodsExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(TradeGoods record);

    int insertSelective(TradeGoods record);

    List<TradeGoods> selectByExample(TradeGoodsExample example);

    TradeGoods selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") TradeGoods record, @Param("example") TradeGoodsExample example);

    int updateByExample(@Param("record") TradeGoods record, @Param("example") TradeGoodsExample example);

    int updateByPrimaryKeySelective(TradeGoods record);

    int updateByPrimaryKey(TradeGoods record);
}
