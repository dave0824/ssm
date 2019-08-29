package cn.dave.service.imp;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import cn.dave.service.IAccountService;
import cn.dave.utils.TransactionMange;

import java.util.List;

/**
 * @program: spring_account_xml
 * @description:
 * @author: dave
 * @create: 2019-06-29 22:06
 **/

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private TransactionMange transactionMange;

    public void setTransactionMange(TransactionMange transactionMange) {
        this.transactionMange = transactionMange;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        try{
            //1.开启事务
            transactionMange.beginTransaction();
            //2.数据操作
           List<Account> accountList = accountDao.findAll();
            //3.提交事务
            transactionMange.commitTransaction();
            //4.返回结果
            return accountList;
        }catch (Exception e){
            //5.回滚事务
            transactionMange.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionMange.release();
        }

    }

    public Account findById(int id) {
        try{
            //1.开启事务
            transactionMange.beginTransaction();
            //2.数据操作
            Account account = accountDao.findById(id);
            //3.提交事务
            transactionMange.commitTransaction();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚事务
            transactionMange.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionMange.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            //1.开启事务
            transactionMange.beginTransaction();
            //2.数据操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionMange.commitTransaction();
        }catch (Exception e){
            //4.回滚事务
            transactionMange.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionMange.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            //1.开启事务
            transactionMange.beginTransaction();
            //2.数据操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionMange.commitTransaction();
        }catch (Exception e){
            //4.回滚事务
            transactionMange.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionMange.release();
        }

    }

    public void transfer(String sourceName, String targetName, Float money) {
        try{
            //1.开启事务
            transactionMange.beginTransaction();
            //2.数据操作
            //2.1.获取转出用户
            Account source = accountDao.findByName(sourceName);
            //2.2.获取转入用户
            Account target = accountDao.findByName(targetName);
            //2.3.修改金额
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            //2.4.修改转出用户
            accountDao.updateAccount(source);
//            int i=1/0;
            //2.5.修改转入用户
            accountDao.updateAccount(target);
            //3.提交事务
            transactionMange.commitTransaction();
        }catch (Exception e){
            //4.回滚事务
            transactionMange.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionMange.release();
        }


    }
}
