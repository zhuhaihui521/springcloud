package com.mall.huitop.service;

import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.UserAdmin;

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
}
