package cn.dave.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: springmvc_hello
 * @description:
 * @author: dave
 * @create: 2019-07-09 17:20
 **/

public class User implements Serializable {

    String name;
    Integer age;
    Double price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }
}
