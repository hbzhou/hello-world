package com.itsz.springboot.shiro.user.service.impl;

import com.itsz.springboot.shiro.user.domain.TbUser;
import com.itsz.springboot.shiro.user.mapper.TbUserMapper;
import com.itsz.springboot.shiro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;


    @Override
    public void insert(TbUser user) {
        userMapper.insert(user);
    }

    @Override
    public void update(TbUser user) {
         userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TbUser selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}