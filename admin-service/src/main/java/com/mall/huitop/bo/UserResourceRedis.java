package com.mall.huitop.bo;

import com.mall.huitop.entity.UserResource;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-16 19:18
 */
public class UserResourceRedis{
    private List<UserResource> resourceListDao;

    public UserResourceRedis(List<UserResource> resourceListDao) {
        this.resourceListDao = resourceListDao;
    }

    public UserResourceRedis() {
    }

    public List<UserResource> getResourceListDao() {
        return resourceListDao;
    }

    public void setResourceListDao(List<UserResource> resourceListDao) {
        this.resourceListDao = resourceListDao;
    }
}
