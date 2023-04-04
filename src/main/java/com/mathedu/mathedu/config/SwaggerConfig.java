package com.mathedu.mathedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .tags(
                        new Tag("관리자 기능", "관리자 기능 API (반, 선생님, 관리자)"),
                        new Tag("자료실 관리", "자료실 CRUD API"),
                        new Tag("공지사항 관리", "공지사항 CRUD API"),
                        new Tag("학생정보 관리", "학생정보 CRUD API"),
                        new Tag("선생님 정보", "선생님 정보 API"),
                        new Tag("시험 정보 관리", "시험 정보 CRUD API"),
                        new Tag("반 정보", "반 정보 API - 시험 점수/반 학생리스트")
                )
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        String description = "Mathedu 서비스 API 문서";
        return new ApiInfoBuilder()
                .title("Mathedu API Documentation")
                .description(description)
                .version("1.0.10")
                .build();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
