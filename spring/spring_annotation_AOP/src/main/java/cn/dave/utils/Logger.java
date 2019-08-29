package cn.dave.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: spring_AOP
 * @description:记录日志，提供公共方法
 * @author: dave
 * @create: 2019-07-02 09:31
 **/

@Component("logger")
@Aspect//表示当前类是一个切面
public class Logger {

    @Pointcut("execution(* cn.dave.service.imp.AccountServiceImpl.*(..))")
    private void pt1(){}
    /**
     * 前置通知
     */
    //@Before("pt1()")
    public void  beforeLogger(){
        System.out.println("前置通知:Logger类中的beforeLogger开始执行记录日记了。。。");
    }

    /**
     * 后置通知
     */
    //@AfterReturning("pt1()")
    public void  afterReturningLogger(){
        System.out.println("后置通知:Logger类中的afterReturningLogger开始执行记录日记了。。。");
    }

    /**
     * 异常通知
     */
    //@AfterThrowing("pt1()")
    public void  afterThrowingLogger(){
        System.out.println("异常通知:Logger类中的afterThrowingLogger开始执行记录日记了。。。");
    }

    /**
     * 最终通知
     */
    //@After("pt1()")
    public void  afterLogger(){
        System.out.println("最终通知:Logger类中的afterLogger开始执行记录日记了。。。");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    @Around("pt1()")
    public Object aroundPrintLogger(ProceedingJoinPoint proceedingJoinPoint){
        Object rtValue = null;
        try{
            Object[] args = proceedingJoinPoint.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");

            rtValue = proceedingJoinPoint.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }
}
