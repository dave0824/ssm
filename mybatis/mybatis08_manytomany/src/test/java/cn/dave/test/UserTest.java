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

public class UserTest {

        InputStream in;
        SqlSession session;
        IUserDao userDao;
        @Before
        public void init(){
            try {
                //1.读取配置文件
                in = Resources.getResourceAsStream("SqlMapConfig.xml");
                //2.创建SqlSessionFactory工厂
                SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                SqlSessionFactory factory = builder.build(in);
                //3.获得session
                session = factory.openSession();
                userDao = session.getMapper(IUserDao.class);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @After
        public void destroy(){
            session.commit();
            session.close();
            try{
                if(in != null){
                    in.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    /**
     * @Description: 查询所有 ,在Role类中添加user对象来封装查询结果集
     * @Param: []
     * @return: void
     * @Author: dave
     * @Date: 2019/6/26
     */
    @Test
    public void testFindAll(){

        List<User> userList = userDao.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
    }
}
