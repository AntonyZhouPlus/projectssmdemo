package com.zhouhang.service.Impl;

import com.zhouhang.dao.IRoleDao;
import com.zhouhang.domain.Role;
import com.zhouhang.service.IRoleService;
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
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.selectAll();
    }

    @Override
    public void save(Role role) {
        roleDao.insert(role);
    }

    @Override
    public List<Role> findOtherRoles(String userID) {
        return roleDao.findOtherRoles(userID);
    }

    @Override
    public Role findById(String id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
