package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.SellRepository;
import com.practice.ecommerce.entity.Goods;
import com.practice.ecommerce.entity.SellDetail;
import com.practice.ecommerce.entity.Sell;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SellService {
    @Autowired
    SellRepository sellRepository;

    @Autowired
    GoodsService goodsService;

    public Sell saveSell(Sell sell){
        for (SellDetail sellDetail : sell.getSellDetails()){
            sellDetail.setSell(sell);

            //add some business process to update stock goods
            Goods good = sellDetail.getGood();
            good.setStock(good.getStock() - sellDetail.getAmount());

            goodsService.updateGoods(good);
        }
        sell.setSellDetails(sell.getSellDetails());
        return sellRepository.save(sell);
    }

    public List<Sell> findAllSell(){
        return sellRepository.findAll();
    }
}
