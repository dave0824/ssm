package cn.dave.domain;

import java.io.Serializable;

/**
 * @program: mybatis08_onetomany
 * @description:定义包涵username和account信息的实体类
 * @author: dave
 * @create: 2019-06-26 18:47
 **/

public class AccountUser extends Account implements Serializable {
    private String username;
    private String address;

    @Override
    public String toString() {
        return "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}'+ super.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
