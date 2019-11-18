package com.erzhiqianyi.yitian.common.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MapperConfig {
    //注册插件
    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        //设置参数，比如阈值等，可以在配置文件中配置，这里直接写死便于测试
        Properties properties = new Properties();
        properties.setProperty("limit", "10");
        properties.setProperty("dbType", "MYSQL");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
