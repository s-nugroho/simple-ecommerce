package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {
    @Autowired
    UserController controller;

    @Test
    @Order(1)
    void save(){
        Assertions.assertNotNull(controller.save(getUser()));
    }

    @Test
    @Order(2)
    void findAll(){
        controller.save(getUser());
        Assertions.assertEquals(controller.findAll().size(),2);
    }

    @Test
    @Order(3)
    void findOne(){
        Assertions.assertNotNull(controller.findById(1L));
    }

    @Test
    @Order(4)
    void update(){
        User user = new User(1,"user update","password update");
        controller.update(user);

        String username1 = controller.findById(1L).get().getUsername();
        String username2 = user.getUsername();

        Assertions.assertTrue(username1.equals(username2));
    }

    private User getUser(){
        User user = new User();
        user.setUsername("user 1");
        user.setPassword("user 1");
        return user;
    }
}
