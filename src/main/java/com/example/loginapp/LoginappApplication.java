package com.example.loginapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginappApplication {
    private static Logger logger = LoggerFactory.getLogger(LoginappApplication.class);
    public static void main(String[] args) {
        logger.info("application is stating");
        SpringApplication.run(LoginappApplication.class, args);
    }

}
