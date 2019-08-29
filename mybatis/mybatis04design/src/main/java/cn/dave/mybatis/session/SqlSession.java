package cn.dave.mybatis.session;

import cn.dave.dao.IUserDao;

/**
 * @program: mybatis04design
 * @description:自定义mybatis中和数据库交互的核心类，它里面可以创建Dao接口的代理对象
 * @author: dave
 * @create: 2019-06-24 10:54
 **/

public interface SqlSession {
    /**
    * @Description: 根据参数创建一个代理对象
    * @Param: [daoInterfaceClass]
    * @return: T
    * @Author: dave
    * @Date: 2019/6/24
    */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
    * @Description: 释放资源
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
    void close();
}
