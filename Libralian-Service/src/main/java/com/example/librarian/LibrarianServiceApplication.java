package com.example.librarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LibrarianServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibrarianServiceApplication.class, args);
    }
}
