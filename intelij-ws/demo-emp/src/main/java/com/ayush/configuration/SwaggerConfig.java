package com.ayush.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ayush"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Spring Boot Swagger Configuration")
                .description("\"Swagger Configuration Description\"")
                .version("1.1.0")
                .license("Apache 2/0")
                .licenseUrl("https://apache.org/")
                .contact(new Contact("Abhishek", "https://www.baeldung.com/spring-autowire","abc@abc.com"))
                .build();
    }
}
