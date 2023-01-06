package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.BuyRepository;
import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.Goods;
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
    GoodsService goodsService;

    @Autowired
    BuyRepository buyRepository;

    public Buy saveBuy(Buy buy){

        for (BuyDetail buyDetail : buy.getBuyDetails()){
            buyDetail.setBuy(buy);

            //add some business process to update stock goods
            Goods good = buyDetail.getGood();
            good.setStock(good.getStock() + buyDetail.getAmount());

            goodsService.saveGoods(good);
        }

        buy.setBuyDetails(buy.getBuyDetails());
        buyRepository.save(buy);
        return buy;
    }

    public Iterable<Buy> findAllBuy(){
        return buyRepository.findAll();
    }
}
