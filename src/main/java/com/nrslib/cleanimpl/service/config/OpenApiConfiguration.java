package com.nrslib.cleanimpl.service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Clean Impl")
                                .version("1.0.0")
                );
    }
}
