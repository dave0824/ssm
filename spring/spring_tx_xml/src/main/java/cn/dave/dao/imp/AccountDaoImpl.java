package cn.dave.dao.imp;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @program: spring_jdbctemplate
 * @description:
 * @author: dave
 * @create: 2019-07-02 21:46
 **/

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    public List<Account> findAll() {
        String sql = "select * from account";
        return super.getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findByName(String name) {
        String sql = "select * from account where name=?";
        List<Account> accountList = super.getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Account>(Account.class),name);
        return accountList.isEmpty() ? null:accountList.get(0);
    }

    public Account findById(int id) {
        String sql = "select * from account where id=?";
        List<Account> accountList = super.getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Account>(Account.class),id);
        return accountList.isEmpty() ? null:accountList.get(0);
    }

    public void updateAccount(Account account) {
        String sql = "update account set name=?,money=? where id=?";
        super.getJdbcTemplate().update(sql,account.getName(),account.getMoney(),account.getId());
    }
}
