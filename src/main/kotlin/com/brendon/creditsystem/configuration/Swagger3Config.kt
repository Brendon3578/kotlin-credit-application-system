package com.brendon.creditsystem.configuration

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Swagger3Config {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("springcreditsystem-public")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }

    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(Info()
                .title("Credit Application System")
                .version("1.0.0")
                .description("a REST API credit application system designed to facilitate the analysis and processing of credit applications")
            )
    }
}