package com.javamongodb.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.*")
public abstract class WebApp extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApp.class, args);
    }
}
