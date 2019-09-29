package com.itsz.springboot.security.user.service.impl;

import com.itsz.springboot.security.user.domain.User;
import com.itsz.springboot.security.user.mapper.UserMapper;
import com.itsz.springboot.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.loadUserByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isAccountNonLocked(), user.isCredentialsNonExpired(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
