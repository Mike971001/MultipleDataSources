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
import java.io.IOException;

/**
 * @author 今天不加班
 * @date 2024/3/28 09:07:43
 * <p>
 *     <b>数据源Multi1的MyBatis配置类</b>
 *     <ul>
 *         <li>1、配置数据源对应SqlSessionFactory对象</li>
 *         <li>2、配置对应DataSourceTransactionManager[数据库事务对象]</li>
 *         <li>3、配置对应SqlSessionTemplate对象</li>
 *     </ul>
 * </p>
 */
@Configuration
@MapperScan(basePackages = "com.demo.mapper.multi1", sqlSessionTemplateRef = "sqlSessionTemplateMulti1")
public class MyBatisConfigMulti1 {

    /**
     * <p>
     *     <b>配置SqlSessionFactory配置对象</b>
     *     <li>通过@Qualifer注入Datasource数据源</li>
     * </p>
     * @param dataSource 配置数据源
     * @return
     * @throws Exception
     */
    @Bean("sqlSessionFactoryMulti1")
    public SqlSessionFactory sqlSessionFactoryMulti1(@Qualifier("dataSourceMulti1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        //如果没有实体类就不要配置这个部分。如果配置可能会报错找不到bean对象
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources("classpath:mapper/multi1/*.xml"));//配置mapper的路径
        return sqlSessionFactory.getObject();
    }

    /**
     * <p>
     *     <b>配置数据源的事务管理器</b>
     * </p>
     * @param dataSource 数据源
     * @return
     */
    @Bean("dataSourceTransactionManagerMulti1")
    public DataSourceTransactionManager dataSourceTransactionManagerMulti1(@Qualifier("dataSourceMulti1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * <p>
     *     <b>配置SqlSessionTemplate对象</b>
     * </p>
     * @param sqlSessionFactory
     * @return
     */
    @Bean("sqlSessionTemplateMulti1")
    public SqlSessionTemplate sqlSessionTemplateMulti1(@Qualifier("sqlSessionFactoryMulti1") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
