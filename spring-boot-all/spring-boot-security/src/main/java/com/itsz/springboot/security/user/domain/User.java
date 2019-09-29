package com.itsz.springboot.security.user.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int id;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;

    private Date created;

    private Date updated;
}
