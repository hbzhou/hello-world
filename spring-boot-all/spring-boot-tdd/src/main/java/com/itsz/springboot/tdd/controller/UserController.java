package com.itsz.springboot.tdd.controller;

import com.itsz.springboot.tdd.domain.TbUser;
import com.itsz.springboot.tdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<TbUser>> queryAllUser() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<TbUser> saveUser(@RequestBody TbUser user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
