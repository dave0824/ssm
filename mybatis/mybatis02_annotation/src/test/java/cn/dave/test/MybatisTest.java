package cn.dave.test;

import cn.dave.dao.IUserDao;
import cn.dave.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test()throws Exception{
        //1.解析文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂得到SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession对象得到dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user:
             userList) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
