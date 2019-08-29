package cn.dave.mybatis.session;

import cn.dave.mybatis.cfg.Configuration;
import cn.dave.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.dave.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @program: mybatis04design
 * @description:用于创建一个SqlSessionFactory对象
 * @author: dave
 * @create: 2019-06-24 10:53
 **/

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
