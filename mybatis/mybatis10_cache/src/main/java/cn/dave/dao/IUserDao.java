package cn.dave.dao;

import cn.dave.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
    User findById(Integer id);
}
