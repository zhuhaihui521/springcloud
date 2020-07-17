package com.mall.huitop.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.mall.huitop.bo.AdminUserDetails;
import com.mall.huitop.cache.UserAdminCacheService;
import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.*;
import com.mall.huitop.mapper.UmsAdminLoginLogMapper;
import com.mall.huitop.mapper.UserAdminMapper;
import com.mall.huitop.mapper.UserAdminRoleRelationMapper;
import com.mall.huitop.security.utils.JwtTokenUtil;
import com.mall.huitop.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:20
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    private UserAdminMapper userAdminMapper;

    @Autowired
    private UserAdminRoleRelationMapper userAdminRoleRelationMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAdminCacheService userAdminCacheService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;

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

    @Override
    public String login(String username, String password) {
        //判断是否由此用户；用户的状态，权限；
        String token = null;
        try {
            //密码需要客户端加密后传递
            UserAdmin admin = userAdminCacheService.getAdmin(username);
            if (admin == null){
                //查询数据库
                List<UserAdmin> userAdmins = userAdminMapper.selectByUserName(username);
                if (userAdmins == null){
                    throw new UsernameNotFoundException("Invalid username or password!");
                }
                admin = userAdmins.get(0);
                userAdminCacheService.setAdmin(admin);
            }
            //插入缓存，然后生成token;得到可以访问的资源列表
            List<UserResource> resourceList = getResourceList(admin.getId());
            if (resourceList == null){
                throw new UsernameNotFoundException("用户名或密码错误");
            }
            UserDetails userDetails = new AdminUserDetails(admin, resourceList);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            //用户请求鉴权服务器申请token,这里是用用户的身份信息
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            //然后放到容器里面SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            //然后获取token;
            token=jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);
        } catch (Exception e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        UserAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UserResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    private List<UserResource> getResourceList(Long id) {
        List<UserResource> resourceList = userAdminCacheService.getResourceList(id);
        if (resourceList == null){
            //查询数据库
            resourceList = userAdminRoleRelationMapper.getResourceList(id);
            if (resourceList != null){
                userAdminCacheService.setResourceList(id,resourceList);
            }
            return resourceList;
        }
        return resourceList;
    }
    /**
     * 添加登录记录
     * @param username 用户名
     */
    @Transactional
    public void insertLoginLog(String username) {
        UserAdmin admin = getAdminByUsername(username);
        if(admin == null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }
    @Override
    public UserAdmin getAdminByUsername(String username) {
        UserAdmin admin = userAdminCacheService.getAdmin(username);
        if(admin!=null) return  admin;
        List<UserAdmin> adminList = userAdminMapper.selectByUserName(username);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            userAdminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public UserAdmin getItem(Long id) {
        return userAdminMapper.selectById(id);
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    @Override
    public List<UserAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsAdminExample example = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        return userAdminMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public int update(Long id, UserAdmin admin) {
        admin.setId(id);
        UserAdmin userAdmin = userAdminMapper.selectByPrimaryKey(id);
        //因为涉及到密码加密,密码相同不需要改密码，密码不同需要加密修改
        if (userAdmin.getPassword().equals(admin.getPassword())){
            admin.setPassword(null);
        }else {
            //判断传过来的密码是不是空
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else{
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }
        int count=userAdminMapper.updateByPrimaryKeySelective(admin);
        userAdminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        List<UmsRole> roleList = userAdminCacheService.getRoleList(adminId);
        if (roleList == null){
            roleList = userAdminRoleRelationMapper.getRoleList(adminId);
            if (roleList != null){
                userAdminCacheService.setRoleList(adminId,roleList);
            }
            return roleList;
        }
        return roleList;
    }

    @Override
    @Transactional
    public int updateRole(Long adminId, List<Long> roleIds) {
        //更新数据库后直接删除
        int count = roleIds == null ? 0 : roleIds.size();
       //先删除原来的关系
        userAdminRoleRelationMapper.deleteByAdminId(adminId);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            userAdminRoleRelationMapper.insertList(list);
        }
         userAdminCacheService.delResourceList(adminId);
         userAdminCacheService.delRoleList(adminId);
         return count;
    }

}
