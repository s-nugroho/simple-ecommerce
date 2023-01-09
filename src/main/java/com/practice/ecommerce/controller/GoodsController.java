package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.Goods;
import com.practice.ecommerce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/goods")
public class GoodsController {
    @Autowired
    private GoodsService service;

    @PostMapping
    public Goods save(@RequestBody Goods goods){
        return service.save(goods);
    }

    @GetMapping
    public List<Goods> findAll(){
        return service.findAll();
    }

    @GetMapping("search/{id}")
    public Optional<Goods> findById(@PathVariable("id") long id){
        return service.findById(id);
    }
}
