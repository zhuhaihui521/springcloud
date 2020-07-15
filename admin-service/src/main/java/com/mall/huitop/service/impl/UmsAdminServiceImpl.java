package com.mall.huitop.service.impl;

import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.mapper.UserAdminMapper;
import com.mall.huitop.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:20
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UserAdminMapper userAdminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserAdmin register(UserAdminDto userAdminDto) {
        UserAdmin userAdmin = new UserAdmin();
        BeanUtils.copyProperties(userAdminDto,userAdmin);
        userAdmin.setCreateTime(new Date());
        userAdmin.setStatus(1);
        //首先查询库里面是否有这个用户名
        List<UserAdmin> userAdmins = userAdminMapper.selectByUserName(userAdmin.getUsername());
        if (userAdmins.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encode = passwordEncoder.encode(userAdmin.getPassword());
        userAdmin.setPassword(encode);
        userAdminMapper.insert(userAdmin);
        return userAdmin;
    }
}
