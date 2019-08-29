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
import java.util.Date;
import java.util.List;

/**
 * @program: mybatis05_crud
 * @description:
 * @author: dave
 * @create: 2019-06-24 21:26
 **/

public class MybatisTest {
    private SqlSession session;
    private InputStream in;
    private IUserDao userDao;

    /**
    * @Description: 在测试开始前执行 一些资源加载获取SqlSession数据库处理对象
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
   @Before
    public void init(){
       try {
           //1.读取文件
           in = Resources.getResourceAsStream("SqlMapConfig.xml");
           //2.创造工厂
           SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
           SqlSessionFactory factory = builder.build(in);
           //3.通过工厂获取SqlSession对象
           session = factory.openSession();
           //4.得到dao代理对象
           userDao = session.getMapper(IUserDao.class);
       }catch (Exception e){
           e.printStackTrace();
       }

    }

    /**
    * @Description: 测试完毕后释放资源
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
    @After
    public void destroy(){
        //提交事务
        session.commit();
       try {
           if(session != null){
               session.close();
           }
           if (in != null){
               in.close();
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    /**
    * @Description: 测试查询所有
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
    @Test
    public void testFindAll(){
        List<User> userList = userDao.findAll();
        for (User user:
             userList) {
            System.out.println(user);
        }
    }

    /**
    * @Description: 按id 查找用户
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
    @Test
    public void testFindById(){
        User user = userDao.findById(48);
        System.out.println(user);
    }

    /**
    * @Description: 添加一个用户
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("张十");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京海定区");
        System.out.println("添加之前：" + user);
        userDao.addUser(user);
        System.out.println("添加之后：" + user);
    }

    /** 
    * @Description: 删除一个用户 
    * @Param: [] 
    * @return: void 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    @Test
    public void testDeleteById(){
        userDao.deleteUser(50);
    }

    /**
    * @Description: 更新用户
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUsername("李四");
        user.setId(51);
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京海定区");
        userDao.updateUser(user);
    }

    /** 
    * @Description: 统计人数
    * @Param: [] 
    * @return: void 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    @Test
    public void testCountUser(){
        System.out.println(userDao.countUser());
    }

    /** 
    * @Description: 模糊查询 
    * @Param: [] 
    * @return: void 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    @Test
    public void testFindByName(){
       List<User> userList = userDao.findByName("%王%");
        for (User user:
             userList) {
            System.out.println(user);
        }
    }
}
