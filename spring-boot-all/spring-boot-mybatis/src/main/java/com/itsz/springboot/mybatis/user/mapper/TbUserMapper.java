package com.itsz.springboot.mybatis.user.mapper;

import com.itsz.springboot.mybatis.boot.MyBatisBaseDao;
import com.itsz.springboot.mybatis.user.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * TbUserMapper继承基类
 */
@Repository
public interface TbUserMapper extends MyBatisBaseDao<TbUser, Long> {
}