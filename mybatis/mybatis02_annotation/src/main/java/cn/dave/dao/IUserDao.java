package cn.dave.dao;

import cn.dave.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 持久层
 */
public interface IUserDao {
    /*
        使用注解的方式查询所有
     */
    @Select("select * from user")
    List<User> findAll();
}
