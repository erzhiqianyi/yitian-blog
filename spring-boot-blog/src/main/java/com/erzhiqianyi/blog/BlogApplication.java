package com.erzhiqianyi.blog;

import com.erzhiqianyi.blog.handler.ResponseWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@SpringBootApplication
@MapperScan({"com.erzhiqianyi.blog.dao.mapper.user"})
public class BlogApplication {

    @Value("${spring.datasource.maximum-pool-size}")
    private int connectionPoolSize;

    @Bean
    public Scheduler jdbcScheduler() {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(connectionPoolSize));
    }


    @Autowired
    private ServerCodecConfigurer serverCodecConfigurer;

    @Autowired
    private RequestedContentTypeResolver requestedContentTypeResolver;

    @Bean
    public ResponseWrapper responseWrapper() {
        return new ResponseWrapper(serverCodecConfigurer
                .getWriters(), requestedContentTypeResolver);
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }


}
