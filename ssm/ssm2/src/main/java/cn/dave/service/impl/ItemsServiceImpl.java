package cn.dave.service.impl;

import cn.dave.dao.ItemsDao;
import cn.dave.domain.Items;
import cn.dave.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ssm2
 * @description:
 * @author: dave
 * @create: 2019-07-26 21:34
 **/
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;

    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }
}
