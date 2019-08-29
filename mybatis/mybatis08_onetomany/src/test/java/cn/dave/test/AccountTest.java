package cn.dave.test;

import cn.dave.dao.IAccountDao;
import cn.dave.domain.Account;
import cn.dave.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {

        InputStream in;
        SqlSession session;
        IAccountDao accountDao;
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
                accountDao = session.getMapper(IAccountDao.class);
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
    * @Description: 创建一个实体类来装载查询的结果集
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/26
    */
    @Test
    public void testFindAll(){

        List<AccountUser> accountList = accountDao.findAll();
        for (AccountUser account:accountList) {
            System.out.println(account);
        }
    }

    /**
    * @Description: 在Account类中添加user对象来封装查询结果集
    * @Param: []
    * @return: void
    * @Author: dave
    * @Date: 2019/6/26
    */
    @Test
    public void testFindAllHaveUser(){

        List<Account> accountList = accountDao.findAllHaveUser();
        for (Account account:accountList) {
            System.out.println(account);
        }
    }

}
