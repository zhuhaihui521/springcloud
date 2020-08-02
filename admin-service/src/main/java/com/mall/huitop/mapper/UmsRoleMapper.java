package com.mall.huitop.mapper;


import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.entity.UmsRoleExample;
import com.mall.huitop.entity.UserResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UmsRoleMapper {
    @Select("SELECT\n" +
            "            m.id id,\n" +
            "            m.parent_id parentId,\n" +
            "            m.create_time createTime,\n" +
            "            m.title title,\n" +
            "            m.level level,\n" +
            "            m.sort sort,\n" +
            "            m.name name,\n" +
            "            m.icon icon,\n" +
            "            m.hidden hidden\n" +
            "        FROM\n" +
            "            ums_admin_role_relation arr\n" +
            "                LEFT JOIN ums_role r ON arr.role_id = r.id\n" +
            "                LEFT JOIN ums_role_menu_relation rmr ON r.id = rmr.role_id\n" +
            "                LEFT JOIN ums_menu m ON rmr.menu_id = m.id\n" +
            "        WHERE\n" +
            "            arr.admin_id = #{adminId}\n" +
            "          AND m.id IS NOT NULL\n" +
            "        GROUP BY\n" +
            "            m.id")
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    @Select("select * from ums_role")
    List<UmsRole> listAll();

    List<UmsRole> selectByExample(UmsRoleExample umsRoleExample);

    @Select("SELECT\n" +
            "            m.id id,\n" +
            "            m.parent_id parentId,\n" +
            "            m.create_time createTime,\n" +
            "            m.title title,\n" +
            "            m.level level,\n" +
            "            m.sort sort,\n" +
            "            m.name name,\n" +
            "            m.icon icon,\n" +
            "            m.hidden hidden\n" +
            "        FROM\n" +
            "             ums_role_menu_relation rmr\n" +
            "                LEFT JOIN ums_menu m ON rmr.menu_id = m.id\n" +
            "        WHERE\n" +
            "            rmr.role_id = #{roleId}\n" +
            "          AND m.id IS NOT NULL\n" +
            "        GROUP BY\n" +
            "            m.id")
    List<UmsMenu> getMenuListByRoleId(@Param("roleId")Long roleId);

    @Select("SELECT\n" +
            "            r.id id,\n" +
            "            r.create_time createTime,\n" +
            "            r.`name` `name`,\n" +
            "            r.url url,\n" +
            "            r.description description,\n" +
            "            r.category_id categoryId\n" +
            "        FROM\n" +
            "            ums_role_resource_relation rrr\n" +
            "                LEFT JOIN ums_resource r ON rrr.resource_id = r.id\n" +
            "        WHERE\n" +
            "            rrr.role_id = #{roleId}\n" +
            "          AND r.id IS NOT NULL\n" +
            "        GROUP BY\n" +
            "            r.id")
    List<UserResource> getResourceListByRoleId(@Param("roleId")Long roleId);

    @Update("update ums_role set name = #{name},description = #{description},admin_count = #{adminCount},create_time = #{createTime},status = #{status},sort = #{sort} where id = #{id}")
    int updateByRoleId(UmsRole role);
}
