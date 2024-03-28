package com.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 今天不加班
 * @date 2024/3/28 18:38:48
 * <p>
 *     <b>DruidDataSource配置</b>
 *     参考：https://blog.csdn.net/weixin_43859729/article/details/112171048
 * </p>
 */
@Configuration
public class DruidDataSourceConfig {

    @Bean(value = "dataSourceMulti1")
    @ConfigurationProperties(prefix = "spring.datasource.druid.multi1")
    public DataSource dataSourceMulti1(){
        return new DruidDataSource();
    }

    @Bean("dataSourceMulti2")
    @ConfigurationProperties(prefix = "spring.datasource.druid.multi2")
    public DataSource dataSourceMulti2(){
        return new DruidDataSource();
    }
}
