package com.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author 今天不加班
 * @date 2024/3/28 08:45:12
 * <p>
 *     数据源配置
 * </p>
 */
//@Configuration
public class DataSourceConfig {

    /**
     * <p>
     * <b>配置数据源Multi1的DataSourceProperties对象</b>
     *     <ul>
     *         <li>@Bean注解声明创建的Bean对象名称,方便后面生成对应数据源的DataSource对象</li>
     *         <li>使用@ConfigurationProperties注解读取配置文件中的yml属性，来设置数据库配置信息</li>
     *         <li>最后创建通过自动装配返回DataSourceProperties对象</li>
     *     </ul>
     * </p>
     * @return DataSourceProperties的Bean对象方便产生Multi1的数据源对象
     */
    @Primary
    @Bean("dataSourcePropertiesMulti1")
    @ConfigurationProperties(prefix = "spring.datasource.multi1")
    public DataSourceProperties dataSourcePropertiesMulti1() {
        return new DataSourceProperties();
    }

    /**
     * <p>
     *     <b>配置数据源Multi1的DataSource对象</b>
     *     <ul>
     *         <li>@Bean注解定义数据源Multi1的DataSource对象的bean名称</li>
     *         <li>@Qualifier注解[按照名称注入]注入上面声明的Multi1d的DataSourceProperties的bean对象</li>
     *         <li>调用方法返回Multi1的DataSource对象</li>
     *     </ul>
     * </p>
     * @param dataSourceProperties 数据源属性对象
     * @return Multi1的Datasource的Bean对象
     */
    @Primary
    @Bean("dataSourceMulti1")
    public DataSource dataSourceMulti1(@Qualifier("dataSourcePropertiesMulti1")DataSourceProperties dataSourceProperties ){
        return dataSourceProperties
                // 初始化
                .initializeDataSourceBuilder()
                // 构建
                .build();
    }

    @Primary
    @Bean("dataSourcePropertiesMulti2")
    @ConfigurationProperties(prefix = "spring.datasource.multi2")
    public DataSourceProperties dataSourcePropertiesMulti2(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean("dataSourceMulti2")
    public DataSource dataSourceMulti2(@Qualifier("dataSourcePropertiesMulti2")DataSourceProperties dataSourceProperties ){
        return dataSourceProperties
                // 初始化
                .initializeDataSourceBuilder()
                // 构建
                .build();
    }
}
