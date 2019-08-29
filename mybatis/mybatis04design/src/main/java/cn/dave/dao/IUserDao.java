package cn.dave.dao;

import cn.dave.domain.User;
import cn.dave.mybatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
