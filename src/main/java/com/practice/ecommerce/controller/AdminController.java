package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.Admin;
import com.practice.ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping
    public Admin save(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @GetMapping
    public Iterable<Admin> findAll(){
        return adminService.findAllAdmin();
    }

    @PutMapping
    public Admin deleteAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @GetMapping("search/{id}")
    public Admin findAdminById(@PathVariable("id") Long id){
        return adminService.findAdminById(id);
    }
}
