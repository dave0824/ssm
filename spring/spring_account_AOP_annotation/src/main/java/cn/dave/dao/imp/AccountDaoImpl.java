package cn.dave.dao.imp;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import cn.dave.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: spring_account_xml
 * @description:
 * @author: dave
 * @create: 2019-06-29 22:04
 **/

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner query;
    @Autowired
    private ConnectionUtils connectionUtils;


    public List<Account> findAll() {
        try{
            return query.query(connectionUtils.getConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public Account findById(int id) {
        try {
            return query.query(connectionUtils.getConnection(),"select * from account where id=?", new BeanHandler<Account>(Account.class), id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String name) {
        try {
            return query.query(connectionUtils.getConnection(),"select * from account where name=?", new BeanHandler<Account>(Account.class), name);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {

        try {
                Object[] prams ={account.getName(),account.getMoney()};
                query.update(connectionUtils.getConnection(),"insert into account(name,money) values(?,?)", prams);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {

        try {
            Object[] prams ={account.getName(),account.getMoney(),account.getId()};
            query.update(connectionUtils.getConnection(),"update account set name=?,money=? where id=?", prams);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
