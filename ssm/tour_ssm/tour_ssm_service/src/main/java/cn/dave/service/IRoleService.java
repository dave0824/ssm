package cn.dave.service;

import cn.dave.domain.Permission;
import cn.dave.domain.Role;

import java.util.List;

public interface IRoleService {
    
    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> showNotHasPermission(String roleId);

    void addPermissionToRole(String roleId, List<String> ids);
}
