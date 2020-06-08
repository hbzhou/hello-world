package com.itsz.springboot.tdd.service.impl;

import com.itsz.springboot.tdd.domain.TbUser;
import com.itsz.springboot.tdd.repository.TbUserRepository;
import com.itsz.springboot.tdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserRepository userRepository;


    @Override
    public List<TbUser> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public TbUser save(TbUser user) {
        return userRepository.save(user);
    }
}
