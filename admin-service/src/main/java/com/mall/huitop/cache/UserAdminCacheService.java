package com.mall.huitop.cache;


import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.entity.UserResource;

import java.util.List;

public interface UserAdminCacheService {
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 获取缓存后台用户信息
     */
    UserAdmin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UserAdmin admin);

    /**
     * 获取缓存后台用户资源列表
     */
    List<UserResource> getResourceList(Long adminId);

    void setResourceList(Long id, List<UserResource> resourceList);
    /**
     * 删除缓存后台用户资源列表
     * @param adminId
     */
    void delResourceList(Long adminId);


    List<UmsRole> getRoleList(Long adminId);

    void setRoleList(Long adminId, List<UmsRole> roleList);

    void delRoleList(Long adminId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRole(Long roleId);
}
