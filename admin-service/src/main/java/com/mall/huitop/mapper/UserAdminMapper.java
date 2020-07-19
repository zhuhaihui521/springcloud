package com.mall.huitop.mapper;

import com.mall.huitop.entity.UmsAdminExample;
import com.mall.huitop.entity.UserAdmin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-15 16:08
 */
@Mapper
public interface UserAdminMapper {
    @Select("select * from ums_admin where username =#{username}")
    List<UserAdmin> selectByUserName(@Param("username")String username);


    @Insert("insert into ums_admin (username, password, icon, \n" +
            "      email, nick_name, note, \n" +
            "      create_time, login_time, status\n" +
            "      )\n" +
            "    values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, \n" +
            "      #{email,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, \n" +
            "      #{createTime,jdbcType=TIMESTAMP}, #{loginTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}\n" +
            "      )")
    void insert(UserAdmin userAdmin);


    @Select("select * from ums_admin where id =#{id}")
    UserAdmin selectById(@Param("id") Long id);


    List<UserAdmin> selectByExample(UmsAdminExample example);

    UserAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAdmin admin);

    @Update("update ums_admin set status =#{status} where id =#{id}")
    int updateStatusByPrimaryKey(@Param("id")Long id, @Param("status")Integer status);

    @Delete("delete from ums_admin where id = #{id}")
    int deleteByPrimaryKey(@Param("id")Long id);
}
