package cn.dave.service.imp;


import cn.dave.service.IAccountService;

import java.util.Date;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:28
 **/

public class IAccountServiceImp2 implements IAccountService {
    private String username;
    private Integer age;
    private Date date;

    public IAccountServiceImp2(String username, Integer age, Date date) {
        this.username = username;
        this.age = age;
        this.date = date;
    }

    public void saveAccount() {

        System.out.println("service中的saveAccount方法执行了。。。"+username+","+age+","+date);
    }
}
