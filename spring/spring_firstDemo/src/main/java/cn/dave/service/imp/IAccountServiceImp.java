package cn.dave.service.imp;


import cn.dave.service.IAccountService;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:28
 **/

public class IAccountServiceImp implements IAccountService {
    public void saveAccount() {
        System.out.println("service"+"保存用户");
    }
}
