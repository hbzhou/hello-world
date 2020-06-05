package com.itsz.springboot.tdd.service;

import com.itsz.springboot.tdd.domain.TbUser;

import java.util.List;

public interface UserService {
    List<TbUser> findAllUser();
}
