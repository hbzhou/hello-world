package com.itsz.springboot.tdd.repository;

import com.itsz.springboot.tdd.domain.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface TbUserRepository extends JpaRepository<TbUser, Long> {
}
