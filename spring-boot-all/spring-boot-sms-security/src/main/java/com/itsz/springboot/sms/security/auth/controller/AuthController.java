package com.itsz.springboot.sms.security.auth.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
public class AuthController {
    public final static String SESSION_KEY_SMS_CODE = "SESSION_KEY_SMS_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/sms")
    public void codeSMS(HttpServletRequest request, String mobileNo) {

        int code = new Random().nextInt(89999) + 100000;

        System.out.println("smsCode is " + code);

        SMSCode smsCode = new SMSCode(code + "", 60);

        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_SMS_CODE + mobileNo, smsCode);

    }

    @GetMapping("/")
    @PreAuthorize("isAuthenticated()")
    public String helloworld (){
        return "Hello,World!!";
    }


}
