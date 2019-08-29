package cn.dave.utils;

/**
 * @program: spring_AOP
 * @description:记录日志，提供公共方法
 * @author: dave
 * @create: 2019-07-02 09:31
 **/


public class Logger {
    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void  printLogger(){
        System.out.println("Logger类中的printLogger开始执行记录日记了。。。");
    }
}
