package com.itsz.spring.boot.activiti.boot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.itsz.spring.boot.activiti.repository"
})
@EntityScan(basePackages = {
        "com.itsz.spring.boot.activiti.domain"
})
@MapperScan(basePackages = {
        "com.itsz.spring.boot.activiti.mapper"

},sqlSessionFactoryRef = "mySqlSessionFactory")
public class DataSourceConfig {

    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory (@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();

        factory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classPath:/mapper/**/*.xml");

        factory.setMapperLocations(resources);
        return  factory.getObject();
    }
}
