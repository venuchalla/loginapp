package com.example.loginapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/admin")
public class AdminController {
    private static Logger logger = LoggerFactory.getLogger(AdminController.class);
    @GetMapping(path="/ping" )
    String ping(){
        return "welcome admin page";
    }
}
