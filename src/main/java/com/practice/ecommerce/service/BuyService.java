package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.BuyRepository;
import com.practice.ecommerce.dao.GoodsRepository;
import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BuyService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private BuyRepository buyRepository;

    @Transactional(readOnly = false)
    public Buy save(Buy buy){

        for (BuyDetail buyDetail : buy.getBuyDetails()){
            buyDetail.setBuy(buy);

            //add some business process to update stock goods
            Goods good = buyDetail.getGood();//weakness : stock doesn't read from db but from the request body
            good.setStock(good.getStock() + buyDetail.getAmount());

//            Goods goods1 = goodsRepository.findById(buyDetail.getId());
//            good.setStock(good.getStock()+goods1.getStock());

            goodsRepository.save(good);
        }

        buy.setBuyDetails(buy.getBuyDetails());
        buyRepository.save(buy);
        return buy;
    }
    @Transactional(readOnly = true)
    public List<Buy> findAll(){
        return buyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Buy> findById(long id){
        return buyRepository.findById(id);
    }
}
