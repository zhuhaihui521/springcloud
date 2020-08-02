package com.mall.huitop.service;

import com.mall.huitop.entity.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    /**
     * 分页查询
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> list(String keyword, Integer pageNum, Integer pageSize);
}
