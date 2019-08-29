package cn.dave.service;

import cn.dave.dao.AccountDao;
import cn.dave.domain.Account;
import cn.dave.service.imp.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ssm
 * @description:
 * @author: dave
 * @create: 2019-07-23 14:35
 **/

@Service("accountService")
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao dao;

    @Override
    public void addAccount(Account account) {
        System.out.println("service层执行了添加了一个账户。。。");
        dao.addAccount(account);
    }

    @Override
    public List<Account> findAll() {
        System.out.println("service层执行了查找了所有。。。");
        return dao.findAll();
    }
}
