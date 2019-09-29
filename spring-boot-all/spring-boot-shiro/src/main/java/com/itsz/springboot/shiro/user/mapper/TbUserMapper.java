package com.itsz.springboot.shiro.user.mapper;

import com.itsz.springboot.shiro.boot.MyBatisBaseDao;
import com.itsz.springboot.shiro.user.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * TbUserMapper继承基类
 */
@Repository
public interface TbUserMapper extends MyBatisBaseDao<TbUser, Long> {

    TbUser findByUserName(String userName);
}