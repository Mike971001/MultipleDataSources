package com.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author 今天不加班
 * @date 2024/3/28 10:02:56
 * <p>
 *     <b>配置Multi2的MyBatis相关对象</b>
 * </p>
 */
@Configuration
@MapperScan(basePackages = "com.demo.mapper.multi2", sqlSessionTemplateRef = "sqlSessionTemplateMulti2")
public class MyBatisConfigMulti2 {

    @Bean("sqlSessionFactoryMulti2")
    public SqlSessionFactory sqlSessionFactoryMulti2(@Qualifier("dataSourceMulti2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactory.setDataSource(dataSource);
        //设置mapper2的路径
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/multi2/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean("dataSourceTransactionManagerMulti2")
    public DataSourceTransactionManager dataSourceTransactionManagerMulti2(@Qualifier("dataSourceMulti2")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplateMulti2")
    public SqlSessionTemplate sqlSessionTemplateMulti2(@Qualifier("sqlSessionFactoryMulti2") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
