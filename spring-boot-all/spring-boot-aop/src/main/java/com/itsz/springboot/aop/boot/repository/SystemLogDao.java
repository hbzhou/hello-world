package com.itsz.springboot.aop.boot.repository;

import com.itsz.springboot.aop.boot.domain.SystemLog;

public interface SystemLogDao {

    void saveSystemLog(SystemLog systemLog);
}
