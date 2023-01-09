package com.practice.ecommerce.service;

import com.practice.ecommerce.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    void save(){
        User user = new User(1,"user1","user2");
        var verify = userService.save(user);
        Assertions.assertNotNull(verify);
    }

    @Test
    void find(){
        var verify = userService.findAll();
        Assertions.assertNotNull(verify);
    }

    @Test
    void findOne(){
        var verify = userService.findById(1);
        Assertions.assertNotNull(verify);
    }
}
