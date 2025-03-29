package com.graduation.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("강아지 커뮤니티 API")
                        .description("PawMate 백엔드 API 명세서입니다.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("강아지 프로젝트 팀")
                                .email("team@pawmate.com")
                        )
                );
    }
}
