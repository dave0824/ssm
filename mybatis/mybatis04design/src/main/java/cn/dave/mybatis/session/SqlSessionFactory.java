package cn.dave.mybatis.session;

/**
 * @program: mybatis04design
 * @description:
 * @author: dave
 * @create: 2019-06-24 10:52
 **/

public interface SqlSessionFactory {
    /**
    * @Description: 用于打开一个新的SqlSession对象
    * @Param: []
    * @return: cn.dave.mybatis.session.SqlSession
    * @Author: dave
    * @Date: 2019/6/24
    */
     SqlSession openSession();
}
