package com.mall.huitop.service;

import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.UserAdmin;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:19
 */
public interface UmsAdminService {
    /**
     * 注册功能
     * @param userAdminDto
     * @return
     */
    UserAdmin register(UserAdminDto userAdminDto);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取后台管理员
     */
    UserAdmin getAdminByUsername(String username);
}
