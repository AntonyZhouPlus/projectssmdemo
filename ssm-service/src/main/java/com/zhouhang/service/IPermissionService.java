package com.zhouhang.service;

import com.zhouhang.domain.Permission;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service
 * @date 2018/9/5
 */
public interface IPermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findOtherPermissions(String roleId);
}
