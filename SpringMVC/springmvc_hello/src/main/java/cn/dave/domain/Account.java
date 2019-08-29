package cn.dave.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @program: springmvc_hello
 * @description:
 * @author: dave
 * @create: 2019-07-09 18:01
 **/

public class Account implements Serializable {
    String username;
    String password;
    Double money;
    User user;

    Map<String,User> map;
    List<User>  list;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", map=" + map +
                ", list=" + list +
                '}';
    }
}
