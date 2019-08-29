package cn.dave.test;

import cn.dave.dao.IUserDao;
import cn.dave.domain.QueryVo;
import cn.dave.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
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
    * @Description: 测试按照user查询
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/24
    */

    @Test
    public void testFindByName(){
        User u = new User();
        u.setUsername("老王");
        u.setSex("女");
       List<User> userList = userDao.findByUser(u);
        for (User user:
             userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(48);
        ids.add(46);
        queryVo.setIds(ids);
        List<User> userList = userDao.findByIds(queryVo);
        for (User user:
             userList) {
            System.out.println(user);
        }
    }
}
