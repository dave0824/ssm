package cn.dave.iu;

import cn.dave.factory.BeanFactory;
import cn.dave.service.IAccountService;
import cn.dave.service.imp.IAccountServiceImp;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:30
 **/

public class Client {

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }

    }
}
