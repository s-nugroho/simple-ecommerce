package com.practice.ecommerce.service;

import com.practice.ecommerce.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {
    @Autowired
    UserService service;
    @Test
    @Order(1)
    void save(){
        Assertions.assertNotNull(service.save(getUser()));
    }

    @Test
    @Order(3)
    void findAll(){
        service.save(getUser());
        Assertions.assertEquals(service.findAll().size(),2);
    }

    @Test
    @Order(2)
    void findOne(){
        Assertions.assertNotNull(service.findById(1));
    }

    private User getUser(){
        User user = new User();
        user.setUsername("user 1");
        user.setPassword("user 1");
        return user;
    }
}
