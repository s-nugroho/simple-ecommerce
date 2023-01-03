package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/buy")
public class BuyController {
    @Autowired
    BuyService buyService;

    @PostMapping
    public Buy save(@RequestBody Buy buy){
        return buyService.saveBuy(buy);
    }

    @GetMapping
    public Iterable<Buy> findAll(){
        return buyService.findAllBuy();
    }
}
