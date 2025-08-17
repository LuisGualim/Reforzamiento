package com.lg.reforzamiento.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
  info = @Info(
    title = "Productos API",
    version = "1.0",
    description = "CRUD de productos con Spring Boot + JPA + OpenAPI"
  )
)

public class ApiConfig {

}
