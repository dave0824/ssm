package cn.dave.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: spring_account_AOP
 * @description: 这种做法失败了！！！！！！！！因为无法确保connection是同一个，所以失败，不能用，这个类
 *                      暂定为无效了，实在想不起不知道怎么确保它能是一个对象。我还会再回来解决你的，给我等着
 *                      哼哼哼！！！
 * @author: dave
 * @create: 2019-07-02 10:51
 **/

//@Component("transactionAOP")
//@Aspect
public class TransactionAOP {

    private ThreadLocal<TransactionMange> tl = new ThreadLocal<TransactionMange>();
    private TransactionMange transactionMange;

    /**
     * 获取线程上的transactionMange
     * @return
     */
    public TransactionMange getTransaction(){
        try{
            //1.先从ThreadLocal上获取
            transactionMange = tl.get();
            //2.判断当前线程上是否有连接
            if(transactionMange == null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                transactionMange = new TransactionMange();
                tl.set(transactionMange);
            }
            //4.返回当前线程上的连接
            return transactionMange;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //@Pointcut("execution(* cn.dave.service.imp.AccountServiceImpl.*(..))")
    private void pt1(){}
    /**
     * 前置：开启事务
     */
    //@Before("pt1()")
    public void beforeTransaction(){

        this.getTransaction().beginTransaction();
        System.out.println(transactionMange.connectionUtils.getConnection());
    }

    /**
     * 后置：提交事务
     */
    //@AfterReturning("pt1()")
    public void afterReturningTransaction(){
        System.out.println(this.getTransaction().connectionUtils.getConnection());
        this.getTransaction().commitTransaction();

    }

    /**
     * 异常：回滚事务
     */
    //@AfterThrowing("pt1()")
    public void beforeThrowingTransaction(){
        this.getTransaction().rollbackTransaction();
        System.out.println(this.getTransaction().connectionUtils.getConnection());
    }

    /**
     * 最终：释放资源
     */
    //@After("pt1()")
    public void afterTransaction(){
        this.getTransaction().release();
    }


}
