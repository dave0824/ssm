package cn.dave.dao;

import cn.dave.domain.User;

import java.util.List;

public interface IUserDao {


    /**
     * @Description: 查询所有 ,在user类中添加role对象来封装查询结果集
     * @Param: []
     * @return: java.util.List<javax.management.relation.Role>
     * @Author: dave
     * @Date: 2019/6/26
     */
    List<User> findAll();
}
