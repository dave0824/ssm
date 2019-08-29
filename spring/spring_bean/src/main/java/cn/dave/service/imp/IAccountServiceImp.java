package cn.dave.service.imp;


import cn.dave.service.IAccountService;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:28
 **/

public class IAccountServiceImp implements IAccountService {
    private int i = 1;
    public void saveAccount() {

        System.out.println("service"+"保存用户");
        System.out.println("i=" + i);
        i++;
    }
}
