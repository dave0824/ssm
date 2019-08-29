package cn.dave.service.imp;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import cn.dave.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: spring_tx
 * @description:
 * @author: dave
 * @create: 2019-07-03 10:44
 **/

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读型事务配置
public class AccountServiceImpl implements IAccountService {
    @Autowired
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

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)//读写型事务配置
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)//读写型事务配置
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
//        int i=1/0;
        accountDao.updateAccount(target);
    }
}
