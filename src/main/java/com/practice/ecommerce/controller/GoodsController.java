package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.Goods;
import com.practice.ecommerce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public Goods save(@RequestBody Goods goods){
        return goodsService.saveGoods(goods);
    }

    @GetMapping
    public List<Goods> findAll(){
        return goodsService.findAllGoods();
    }

    @GetMapping("search/{id}")
    public Goods findById(@PathVariable("id") long id){
        return goodsService.findGoodsById(id);
    }
}
