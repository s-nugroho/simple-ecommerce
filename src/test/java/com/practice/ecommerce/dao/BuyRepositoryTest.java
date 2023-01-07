package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class BuyRepositoryTest {
    @Autowired
    BuyRepository buyRepository;
    @Test
    void saveTest(){
//        ArrayList<BuyDetail> buydetail = new ArrayList<>();
//        buydetail.add(new BuyDetail(1,1,100,new Goods(),1));
//        Buy buy = new Buy(1,1,1,1,buydetail);
//        buyRepository.save(buy);
    }
}
