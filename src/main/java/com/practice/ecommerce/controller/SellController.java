package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.Sell;
import com.practice.ecommerce.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sell")
public class SellController {
    @Autowired
    private SellService service;

    @PostMapping
    public Sell save(@RequestBody Sell sell){
        return service.save(sell);
    }

    @GetMapping
    public List<Sell> findAll(){
        return service.findAll();
    }
}
