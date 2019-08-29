package cn.dave.test;

import cn.dave.dao.IUserDao;
import cn.dave.domain.Account;
import cn.dave.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
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
        * @Description: 查找所有
        * @Param: []
        * @return: void
        * @Author: dave
        * @Date: 2019/6/27
        */
        @Test
        public void testFindAll(){

            List<User> userList = userDao.findAll();
            for (User user:userList) {
                System.out.println(user);
            }
        }

    /**
     * @Description: 按id查找
     * @Param: []
     * @return: void
     * @Author: dave
     * @Date: 2019/6/26
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
    * @Description: 添加用户
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/28
    */
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("小四");
        user.setSex("女");
        user.setAddress("上海");
        user.setBirthday(new Date());
        userDao.addUser(user);
    }


    /** 
    * @Description: 更新用户
    * @Param: [] 
    * @return: void 
    * @Author: dave
    * @Date: 2019/6/28 
    */ 
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUsername("小五");
        user.setId(55);
        user.setSex("男");
        user.setAddress("上海");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(56);
    }

    @Test
    public void testFindByName(){
        List<User> userList = userDao.findByUsername("%小%");
        for (User user:
             userList) {
            System.out.println(user);
        }

    }
}
