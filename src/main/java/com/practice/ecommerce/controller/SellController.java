package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.Sell;
import com.practice.ecommerce.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @PostMapping
    public Sell save(@RequestBody Sell sell){
        return sellService.saveSellTransaction(sell);
    }

    @GetMapping
    public Iterable<Sell> findAll(){
        return sellService.findAllSell();
    }
}
