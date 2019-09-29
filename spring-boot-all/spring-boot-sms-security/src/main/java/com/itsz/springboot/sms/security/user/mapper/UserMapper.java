package com.itsz.springboot.sms.security.user.mapper;


import com.itsz.springboot.sms.security.user.domain.User;

public interface UserMapper {

    User loadUserByUsername(String username);

    User loadUserByMobile(String mobile);
}
