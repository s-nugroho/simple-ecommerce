package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.User;
import com.practice.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public User save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public Iterable<User> findAll(){
        return userService.findAllUser();
    }

    @PutMapping
    public User deleteAdmin(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("search/{id}")
    public User findAdminById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }
}
