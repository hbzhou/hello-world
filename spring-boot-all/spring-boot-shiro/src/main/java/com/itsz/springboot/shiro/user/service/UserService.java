package com.itsz.springboot.shiro.user.service;


import com.itsz.springboot.shiro.user.domain.TbUser;

public interface UserService {

    void insert(TbUser user);

    void update(TbUser user);

    void deleteById(Long id);

    TbUser selectById(Long id);

}
