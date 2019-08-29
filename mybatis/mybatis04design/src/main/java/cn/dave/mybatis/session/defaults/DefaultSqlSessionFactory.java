package cn.dave.mybatis.session.defaults;

import cn.dave.mybatis.cfg.Configuration;
import cn.dave.mybatis.session.SqlSession;
import cn.dave.mybatis.session.SqlSessionFactory;

/**
 * @program: mybatis04design
 * @description:SqlSessionFactory接口的实现类
 * @author: dave
 * @create: 2019-06-24 11:09
 **/

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /** 
    * @Description: 创建一个新的操作数据库对象 
    * @Param: [] 
    * @return: cn.dave.mybatis.session.SqlSession 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
