package com.itsz.springboot.shiro.auth.controller;

import com.itsz.springboot.shiro.user.domain.TbUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public void login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
        } catch (LockedAccountException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        TbUser user = (TbUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

}
