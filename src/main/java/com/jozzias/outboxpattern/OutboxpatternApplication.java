package com.jozzias.outboxpattern;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition(info = @Info(title = "Book API", version = "1.0", description = "API for managing books"))
@SpringBootApplication
@EnableScheduling
public class OutboxpatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutboxpatternApplication.class, args);
    }

}
