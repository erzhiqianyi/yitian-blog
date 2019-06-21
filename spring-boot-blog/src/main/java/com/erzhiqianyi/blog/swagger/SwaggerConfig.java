package com.erzhiqianyi.blog.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {


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


    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.erzhiqianyi.blog.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo swaggerApiInfo() {
        return new ApiInfoBuilder().title("系统接口文档")
                .description("系统接口文档")
                .termsOfServiceUrl("https://github.com/erzhiqianyi")
                .contact(new Contact("二之前一", "www.erzhiqianyi.com", "erzhiqianyi@gmail.com"))
                .version("1.0")
                .build();
    }
}
