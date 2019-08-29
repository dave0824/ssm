package cn.dave.ui;

import cn.dave.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring_anno_ioc
 * @description:
 * @author: dave
 * @create: 2019-06-29 21:37
 **/

public class Client {
    public static void main(String[] args) {
        //1.获取核心容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //2.根据id获取对象
        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);

       /* IAccountService accountService2 = applicationContext.getBean("accountService",IAccountService.class);
        System.out.println(accountService==accountService2);*/

       accountService.saveAccount();
       applicationContext.close();
    }
}
