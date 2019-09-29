package com.itsz.springboot.sms.security.auth.controller;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SMSCode {

    private String code;

    private LocalDateTime expireTime;

    public SMSCode(String code ,int expire) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expire);
    }
}
