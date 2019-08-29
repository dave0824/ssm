package cn.dave.dao;


import cn.dave.domain.Role;

import java.util.List;

public interface IRoleDao {

    /** 
    * @Description: 查询所有 ,在Role类中添加user对象来封装查询结果集
    * @Param: [] 
    * @return: java.util.List<javax.management.relation.Role> 
    * @Author: dave
    * @Date: 2019/6/26 
    */ 
    List<Role> findAll();


}
