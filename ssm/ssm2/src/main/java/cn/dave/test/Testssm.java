package cn.dave.test;

import cn.dave.dao.ItemsDao;
import cn.dave.domain.Items;
import cn.dave.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: ssm2
 * @description:
 * @author: dave
 * @create: 2019-07-26 20:03
 **/

public class Testssm {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        Items items = itemsDao.findById(1);
        System.out.println(items);
    }

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsService itemsService = ac.getBean(ItemsService.class);
        Items items = itemsService.findById(1);
        System.out.println(items);
    }
}
