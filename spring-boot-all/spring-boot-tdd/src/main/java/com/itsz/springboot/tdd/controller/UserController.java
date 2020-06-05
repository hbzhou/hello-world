package com.itsz.springboot.tdd.controller;

import com.itsz.springboot.tdd.domain.TbUser;
import com.itsz.springboot.tdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<TbUser> queryAllUser() {
        return userService.findAllUser();
    }
}
