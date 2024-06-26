package com.soccer.teams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TeamsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamsApplication.class, args);
    }
}
