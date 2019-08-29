package cn.dave.dao;

import cn.dave.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAcountDao {
    @Select("select * from account")
    @Results(id="accountMap",
            value = {
                    @Result(id=true, column="id",property = "id"),
                    @Result(column = "uid",property = "uid"),
                    @Result(column = "money",property = "money"),
                    @Result(column = "uid",property = "user",
                    one=@One(select = "cn.dave.dao.IUserDao.findById",fetchType = FetchType.LAZY))
            })
    List<Account> findAll();

    @Select("select * from account where uid=#{id}")
   List<Account>findById(Integer id);
}
