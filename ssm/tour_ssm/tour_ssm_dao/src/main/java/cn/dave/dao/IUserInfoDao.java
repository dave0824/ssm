package cn.dave.dao;

import cn.dave.domain.Role;
import cn.dave.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-05 08:16
 **/

public interface IUserInfoDao {

    @Select("select * from users where username=#{name}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "cn.dave.dao.IRoleDao.findById")),
    })
    UserInfo findByName(String name);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(id,username,password,email,phoneNum,status) values(#{id},#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "cn.dave.dao.IRoleDao.findById")),
    })
    UserInfo findById(String id);

    @Select("select * from role where id not in(select roleId from users_role where userId = #{id})")
    List<Role> showNotHasRoles(String id);


    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
