package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.GoodsRepository;
import com.practice.ecommerce.dao.SellRepository;
import com.practice.ecommerce.entity.Goods;
import com.practice.ecommerce.entity.SellDetail;
import com.practice.ecommerce.entity.Sell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SellService {
    @Autowired
    private SellRepository sellRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Transactional(readOnly = false)
    public Sell save(Sell sell){
        for (SellDetail sellDetail : sell.getSellDetails()){
            sellDetail.setSell(sell);

            //add some business process to update stock goods
            Goods good = sellDetail.getGood();
            good.setStock(good.getStock() - sellDetail.getAmount());

            goodsRepository.save(good);
        }
        sell.setSellDetails(sell.getSellDetails());
        return sellRepository.save(sell);
    }

    @Transactional(readOnly = true)
    public List<Sell> findAll(){
        return sellRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Sell> findOne(Long id){
        return sellRepository.findById(id);
    }
}
