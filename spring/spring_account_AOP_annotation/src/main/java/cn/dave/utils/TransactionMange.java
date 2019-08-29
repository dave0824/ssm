package cn.dave.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @program: spring_account
 * @description:
 * @author: dave
 * @create: 2019-06-30 23:20
 **/

@Component("transactionMange")
@Aspect
public class TransactionMange {

    @Autowired
    public  ConnectionUtils connectionUtils;

   @Pointcut("execution(* cn.dave.service.imp.AccountServiceImpl.*(..))")
    private void pt1(){}
    /**
     * 开始事务
     */
    public void beginTransaction(){
        try{
            connectionUtils.getConnection().setAutoCommit(false);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction(){

        try{
            connectionUtils.getConnection().commit();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try{
            connectionUtils.getConnection().rollback();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try{
            connectionUtils.getConnection().close();//归还事务到连接池
            connectionUtils.removeConnection();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

   @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtValue = pjp.proceed(args);
            //4.提交事务
            this.commitTransaction();

            //返回结果
            return  rtValue;

        }catch (Throwable e){
            //5.回滚事务
            this.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            this.release();
        }
    }
}
