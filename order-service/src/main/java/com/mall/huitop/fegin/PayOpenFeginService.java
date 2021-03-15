package com.mall.huitop.fegin;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "pay-service")
public interface PayOpenFeginService {
}
