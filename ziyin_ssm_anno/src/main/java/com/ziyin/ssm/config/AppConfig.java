package com.ziyin.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author ziyin
 @create 2019-07-2019/7/3-8:23
 */

@ComponentScan(value = "com.ziyin.ssm", excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
//@Import({JdbcConfig.class,TransactionConfig.class}) //导入注解配置
//@ImportResource("classpath:applicationContext.xml") //导入xml配置项
@MapperScan("com.ziyin.ssm.dao")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig {


    /**
     * 数据源配置
     * @param propertiesConfig
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource(PropertiesConfig propertiesConfig) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(propertiesConfig.getUsername());
        dataSource.setPassword(propertiesConfig.getPassword());
        dataSource.setUrl(propertiesConfig.getUrl());
        dataSource.setDriverClassName(propertiesConfig.getDriver());
        return dataSource;
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, PropertiesConfig propertiesConfig)
            throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(propertiesConfig.getMybatisTypeAliasPackage());
        // 动态获取SqlMapper
        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
        // sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(propertiesConfig.getMybatisMapperLocations()));
        return sqlSessionFactoryBean;
    }


    /**
     * 配置spring的声明式事务
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;

    }


}
