package com.example.loginapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping(value = "/ping")
    public String ping() {
        return "welcome login controller";
    }

}
