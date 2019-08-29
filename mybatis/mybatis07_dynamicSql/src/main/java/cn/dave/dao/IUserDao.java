package cn.dave.dao;

import cn.dave.domain.QueryVo;
import cn.dave.domain.User;

import java.util.List;

public interface IUserDao {

    /**
    * @Description: 按User查询
    * @Param: [id]
    * @return: cn.dave.domain.User
    * @Author: dave
    * @Date: 2019/6/24
    */
    List<User> findByUser(User user);

    /**
    * @Description: 根据ids 查询用户
    * @Param: [queryVo]
    * @return: java.util.List<cn.dave.domain.User>
    * @Author: dave
    * @Date: 2019/6/26
    */
    List<User> findByIds(QueryVo queryVo);

}
