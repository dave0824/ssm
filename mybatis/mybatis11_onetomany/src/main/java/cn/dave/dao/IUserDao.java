package cn.dave.dao;

import cn.dave.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {

    /**
     * 查找所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 按id查找
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    /**
     * 插入用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void addUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from user where username like #{username}")
    List<User> findByUsername(String username);
}
