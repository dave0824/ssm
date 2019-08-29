package cn.dave.dao;

import cn.dave.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @program: mybatis06_DAO
 * @description:
 * @author: dave
 * @create: 2019-06-25 16:00
 **/

public class DefualtIUserDaoImp implements IUserDao {

    SqlSessionFactory factory;
    public DefualtIUserDaoImp(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("cn.dave.dao.IUserDao.findAll");
        sqlSession.commit();
        sqlSession.close();
        return userList;
    }

    public User findById(Integer id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("cn.dave.dao.IUserDao.findById",id);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    public void addUser(User user) {

        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("cn.dave.dao.IUserDao.addUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(Integer id) {


        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("cn.dave.dao.IUserDao.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser(User user) {

        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("cn.dave.dao.IUserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public int countUser() {

        SqlSession sqlSession = factory.openSession();
        int count = sqlSession.selectOne("cn.dave.dao.IUserDao.countUser");
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    public List<User> findByName(String name) {
        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("cn.dave.dao.IUserDao.findByName",name);
        sqlSession.commit();
        sqlSession.close();
        return userList;
    }
}
