package com.mall.huitop.service;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeGoods;
import com.mall.huitop.entity.TradeGoodsNumberLog;

public interface GoodsService {
    /**
     * 根据ID查询商品对象
     * @param goodsId
     * @return
     */
    TradeGoods findOne(Long goodsId);

    /**
     * 扣减库存
     * @param goodsNumberLog
     * @return
     */
    Result reduceGoodsNum(TradeGoodsNumberLog goodsNumberLog);
}
