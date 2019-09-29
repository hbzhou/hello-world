package com.itsz.springboot.mybatis.user.service;

import com.itsz.springboot.mybatis.user.domain.TbUser;

public interface UserService {

    void insert(TbUser user);

    void update(TbUser user);

    void deleteById (Long id);

    TbUser selectById(Long id);

}
