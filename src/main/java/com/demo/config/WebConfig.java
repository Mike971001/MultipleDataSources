package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author: 今天不加班
 * @date: 2024/4/3 11:39:12
 * @description:
 * <p>
 *     配置MessageConverter：
 *     Spring Boot使用MessageConverter来将HTTP请求和响应体转换为特定的数据类型。为了处理XML数据，
 *     你需要配置一个支持XML格式的MessageConverter。Spring Boot通常会自动配置Jackson XML，
 *     但你可以自定义配置以确保它被正确使用。
 * </p>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 配置jacksonXml的转换器
        converters.add(new MappingJackson2XmlHttpMessageConverter());
    }
}
