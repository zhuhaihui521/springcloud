package com.mall.huitop.service.impl;

import com.mall.huitop.common.Result;
import com.mall.huitop.common.ShopCode;
import com.mall.huitop.entity.TradeUser;
import com.mall.huitop.entity.TradeUserMoneyLog;
import com.mall.huitop.entity.TradeUserMoneyLogExample;
import com.mall.huitop.exception.CastException;
import com.mall.huitop.mapper.TradeUserMoneyLogMapper;
import com.mall.huitop.mapper.UserMapper;
import com.mall.huitop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhuhaihui
 * @date 2020-06-08 13:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TradeUserMoneyLogMapper userMoneyLogMapper;
    @Override
    public TradeUser findOneByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional
    public Result updateMoneyPaid(TradeUserMoneyLog userMoneyLog) {
        //1.校验参数是否合法
        if(userMoneyLog==null ||
                userMoneyLog.getUserId()==null ||
                userMoneyLog.getOrderId()==null ||
                userMoneyLog.getUseMoney()==null||
                userMoneyLog.getUseMoney().compareTo(BigDecimal.ZERO)<=0){
            return Result.ofFail(ShopCode.SHOP_REQUEST_PARAMETER_VALID.getCode(),ShopCode.SHOP_REQUEST_PARAMETER_VALID.getMessage());
        }

        //2.查询订单余额使用日志
        TradeUserMoneyLogExample userMoneyLogExample = new TradeUserMoneyLogExample();
        TradeUserMoneyLogExample.Criteria criteria = userMoneyLogExample.createCriteria();
        criteria.andOrderIdEqualTo(userMoneyLog.getOrderId());
        criteria.andUserIdEqualTo(userMoneyLog.getUserId());
        int r = userMoneyLogMapper.countByExample(userMoneyLogExample);

        TradeUser tradeUser = userMapper.selectByPrimaryKey(userMoneyLog.getUserId());

        //3.扣减余额...
        if(userMoneyLog.getMoneyLogType().intValue()==ShopCode.SHOP_USER_MONEY_PAID.getCode().intValue()){
            if(r>0){
                //已经付款
                CastException.cast(ShopCode.SHOP_ORDER_PAY_STATUS_IS_PAY);
            }
            //减余额
            tradeUser.setUserMoney(new BigDecimal(tradeUser.getUserMoney()).subtract(userMoneyLog.getUseMoney()).longValue());
            userMapper.updateByPrimaryKey(tradeUser);
        }
        //4.回退余额...
        if(userMoneyLog.getMoneyLogType().intValue()==ShopCode.SHOP_USER_MONEY_REFUND.getCode().intValue()){
            if(r<0){
                //如果没有支付,则不能回退余额
                CastException.cast(ShopCode.SHOP_ORDER_PAY_STATUS_NO_PAY);
            }
            //防止多次退款
            TradeUserMoneyLogExample userMoneyLogExample2 = new TradeUserMoneyLogExample();
            TradeUserMoneyLogExample.Criteria criteria1 = userMoneyLogExample2.createCriteria();
            criteria1.andOrderIdEqualTo(userMoneyLog.getOrderId());
            criteria1.andUserIdEqualTo(userMoneyLog.getUserId());
            criteria1.andMoneyLogTypeEqualTo(ShopCode.SHOP_USER_MONEY_REFUND.getCode());
            int r2 = userMoneyLogMapper.countByExample(userMoneyLogExample2);
            if(r2>0){
                CastException.cast(ShopCode.SHOP_USER_MONEY_REFUND_ALREADY);
            }
            //退款
            tradeUser.setUserMoney(new BigDecimal(tradeUser.getUserMoney()).add(userMoneyLog.getUseMoney()).longValue());
            userMapper.updateByPrimaryKey(tradeUser);
        }
        //5.记录订单余额使用日志
        userMoneyLog.setCreateTime(new Date());
        userMoneyLogMapper.insert(userMoneyLog);
        return Result.ofSuccess("哈哈");

    }
}
