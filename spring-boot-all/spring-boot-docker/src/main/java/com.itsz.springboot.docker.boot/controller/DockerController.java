package com.itsz.springboot.docker.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @GetMapping("/hello")
    public String helloDocker(String name){
        return "hello,docker!!!" +name;
    }
}
