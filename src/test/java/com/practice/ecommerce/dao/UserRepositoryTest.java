package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void save(){
        var save = userRepository.save(new User(1,"user2","user2"));
        Assertions.assertNotNull(save);
    }

    @Test
    void findOne(){
        var find = userRepository.findById(Long.valueOf(1));
        Assertions.assertNotNull(find);
    }
}
