package com.itsz.springboot.aop.boot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SystemLog {

    private static final long serialVersionUID = -6309732882044872298L;

    private Integer id;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
}
