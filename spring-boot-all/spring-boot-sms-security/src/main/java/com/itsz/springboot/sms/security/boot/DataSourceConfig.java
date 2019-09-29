package com.itsz.springboot.sms.security.boot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {
        "com.itsz.springboot.sms.security.user.mapper"
}, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath:/mapper/*.xml");

        sqlSessionFactoryBean.setMapperLocations(resources);

        return sqlSessionFactoryBean.getObject();
    }
}
