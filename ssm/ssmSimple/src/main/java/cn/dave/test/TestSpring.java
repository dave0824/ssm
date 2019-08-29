package cn.dave.test;

import cn.dave.service.AccountServiceImp;
import cn.dave.service.imp.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: ssm
 * @description:
 * @author: dave
 * @create: 2019-07-23 15:00
 **/

public class TestSpring {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.findAll();

    }

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.addAccount(null);

    }
}
