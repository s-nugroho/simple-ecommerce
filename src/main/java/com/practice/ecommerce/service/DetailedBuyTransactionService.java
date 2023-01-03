package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.DetailedBuyTransactionRepository;
import com.practice.ecommerce.entity.DetailedBuyTransaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DetailedBuyTransactionService {
    @Autowired
    DetailedBuyTransactionRepository detailedBuyTransactionRepository;

    public List<DetailedBuyTransaction> findAllDetailedBuy(){
        return detailedBuyTransactionRepository.findAll();
    }
}
