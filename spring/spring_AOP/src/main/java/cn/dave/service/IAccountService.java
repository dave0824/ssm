package cn.dave.service;

/**
 * @program: spring_AOP
 * @description:
 * @author: dave
 * @create: 2019-07-02 09:26
 **/

public interface IAccountService {

    /**
     * 模拟保存用户
     */
    void saveAccount();

    /**
     * 模拟更新用户
     * @param id
     */
    void updateAccount(int id);

    /**
     * 模拟计算用户总数
     * @return
     */
    int totalAccount();
}
