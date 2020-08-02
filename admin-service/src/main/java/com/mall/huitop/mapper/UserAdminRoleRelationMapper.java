package com.mall.huitop.mapper;


import com.mall.huitop.entity.UmsAdminRoleRelation;
import com.mall.huitop.entity.UmsAdminRoleRelationExample;
import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.entity.UserResource;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserAdminRoleRelationMapper {


    @Select("SELECT\n" +
            "            ur.id id,\n" +
            "            ur.create_time createTime,\n" +
            "            ur.`name` `name`,\n" +
            "            ur.url url,\n" +
            "            ur.description description,\n" +
            "            ur.category_id categoryId\n" +
            "        FROM\n" +
            "            ums_admin_role_relation ar\n" +
            "        LEFT JOIN ums_role r ON ar.role_id = r.id\n" +
            "        LEFT JOIN ums_role_resource_relation rrr ON r.id = rrr.role_id\n" +
            "        LEFT JOIN ums_resource ur ON ur.id = rrr.resource_id\n" +
            "        WHERE\n" +
            "            ar.admin_id = #{adminId}\n" +
            "        AND ur.id IS NOT NULL\n" +
            "        GROUP BY\n" +
            "            ur.id")
    List<UserResource> getResourceList(@Param("adminId") Long adminId);

    @Select("select r.*\n" +
            "        from ums_admin_role_relation ar left join ums_role r on ar.role_id = r.id\n" +
            "        where ar.admin_id = #{adminId}")
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);


    @Delete("delete from ums_admin_role_relation where admin_id = #{adminId}")
    int deleteByAdminId(@Param("adminId")Long adminId);


    int insertList(@Param("list")List<UmsAdminRoleRelation> list);

    List<UmsAdminRoleRelation> selectByExample(UmsAdminRoleRelationExample example);
}
