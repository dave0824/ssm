package cn.dave.service.impl;

import cn.dave.dao.ISysLogDao;
import cn.dave.domain.SysLog;
import cn.dave.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-06 16:43
 **/
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
