package com.zhouhang.service.Impl;

import com.zhouhang.dao.IPermissionDao;
import com.zhouhang.domain.Permission;
import com.zhouhang.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service.Impl
 * @date 2018/9/5
 */
@Service
@Transactional
public class IPermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.selectAll();
    }

    @Override
    public void save(Permission Permission) {
        permissionDao.insert(Permission);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return permissionDao.findOtherPermissions(roleId);
    }
}
