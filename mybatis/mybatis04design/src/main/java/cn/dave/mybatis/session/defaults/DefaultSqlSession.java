package cn.dave.mybatis.session.defaults;

import cn.dave.mybatis.cfg.Configuration;
import cn.dave.mybatis.proxy.MapperProxy;
import cn.dave.mybatis.session.SqlSession;
import cn.dave.mybatis.session.SqlSessionFactory;
import cn.dave.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @program: mybatis04design
 * @description:SqlSession接口的实现类
 * @author: dave
 * @create: 2019-06-24 11:10
 **/

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    /**
    * @Description: 释放资源
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
