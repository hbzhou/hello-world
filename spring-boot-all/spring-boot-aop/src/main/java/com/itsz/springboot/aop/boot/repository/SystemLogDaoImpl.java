package com.itsz.springboot.aop.boot.repository;

import com.itsz.springboot.aop.boot.domain.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SystemLogDaoImpl implements SystemLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveSystemLog(SystemLog systemLog) {
        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(username,operation,time,method,params,ip,create_time) ");
        sql.append("values(:username,:operation,:time,:method,");
        sql.append(":params,:ip,:createTime)");

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        namedParameterJdbcTemplate.update(sql.toString(),new BeanPropertySqlParameterSource(systemLog));
    }
}
