package cn.dave.test;

import cn.dave.service.IAccountService;
import cn.dave.service.imp.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring_AOP
 * @description:
 * @author: dave
 * @create: 2019-07-02 09:48
 **/

public class AOPTest {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
        accountService.updateAccount(1);
        accountService.totalAccount();
    }
}
