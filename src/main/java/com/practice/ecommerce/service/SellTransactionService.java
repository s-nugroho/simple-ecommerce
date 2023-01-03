package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.SellTransactionRepository;
import com.practice.ecommerce.entity.DetailedSellTransaction;
import com.practice.ecommerce.entity.SellTransaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SellTransactionService {
    @Autowired
    SellTransactionRepository sellTransactionRepository;

    public SellTransaction saveSellTransaction(SellTransaction sellTransaction){
        for (DetailedSellTransaction detailedSellTransaction : sellTransaction.getDetailedSellTransactions()){
            detailedSellTransaction.setSellTransaction(sellTransaction);
        }
        sellTransaction.setDetailedSellTransactions(sellTransaction.getDetailedSellTransactions());
        return sellTransactionRepository.save(sellTransaction);
    }

    public Iterable<SellTransaction> findAllSellTransaction(){
        return sellTransactionRepository.findAll();
    }
}
