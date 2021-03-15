package com.mall.huitop.task;

import com.mall.huitop.service.OrderIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther zhuhaihui
 * @Date 2021-03-15 22:27
 */
@Component
public class FixedUpdateIdTask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private int i;
    @Autowired
    private OrderIdService orderIdService;

    @Scheduled(cron = "30 */1 * * * ?")
    public void execute() {
        orderIdService.upOrderId();
        logger.info("thread id:{},FixedPrintTask execute times:{}", Thread.currentThread().getId(), ++i);
    }
}
