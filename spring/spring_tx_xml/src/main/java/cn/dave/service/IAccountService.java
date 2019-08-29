package cn.dave.service;

import cn.dave.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findByName(String name);

    Account findById(int id);

    void updateAccount(Account account);

    void transfer(String sourceName,String targetName,Float money);
}
