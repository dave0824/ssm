package cn.dave.dao;

import cn.dave.domain.Account;

import java.util.List;

public interface IAccountDao {

     List<Account> findAll();

     Account findByName(String name);

     Account findById(int id);

     void updateAccount(Account account);

}
