package com.itsz.springboot.security.user.mapper;

import com.itsz.springboot.security.user.domain.User;

public interface UserMapper {

    User loadUserByUsername (String username);
}
