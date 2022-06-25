package com.example.loginapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/user")
public class UserController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);
    @GetMapping(path="/ping")
    public String ping(){
        logger.info("welcome to user page");
        return "welcome to user page";
    }
}
