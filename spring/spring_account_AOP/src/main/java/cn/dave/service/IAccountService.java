package cn.dave.service;

import cn.dave.domain.Account;

import java.util.List;

/**
 * @program: spring_account_xml
 * @description:
 * @author: dave
 * @create: 2019-06-29 22:06
 **/

public interface IAccountService {


    List<Account> findAll();

    Account findById(int id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    /**
     * 转账
     * @param sourceName：转出账户名
     * @param targetName：转入账户名
     * @param money：金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
