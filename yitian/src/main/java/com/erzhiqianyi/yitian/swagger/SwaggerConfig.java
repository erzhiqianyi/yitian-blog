package com.erzhiqianyi.yitian.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration//标记为配置文件
@EnableSwagger2WebFlux //开启Swagger ,项目使用WebFlux,所以要使用WebFlux相关的注解
public class SwaggerConfig {
    //配置Swagger属性

    //配置写在配置文件中，使用@Value注入
    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;

    @Value("${swagger.author}")
    private String author;

    @Value("${swagger.url}")
    private String url;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.email}")
    private String email;


    @Value("${swagger.basePackage}")
    private String controllerPackage;

    @Bean
    public Docket swaggerApi() {
        ParameterBuilder authorizationHeader = new ParameterBuilder();
        authorizationHeader.name("Authorization").description("Authorization")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的Authorization参数非必填，传空也可以
        List<Parameter> parameterList = Stream.of(authorizationHeader.build()).collect(toList());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerApiInfo())//指定Api配置信息
                .select()
                .apis(RequestHandlerSelectors.basePackage(controllerPackage))//指定路由类所在包
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList);
    }

    private ApiInfo swaggerApiInfo() {
        return new ApiInfoBuilder().title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(author, url, email))
                .version(version)
                .build();
    }
}
