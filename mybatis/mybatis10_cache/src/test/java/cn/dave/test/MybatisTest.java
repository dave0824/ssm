package cn.dave.test;

import cn.dave.dao.IUserDao;
import cn.dave.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    InputStream in;
    SqlSession session;
    IUserDao userDao;
    SqlSessionFactory factory;
    @Before
    public void init(){
        try {
            //1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
            //3.获得session
            session = factory.openSession();
            userDao = session.getMapper(IUserDao.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void destroy(){
        /*session.commit();*/
       /* session.close();*/
        try{
            if(in != null){
                in.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll(){

        List<User> userList = userDao.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
    }

    /**
    * @Description: 测试一级,二级缓存
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/27
    */
    @Test
    public void testFindById(){

        User user = userDao.findById(41);
        System.out.println(user);

        session.commit();
        session.close();
        SqlSession session2 = factory.openSession();
        IUserDao userDao2 = session2.getMapper(IUserDao.class);
        User user2 = userDao2.findById(41);
        System.out.println(user2);

        System.out.println(user==user2);
        session2.commit();
        session2.close();
    }
}
