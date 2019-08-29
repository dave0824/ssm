package cn.dave.dao;

import cn.dave.domain.User;

import java.util.List;

public interface IUserDao {
    /**
    * @Description: 查询所有
    * @Param: []
    * @return: java.util.List<cn.dave.domain.User>
    * @Author: dave
    * @Date: 2019/6/24
    */
    List<User> findAll();

    /**
    * @Description: 按Id查询
    * @Param: [id]
    * @return: cn.dave.domain.User
    * @Author: dave
    * @Date: 2019/6/24
    */
    User findById(Integer id);
    
    /** 
    * @Description: 添加一个用户 
    * @Param: [user] 
    * @return: void 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    void addUser(User user);
    
    /** 
    * @Description: 删除一个用户 
    * @Param: [id] 
    * @return: void 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    void deleteUser(Integer id);

    /** 
    * @Description: 更新用户 
    * @Param: [user] 
    * @return: void 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    void updateUser(User user);
    
    /** 
    * @Description: 统计人数 
    * @Param: [] 
    * @return: int 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    int countUser();
    
    /** 
    * @Description: 根据名字模糊查询 
    * @Param: [name] 
    * @return: java.util.List<cn.dave.domain.User> 
    * @Author: dave
    * @Date: 2019/6/24 
    */ 
    List<User>findByName(String name);
}
