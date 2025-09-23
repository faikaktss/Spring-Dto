package com.faik.Starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.faik.Controller", 
    "com.faik.Services", 
    "com.faik.Repository",
    "com.faik.Starter"
})
@EntityScan(basePackages = {"com.faik.Entites"})
@EnableJpaRepositories(basePackages = {"com.faik.Repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}