package com.mall.huitop.fegin;


import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeGoods;
import com.mall.huitop.entity.TradeGoodsNumberLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "goods-service")
public interface GoodsOpenFeginService {

    @PostMapping(value = "findOne")
    TradeGoods findOne(@RequestParam("longId")Long longId);


    @PostMapping(value ="/reduceGoodsNum")
    Result reduceGoodsNum(@RequestBody TradeGoodsNumberLog goodsNumberLog);


}
