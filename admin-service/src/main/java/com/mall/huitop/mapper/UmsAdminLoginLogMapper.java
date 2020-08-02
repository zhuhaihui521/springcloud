package com.mall.huitop.mapper;


import com.mall.huitop.entity.UmsAdminLoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsAdminLoginLogMapper {


    @Insert("insert into ums_admin_login_log (admin_id, create_time, ip, \n" +
            "      address, user_agent)\n" +
            "    values (#{adminId,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, #{ip,jdbcType=VARCHAR}, \n" +
            "      #{address,jdbcType=VARCHAR}, #{userAgent,jdbcType=VARCHAR})")
    void insert(UmsAdminLoginLog loginLog);
}
