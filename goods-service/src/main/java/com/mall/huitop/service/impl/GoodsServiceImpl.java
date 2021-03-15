package com.mall.huitop.service.impl;

import com.mall.huitop.common.Result;
import com.mall.huitop.common.ShopCode;
import com.mall.huitop.entity.TradeGoods;
import com.mall.huitop.entity.TradeGoodsNumberLog;
import com.mall.huitop.exception.CastException;
import com.mall.huitop.mapper.GoodsMapper;
import com.mall.huitop.mapper.GoodsNumberLogMapper;
import com.mall.huitop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsNumberLogMapper goodsNumberLogMapper;

    @Override
    public TradeGoods findOne(Long goodsId) {
        if (goodsId == null) {
            CastException.cast(ShopCode.SHOP_REQUEST_PARAMETER_VALID);
        }
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    @Override
    @Transactional
    public Result reduceGoodsNum(TradeGoodsNumberLog goodsNumberLog) {
        if (goodsNumberLog == null ||
                goodsNumberLog.getGoodsNumber() == null ||
                goodsNumberLog.getOrderId() == null ||
                goodsNumberLog.getGoodsNumber() == null ||
                goodsNumberLog.getGoodsNumber().intValue() <= 0) {
           return Result.ofFail(ShopCode.SHOP_REQUEST_PARAMETER_VALID.getCode(),ShopCode.SHOP_REQUEST_PARAMETER_VALID.getMessage());
        }
        TradeGoods goods = goodsMapper.selectByPrimaryKey(goodsNumberLog.getGoodsId());
        if(goods.getGoodsNumber()<goodsNumberLog.getGoodsNumber()){
            //库存不足
            return Result.ofFail(ShopCode.SHOP_GOODS_NUM_NOT_ENOUGH.getMessage());
        }
        //减库存
        goods.setGoodsNumber(goods.getGoodsNumber()-goodsNumberLog.getGoodsNumber());
        goodsMapper.updateByPrimaryKey(goods);

        //记录库存操作日志
        goodsNumberLog.setGoodsNumber(-(goodsNumberLog.getGoodsNumber()));
        goodsNumberLog.setLogTime(new Date());
        goodsNumberLogMapper.insert(goodsNumberLog);

        return Result.ofSuccess(ShopCode.SHOP_SUCCESS.getMessage());
    }
}
