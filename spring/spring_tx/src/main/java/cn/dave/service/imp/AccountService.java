package cn.dave.service.imp;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import cn.dave.service.IAccountService;

import java.util.List;

/**
 * @program: spring_tx
 * @description:
 * @author: dave
 * @create: 2019-07-03 10:44
 **/

public class AccountService implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }
}
