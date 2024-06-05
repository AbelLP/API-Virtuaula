package com.example.apivirtuaula.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIDocumentation {

    @Bean
    public OpenAPI getOpenAPI(){
        return new OpenAPI().components(new Components()).info(new Info().title("API Rest Virtu@uala")
                .description("API Virtu@ula"));
    }

}
