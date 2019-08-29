package cn.dave.service;

import cn.dave.domain.SysLog;

import java.util.List;

public interface ISysLogService{

        void save(SysLog sysLog);

    List<SysLog> findAll();
}
