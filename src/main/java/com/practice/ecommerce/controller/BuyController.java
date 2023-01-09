package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/buy")
public class BuyController {
    @Autowired
    private BuyService service;

    @PostMapping
    public Buy save(@RequestBody Buy buy){
        return service.save(buy);
    }

    @GetMapping
    public List<Buy> findAll(){
        return service.findAll();
    }

    @GetMapping("search/{id}")
    public Optional<Buy> findById(@PathVariable("id") long id){
        return service.findById(id);
    }
}
