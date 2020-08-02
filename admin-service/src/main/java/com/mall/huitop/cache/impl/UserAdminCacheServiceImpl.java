package com.mall.huitop.cache.impl;

import cn.hutool.core.collection.CollUtil;
import com.mall.huitop.cache.UserAdminCacheService;
import com.mall.huitop.entity.*;
import com.mall.huitop.mapper.UserAdminRoleRelationMapper;
import com.mall.huitop.security.service.RedisService;
import com.mall.huitop.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-15 18:53
 */
@Service
public class UserAdminCacheServiceImpl implements UserAdminCacheService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private UserAdminRoleRelationMapper adminRoleRelationMapper;

    private static final String REDIS_KEY_RESOURCE_LIST = "ums:resourceList";
    private static final String REDIS_KEY_ROLE_LIST = "ums:roleList";
    private static final String REDIS_DATABASE ="mall";
    private static final Long REDIS_EXPIRE = 86400L;
    private static final String REDIS_KEY_ADMIN ="ums:admin";

    @Override
    public void delAdmin(Long adminId) {
        //根据主键id查询出来用户表;
        UserAdmin admin =umsAdminService.getItem(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public UserAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UserAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UserAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public List<UserResource> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<UserResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<UserResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ROLE_LIST + ":" + adminId;
        return (List<UmsRole>) redisService.get(key);
    }

    @Override
    public void setRoleList(Long adminId, List<UmsRole> roleList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ROLE_LIST + ":" + adminId;
        redisService.set(key, roleList, REDIS_EXPIRE);
    }

    @Override
    public void delRoleList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ROLE_LIST + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }
}
