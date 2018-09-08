package com.zhouhang.service;

import com.zhouhang.domain.Role;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service
 * @date 2018/9/5
 */
public interface IRoleService {
    List<Role> findAll();
    void save(Role role);
    List<Role> findOtherRoles(String userID);

    Role findById(String id);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
