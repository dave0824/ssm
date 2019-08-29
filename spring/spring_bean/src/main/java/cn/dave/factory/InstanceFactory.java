package cn.dave.factory;

import cn.dave.service.IAccountService;
import cn.dave.service.imp.IAccountServiceImp;

/**
 * @program: spring_bean
 * @description:
 * @author: dave
 * @create: 2019-06-29 09:21
 **/

public class InstanceFactory {
    public IAccountService getIAccountServiceImp(){
        return new IAccountServiceImp();
    }
}
