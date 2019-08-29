package cn.dave.domain;

import java.io.Serializable;

/**
 * @program: ssm
 * @description:
 * @author: dave
 * @create: 2019-07-23 14:20
 **/

public class Account implements Serializable {
    Integer id;
    String name;
    Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
