package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.BuyTransactionRepository;
import com.practice.ecommerce.entity.BuyTransaction;
import com.practice.ecommerce.entity.DetailedBuyTransaction;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BuyTransactionService {
    @PersistenceUnit
    EntityManagerFactory emf;

    @Autowired
    BuyTransactionRepository buyTransactionRepository;

    public BuyTransaction saveBuyTransaction(BuyTransaction buyTransaction){

        for (DetailedBuyTransaction detailedBuyTransaction : buyTransaction.getDetailedBuyTransaction()){
            detailedBuyTransaction.setBuyTransaction(buyTransaction);
        }

        buyTransaction.setDetailedBuyTransaction(buyTransaction.getDetailedBuyTransaction());
        buyTransactionRepository.save(buyTransaction);
        return buyTransaction;
    }
}
