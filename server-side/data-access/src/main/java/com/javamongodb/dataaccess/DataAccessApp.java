package com.javamongodb.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.javamongodb.dataaccess")
@PropertySource(value = "data.properties")
public class DataAccessApp {
    public static void main(String[] args) {
        SpringApplication.run(DataAccessApp.class, args);
    }
}
