package cn.dave.service.imp;

import cn.dave.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @program: spring_AOP
 * @description:
 * @author: dave
 * @create: 2019-07-02 09:29
 **/

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("保存了用户。。。");
//        throw  new RuntimeException("恭喜你，出现异常了！！");
    }

    public void updateAccount(int id) {
//        int i=1/0;
        System.out.println("更新了用户");
    }

    public int totalAccount() {
        System.out.println("用户总数为6");
        return 0;
    }
}
