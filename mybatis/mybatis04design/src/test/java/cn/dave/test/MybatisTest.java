package cn.dave.test;

import cn.dave.dao.IUserDao;
import cn.dave.domain.User;
import cn.dave.mybatis.io.Resources;
import cn.dave.mybatis.session.SqlSession;
import cn.dave.mybatis.session.SqlSessionFactory;
import cn.dave.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test()throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂获取SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
