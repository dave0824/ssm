package cn.dave.dao;

import cn.dave.domain.Account;

import java.util.List;

public interface IAccountDao {


    /**
    * @Description: 在Account类中添加user对象来封装查询结果集
    * @Param: []
    * @return: java.util.List<cn.dave.domain.Account>
    * @Author: dave
    * @Date: 2019/6/26
    */
    List<Account> findAll();
}
