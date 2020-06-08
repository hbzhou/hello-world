package com.itsz.springboot.tdd.service;

import com.itsz.springboot.tdd.repository.TbUserRepository;
import com.itsz.springboot.tdd.domain.TbUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private TbUserRepository userRepository;

    @Test
    void testFindAllUser() {
        TbUser user = new TbUser(1, "jeremy", "jeremy@localhost.com");
        userRepository.save(user);

        List<TbUser> userList = userService.findAllUser();
        TbUser tbUser = userList.get(userList.size() - 1);

        assertEquals(user.getId(), tbUser.getId());
        assertEquals(user.getEmail(), tbUser.getEmail());
        assertEquals(user.getUsername(), tbUser.getUsername());

    }

    @Test
    void testSaveUSer() {
        TbUser user = new TbUser(1, "Jeremy", "jeremy@Localhost.com");
        userService.save(user);

        assertEquals(1, userRepository.count());
    }
}