package com.practice.ecommerce.controller;

import com.practice.ecommerce.entity.BuyTransaction;
import com.practice.ecommerce.service.BuyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/buytransaction")
public class BuyTransactionController {
    @Autowired
    BuyTransactionService buyTransactionService;

    @PostMapping
    public BuyTransaction save(@RequestBody BuyTransaction buyTransaction){
        return buyTransactionService.saveBuyTransaction(buyTransaction);
    }

    @GetMapping
    public Iterable<BuyTransaction> findAll(){
        return buyTransactionService.findAllBuyTransaction();
    }
}
