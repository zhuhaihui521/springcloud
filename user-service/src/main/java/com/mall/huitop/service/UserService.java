package com.mall.huitop.service;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeUser;
import com.mall.huitop.entity.TradeUserMoneyLog;

/**
 * @author zhuhaihui
 * @date 2020-06-08 13:45
 */
public interface UserService {
    TradeUser findOneByUserId(Long userId);

    Result updateMoneyPaid(TradeUserMoneyLog userMoneyLog);
}
