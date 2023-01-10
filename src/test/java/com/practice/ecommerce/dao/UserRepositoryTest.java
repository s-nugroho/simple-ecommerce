package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    @Order(1)
    void save(){
        Assertions.assertNotNull(repository.save(getUser()));
    }

    @Test
    @Order(2)
    void findOne(){
        Assertions.assertEquals(repository.findById(1L).stream().count(),1);
    }

    @Test
    @Order(3)
    void delete(){
        repository.deleteAll();
        Assertions.assertEquals(repository.findAll().size(),0);
    }

    private User getUser(){
        User user = new User();
        user.setUsername("user 1");
        user.setPassword("user 1");
        return user;
    }
}
