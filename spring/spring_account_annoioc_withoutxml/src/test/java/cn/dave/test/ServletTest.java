package cn.dave.test;

import cn.dave.config.SpringConfiguration;
import cn.dave.domain.Account;
import cn.dave.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
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
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *             @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
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
