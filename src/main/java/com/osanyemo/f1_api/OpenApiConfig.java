package com.osanyemo.f1_api;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Formula One API")
                        .description("RESTful API that provides data for a Formula 1 information system, including drivers, teams, and races.")
                        .version("1.0"));
    }
}