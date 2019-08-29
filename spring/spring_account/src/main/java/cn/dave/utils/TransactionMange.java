package cn.dave.utils;

import java.sql.Connection;

/**
 * @program: spring_account
 * @description:
 * @author: dave
 * @create: 2019-06-30 23:20
 **/

public class TransactionMange {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

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
}
