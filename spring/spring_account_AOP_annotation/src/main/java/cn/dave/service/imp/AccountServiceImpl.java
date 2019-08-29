package cn.dave.service.imp;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import cn.dave.service.IAccountService;
import cn.dave.utils.TransactionMange;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring_account_xml
 * @description:
 * @author: dave
 * @create: 2019-06-29 22:06
 **/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(int id) {
       return accountDao.findById(id);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);

    }

    public void transfer(String sourceName, String targetName, Float money) {
        //2.1.获取转出用户
        Account source = accountDao.findByName(sourceName);
        //2.2.获取转入用户
        Account target = accountDao.findByName(targetName);
        //2.3.修改金额
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        //2.4.修改转出用户
        accountDao.updateAccount(source);
//        int i=1/0;
        //2.5.修改转入用户
        accountDao.updateAccount(target);
    }
}
