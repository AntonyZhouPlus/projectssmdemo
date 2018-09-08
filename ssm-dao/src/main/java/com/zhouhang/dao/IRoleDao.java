package com.zhouhang.dao;

import com.zhouhang.domain.Role;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.dao
 * @date 2018/9/4
 */
public interface IRoleDao extends Mapper<Role> {
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",
                    many = @Many(select = "com.zhouhang.dao.IPermissionDao.findPermissionByRoleId"))
    })
    List<Role> findByUserId(String userId);


    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into ROLE_PERMISSION(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
