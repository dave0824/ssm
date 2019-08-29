package cn.dave.dao.jdbctemplate;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: spring_jdbctemplate
 * @description:
 * @author: dave
 * @create: 2019-07-02 23:43
 **/

public class JdbcTemplateDemo1 {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao",IAccountDao.class);

        /*List<Account> accountList = accountDao.findAll();
        for (Account account:
             accountList) {
            System.out.println(account);
        }*/
        System.out.println(accountDao.findById(1));
        System.out.println(accountDao.findByName("aaa"));
    }
}
