package cn.dave.controller;

import cn.dave.domain.Account;
import cn.dave.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: springmvc_hello
 * @description:
 * @author: dave
 * @create: 2019-07-08 22:58
 **/
@Controller
@RequestMapping(path = "helloController")
public class HelloController{

    /**
     * 测试method
     * @return
     */
    @RequestMapping(path = "/hello",method = RequestMethod.POST)
    public String sayHello(){
        System.out.println("hello word");
        return "success";
    }

    /**
     * 测试params
     * @return
     */
    @RequestMapping(path = "/params",params = {"name=dave"})
    public String testParams(){
        System.out.println("hello word");
        return "success";
    }

    /**
     * 测试参数绑定int
     * @return
     */
    @RequestMapping(path = "/int")
    public String testInt(int age){
        System.out.println("绑定了int" + age);
        return "success";
    }

    @RequestMapping(path = "/double")
    public String testDouble(double price){
        System.out.println("绑定了double" + price);
        return "success";
    }

    @RequestMapping(path = "/string")
    public String testString(String name){
        System.out.println("绑定了String" + name);
        return "success";
    }

    @RequestMapping(path = "/intAndString")
    public String testIntAndString(String name,int age){
        System.out.println("绑定了String" + name);
        System.out.println("绑定了int" + age);

        return "success";
    }

    @RequestMapping(path = "/user")
    public String testInt(User user){
        System.out.println("绑定了User" + user);
        return "success";
    }

    @RequestMapping(path = "/account")
    public String testAccount(Account account){
        System.out.println("绑定了User" + account);
        return "success";
    }

    @RequestMapping(path = "/date")
    public String testDate(Date date){
        System.out.println("绑定了Date" + date);
        return "success";
    }

    @RequestMapping(path = "/service")
    public String testService(HttpServletRequest request, HttpServletResponse response){
        System.out.println("绑定了request" + request);
        System.out.println("绑定了response" + response);
        return "success";
    }
}
