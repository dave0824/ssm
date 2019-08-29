package cn.dave.test;

import cn.dave.domain.Account;
import cn.dave.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: spring_account_xml
 * @description:
 * @author: dave
 * @create: 2019-06-29 22:54
 **/

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class ServletTest {

    @Autowired
    IAccountService as;
    @Test
    public void testFindAll(){

        List<Account> accountList = as.findAll();
        for (Account account:
                accountList) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindById(){

        System.out.println(as.findById(1));

    }

    @Test
    public void testSaveAccount(){

        Account account = new Account();
        account.setName("dave");
        account.setMoney(99999999f);
        as.saveAccount(account);

    }

    @Test
    public void testUpdateAccount(){

        Account account = as.findById(4);

        account.setName("小明");
        account.setMoney(999.99f);
        as.updateAccount(account);

    }
}
