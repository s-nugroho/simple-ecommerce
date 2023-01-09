package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.UserRepository;
import com.practice.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = false)
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = false)
    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }
}
