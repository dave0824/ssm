package cn.dave.dao;

import cn.dave.domain.Account;
import cn.dave.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    /**
    * @Description: 创建一个实体类来装载查询的结果集
    * @Param: []
    * @return: java.util.List<cn.dave.domain.AccountUser>
    * @Author: dave
    * @Date: 2019/6/26
    */
    List<AccountUser> findAll();

    /**
    * @Description: 在Account类中添加user对象来封装查询结果集
    * @Param: []
    * @return: java.util.List<cn.dave.domain.Account>
    * @Author: dave
    * @Date: 2019/6/26
    */
    List<Account> findAllHaveUser();
}
