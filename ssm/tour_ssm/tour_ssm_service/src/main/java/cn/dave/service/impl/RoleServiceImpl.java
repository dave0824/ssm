package cn.dave.service.impl;

import cn.dave.dao.IRoleDao;
import cn.dave.domain.Permission;
import cn.dave.domain.Role;
import cn.dave.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-05 19:41
 **/
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findRoleById(roleId);
    }

    @Override
    public List<Permission> showNotHasPermission(String roleId) {
        return roleDao.findByIdNotPermission(roleId);
    }

    /**
     * 为角色添加权限
     * @param roleId
     * @param ids
     */
    @Override
    public void addPermissionToRole(String roleId, List<String> ids) {
        for (String permissionId:ids){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
