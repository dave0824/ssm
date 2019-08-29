package cn.dave.test;

import cn.dave.dao.IAcountDao;
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

public class AccountTest {

        InputStream in;
        SqlSession session;
        IAcountDao acountDao;
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
                acountDao = session.getMapper(IAcountDao.class);
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

            List<Account> accountList = acountDao.findAll();
            for (Account account:accountList) {
                System.out.println(account);
            }
        }

    /**
     * @Description: 按id查找
     * @Param: []
     * @return: void
     * @Author: dave
     * @Date: 2019/6/26
     */
   /* @Test
    public void testFindById(){
        User user = acountDao.findById(41);
        System.out.println(user);
    }*/

}
