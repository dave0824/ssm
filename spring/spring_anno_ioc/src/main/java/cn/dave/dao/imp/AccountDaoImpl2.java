package cn.dave.dao.imp;

import cn.dave.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @program: spring_anno_ioc
 * @description:
 * @author: dave
 * @create: 2019-06-29 21:26
 **/

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("dao2保存了账户");
    }
}
