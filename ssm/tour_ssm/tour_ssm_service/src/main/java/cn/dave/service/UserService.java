package cn.dave.service;

import cn.dave.domain.Role;
import cn.dave.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> showNotHasRoles(String id);

    void addRoleToUser(String userId, List<String> ids);
}
