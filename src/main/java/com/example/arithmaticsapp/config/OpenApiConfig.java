package com.example.arithmaticsapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Arithmetic operations API",
                description = "Test task", version = "1.0.0",
                contact = @Contact(
                        name = "Osokin Egor",
                        email = "egorosokin085@gmail.com"
                )
        )
)
public class OpenApiConfig {

}
