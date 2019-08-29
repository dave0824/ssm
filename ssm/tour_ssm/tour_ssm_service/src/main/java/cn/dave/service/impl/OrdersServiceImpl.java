package cn.dave.service.impl;

import cn.dave.dao.IOrdersDao;
import cn.dave.domain.Orders;
import cn.dave.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-04 11:42
 **/

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {

        //参数page 是页码值   参数size 代表是每页显示条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }
}
