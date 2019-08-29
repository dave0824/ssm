package cn.dave.test;

import cn.dave.dao.IUserDaoImp;
import cn.dave.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 使用自己创建的实现了dao接口的类，不使用动态代理
 */
public class MybatisTest {
    @Test
    public void test()throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.创建IUserDaoImp对象
        IUserDaoImp userDaoImp = new IUserDaoImp(factory);
        //4.调用userDaoImp的findAll方法
        List<User> userList = userDaoImp.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
        //6.释放资源
        in.close();
    }
}
