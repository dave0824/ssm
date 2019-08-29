package cn.dave.service.imp;

import cn.dave.dao.IAccountDao;
import cn.dave.dao.imp.IAccountDaoImp;
import cn.dave.factory.BeanFactory;
import cn.dave.service.IAccountService;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:28
 **/

public class IAccountServiceImp implements IAccountService {
    IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
