package cn.dave.iu;



import cn.dave.service.IAccountService;
import cn.dave.service.imp.IAccountServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program:
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:30
 **/
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //根据id获取bean对象(两种方式，一种强转，一种传类的字节码)
        IAccountService accountService = (IAccountServiceImp)applicationContext.getBean("accountService");

        System.out.println(accountService);
        accountService.saveAccount();

       /* //测试单多例
        IAccountService accountService2 = (IAccountServiceImp)applicationContext.getBean("accountService");
        accountService2.saveAccount();*/
        }

}
