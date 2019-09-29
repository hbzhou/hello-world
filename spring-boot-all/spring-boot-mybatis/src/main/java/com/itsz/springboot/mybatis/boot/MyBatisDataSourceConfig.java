package com.itsz.springboot.mybatis.boot;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages =
        "com.itsz.springboot.mybatis.user.mapper"
        , sqlSessionFactoryRef = "mySqlSessionFactory")
public class MyBatisDataSourceConfig {

    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory createSessionFactory(@Autowired  DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        // locate the MyBatis mapper XML files
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));

        return sqlSessionFactory.getObject();
    }
}
