package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.SellTransaction;
import com.practice.ecommerce.service.SellTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/selltransaction")
public class SellTransactionController {
    @Autowired
    private SellTransactionService sellTransactionService;

    @PostMapping
    public SellTransaction save(@RequestBody SellTransaction sellTransaction){
        return sellTransactionService.saveSellTransaction(sellTransaction);
    }

    @GetMapping
    public Iterable<SellTransaction> findAll(){
        return sellTransactionService.findAllSellTransaction();
    }
}
