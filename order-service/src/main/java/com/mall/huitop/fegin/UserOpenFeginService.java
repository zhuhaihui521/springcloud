package com.mall.huitop.fegin;

import com.mall.huitop.common.Result;
import com.mall.huitop.entity.TradeUser;
import com.mall.huitop.entity.TradeUserMoneyLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuhaihui
 * @date 2020-06-08 13:22
 */
@Component
@FeignClient(value = "user-service")
public interface UserOpenFeginService {

    @PostMapping("/updateMoneyPaid")
    Result updateMoneyPaid(@RequestBody TradeUserMoneyLog userMoneyLog);

    @PostMapping("/findOneByUserId")
    TradeUser findOneByUserId(@RequestParam("userId")Long userId);
}
