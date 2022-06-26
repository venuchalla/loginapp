package com.example.loginapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class LoginController {

    @GetMapping(path = "")
    public String ping() {
        return "welcome login controller";
    }

    @GetMapping(path = "All")
    public String all() {
        return "username and password is not required";
    }

}
