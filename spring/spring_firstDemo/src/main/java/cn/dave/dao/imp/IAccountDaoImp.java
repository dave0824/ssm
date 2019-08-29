package cn.dave.dao.imp;

import cn.dave.dao.IAccountDao;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @program: factoryModel
 * @description:
 * @author: dave
 * @create: 2019-06-28 23:24
 **/

public class IAccountDaoImp implements IAccountDao {

    public void saveAccount() {
        System.out.println("dao保存用户");
    }
}
