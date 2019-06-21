package com.erzhiqianyi.blog.swagger;

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

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.erzhiqianyi.blog.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo swaggerApiInfo() {
        return new ApiInfoBuilder().title("webflux-swagger2 API doc")
                .description("how to use this")
                .termsOfServiceUrl("https://github.com/Gsealy")
                .contact(new Contact("二之前一", "www.erzhiqianyi.com", "erzhiqianyi@gmail.com"))
                .version("1.0")
                .build();
    }
}
