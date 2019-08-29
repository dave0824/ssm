package cn.dave.dao;

import cn.dave.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    /**
     * @Description: 在User类中添加Account对象来封装查询结果集
     * @Param: []
     * @return: java.util.List<cn.dave.domain.Account>
     * @Author: dave
     * @Date: 2019/6/26
     */
    List<User> findAllHaveAccounts();
}
