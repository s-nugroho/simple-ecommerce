package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.User;
import com.practice.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }

    @PutMapping
    public User update(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("search/{id}")
    public Optional<User> findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
}
