package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.BuyRepository;
import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BuyService {
    @PersistenceUnit
    EntityManagerFactory emf;

    @Autowired
    BuyRepository buyRepository;

    public Buy saveBuy(Buy buy){

        for (BuyDetail buyDetail : buy.getBuyDetails()){
            buyDetail.setBuy(buy);
        }

        buy.setBuyDetails(buy.getBuyDetails());
        buyRepository.save(buy);
        return buy;
    }

    public Iterable<Buy> findAllBuy(){
        return buyRepository.findAll();
    }
}
