package cn.dave.utils;

/**
 * @program: spring_account_AOP
 * @description:
 * @author: dave
 * @create: 2019-07-02 10:51
 **/

public class TransactionAOP {

    TransactionMange transactionMange;

    public void setTransactionMange(TransactionMange transactionMange) {
        this.transactionMange = transactionMange;
    }

    /**
     * 前置：开启事务
     */
    public void beforeTransaction(){
        transactionMange.beginTransaction();
    }

    /**
     * 后置：提交事务
     */
    public void afterReturningTransaction(){
        transactionMange.commitTransaction();
    }

    /**
     * 异常：回滚事务
     */
    public void beforeThrowingTransaction(){
        transactionMange.rollbackTransaction();
    }

    /**
     * 最终：释放资源
     */
    public void afterTransaction(){

        transactionMange.release();
    }
}
