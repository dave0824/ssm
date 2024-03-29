package cn.dave.iu;


import cn.dave.dao.IAccountDao;
import cn.dave.dao.imp.IAccountDaoImp;
import cn.dave.service.IAccountService;
import cn.dave.service.imp.IAccountServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:30
 **/

/**
 * 获取spring的Ioc核心容器，并根据id获取对象
 *
 * ApplicationContext的三个常用实现类：
 *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
 *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
 *
 *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的。
 *
 * 核心容器的两个接口引发出的问题：
 *  ApplicationContext:     单例对象适用              采用此接口
 *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
 *
 *  BeanFactory:            多例对象使用
 *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
 * @param
 */
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("G:\\Maven\\spring\\spring_firstDemo\\src\\main\\resources\\beans.xml");
        //根据id获取bean对象(两种方式，一种强转，一种传类的字节码)
        IAccountService accountService = (IAccountServiceImp)applicationContext.getBean("accountService");
        IAccountDao accountDao =applicationContext.getBean("accountDao", IAccountDaoImp.class);

        System.out.println(accountService);
        accountService.saveAccount();
        System.out.println(accountDao);



        //--------BeanFactory----------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as  = (IAccountService)factory.getBean("accountService");
//        System.out.println(as);
        }

}
