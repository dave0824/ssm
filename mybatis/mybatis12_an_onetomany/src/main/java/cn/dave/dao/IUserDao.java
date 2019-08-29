package cn.dave.dao;

import cn.dave.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)//mybatis使用注解的方式开启二级缓存
public interface IUserDao {

    @Select("select * from user")
    @Results(id="userMap",
            value = {
                    @Result(id=true, column="id",property = "userId"),
                    @Result(column = "username",property = "userName"),
                    @Result(column = "address",property = "userAddress"),
                    @Result(column = "birthday",property = "userBirthday"),
                    @Result(column = "sex",property = "userSex"),
                    @Result(column = "id",property = "accounts",
                    many = @Many(select = "cn.dave.dao.IAcountDao.findById",fetchType = FetchType.LAZY))
            })
    List<User> findAll();

    /**
     * 按id查找
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("userMap")
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
