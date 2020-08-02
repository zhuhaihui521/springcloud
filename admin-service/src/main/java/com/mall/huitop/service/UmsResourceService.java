package com.mall.huitop.service;

import com.mall.huitop.entity.UserResource;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-15 21:56
 */
public interface UmsResourceService {
    List<UserResource> listAll();

    /**
     * 查询资源
     * @param categoryId
     * @param nameKeyword
     * @param urlKeyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UserResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);
}
