package com.example.fdl.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("fdl")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.fdl.Controller"))
                .build();
    }


    //作者信息
    Contact contact = new Contact("范夕晨", "http://localhost/", "2276284591@qq.com");
    /*配置swagger信息*/
    private ApiInfo apiInfo(){
        //作者信息
        return new ApiInfo("范夕晨swagger日志",
                "接口文档",
                "1.1",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
