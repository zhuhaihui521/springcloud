package com.mall.huitop.bo;

import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.entity.UserResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * SpringSecurity需要的用户详情
 * @Auther zhuhaihui
 * @Date 2020-07-15 20:32
 */
public class AdminUserDetails implements UserDetails {
    private UserAdmin userAdmin;
    private List<UserResource> resourceList;
    public AdminUserDetails(UserAdmin userAdmin,List<UserResource> resourceList) {
        this.userAdmin = userAdmin;
        this.resourceList = resourceList;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return userAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userAdmin.getStatus().equals(1);
    }
}
