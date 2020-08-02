package com.mall.huitop;

import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.security.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuhaihui
 * @date 2020-07-17 9:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void addUserAdmin() throws Exception {
        UserAdmin zhuhaihui = (UserAdmin) redisService.get("mall:ums:admin:zhuhaihui");
        System.out.println(zhuhaihui);

    }
}
