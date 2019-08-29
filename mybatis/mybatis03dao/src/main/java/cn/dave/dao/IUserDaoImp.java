package cn.dave.dao;

import cn.dave.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class IUserDaoImp implements IUserDao {
    private SqlSessionFactory factory;
    public IUserDaoImp(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> userList = session.selectList("cn.dave.dao.IUserDao.findAll");
        session.close();
        return userList;
    }
}
