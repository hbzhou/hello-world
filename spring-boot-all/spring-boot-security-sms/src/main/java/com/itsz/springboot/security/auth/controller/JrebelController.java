package com.itsz.springboot.security.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JrebelController {

    @GetMapping("/helloworld")
    public String helloworld() {
        return "Hello Jrebel!!!";
    }
}
