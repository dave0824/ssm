package cn.dave.dao;

import cn.dave.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    @Insert("insert into account(name,money) values (#{name},#{money})")
    void addAccount(Account account);

    @Select("select * from account")
    List<Account> findAll();
}
