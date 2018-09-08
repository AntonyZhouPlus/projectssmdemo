package com.zhouhang.dao;

import com.zhouhang.domain.Permission;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.dao
 * @date 2018/9/5
 */
public interface IPermissionDao extends Mapper<Permission> {

    @Select("select * from permission where id in (select permissionId from ROLE_PERMISSION where roleId = #{roleId})")
    List<Permission> findPermissionByRoleId(String roleId);

    @Select("select * from permission where id not in (select permissionId from ROLE_PERMISSION where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId);
}
