package com.mall.huitop.service;

import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.UserAdmin;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

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

    /**
     * 根据用户名获取UserDetails
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取后台管理员
     */
    UserAdmin getAdminByUsername(String username);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    UserAdmin getItem(Long id);

    /**
     * 刷新token
     * @param token
     * @return
     */
    String refreshToken(String token);

    /**
     * 获取用户列表
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UserAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据id更新用户信息
     * @param id
     * @param admin
     * @return
     */
    int update(Long id, UserAdmin admin);

}
