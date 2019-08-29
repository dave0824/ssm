package cn.dave.service.impl;

import cn.dave.dao.IUserInfoDao;
import cn.dave.domain.Role;
import cn.dave.domain.UserInfo;
import cn.dave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-05 08:14
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserInfoDao userDao;

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        //设置加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    /**
     * 显示用户没有的角色
     * @param id
     * @return
     */
    @Override
    public List<Role> showNotHasRoles(String id) {
        return userDao.showNotHasRoles(id);
    }

    /**
     * 添加角色到用户
     * @param userId
     * @param ids
     */
    @Override
    public void addRoleToUser(String userId, List<String> ids) {

        for (String roleId:ids) {
            userDao.addRoleToUser(userId, roleId);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userDao.findByName(username);
        System.out.println(username);
        System.out.println(userInfo);
        //将userInfo转换成spring-security提供的user对象返回，user是UserDetails的实现类
//        User user = new User(userInfo.getUsername(),"{noop}"+ userInfo.getPassword(),getAuthority(userInfo.getRoles()));
 //       User user = new User(userInfo.getUsername(),"{noop}"+ userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getAuthority(userInfo.getRoles()));

        System.out.println(user);
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role:
             roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


}
