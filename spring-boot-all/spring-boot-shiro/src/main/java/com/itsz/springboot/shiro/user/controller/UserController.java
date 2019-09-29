package com.itsz.springboot.shiro.user.controller;

import com.itsz.springboot.shiro.user.domain.TbUser;
import com.itsz.springboot.shiro.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "User", tags = "USER", description = "User Service")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public TbUser selectById(@PathVariable(name = "id") long id) {
        return userService.selectById(id);
    }

    @PostMapping("/")
    @Transactional
    public void insert(@RequestBody TbUser user) {
        userService.insert(user);
    }

    @PutMapping("/")
    public void update(@RequestBody TbUser user) {
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        userService.deleteById(id);
    }


}
