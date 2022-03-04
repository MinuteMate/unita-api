package com.minutemate.unitaapi.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String TITLE = "Unita API ";
    private static final String DESCRIPTION = "Unithon 2022 참가팀 미닛메이트의 Unita API 입니다.";
    @Bean
    public Docket apiV1() {
        
        String version = "V1";
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .apiInfo(generateInfo(version));
    }

    private ApiInfo generateInfo(String version) {
        return new ApiInfoBuilder()
                .title(TITLE + version)
                .description(DESCRIPTION)
                .version(version)
                .build();
    }
}
