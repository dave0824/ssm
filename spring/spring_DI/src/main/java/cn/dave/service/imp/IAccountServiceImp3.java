package cn.dave.service.imp;


import cn.dave.service.IAccountService;

import java.util.Date;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:28
 **/

public class IAccountServiceImp3 implements IAccountService {
    private String username;
    private Integer age;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void saveAccount() {

        System.out.println("service中的saveAccount方法执行了。。。"+username+","+age+","+date);
    }
}
