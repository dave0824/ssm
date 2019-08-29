package cn.dave.dao.imp;

import cn.dave.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @program: spring_anno_ioc
 * @description:
 * @author: dave
 * @create: 2019-06-29 21:26
 **/

@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("dao保存了账户");
    }
}
