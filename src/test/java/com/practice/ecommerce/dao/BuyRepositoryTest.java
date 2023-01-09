package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.Goods;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class BuyRepositoryTest {
    @Autowired
    BuyRepository buyRepository;
    @Test
    void save(){
        Goods good = getGood();
        Buy buy = getBuy();
        List<BuyDetail> buyDetails = new ArrayList<>();

        buyDetails.add(getBuyDetail());
        buyDetails.get(0).setGood(good);
        buyDetails.get(0).setBuy(buy);


        buy.setBuyDetails(buyDetails);

        var verify = buyRepository.save(buy);
        Assertions.assertNotNull(verify);
    }

    @Test
    void findAll(){
        List<Buy> buys = buyRepository.findAll();
        Assertions.assertEquals(buys.size(),2);
    }

    @Test
    void findOne(){
        var verify = buyRepository.findById(2L);
        Assertions.assertNotNull(verify);
    }

    private Goods getGood(){
        Goods good = new Goods();
        good.setId(1);
        good.setName("Sprite");
        good.setBuyPrice(100);
        good.setSellPrice(200);
        good.setStock(10);
        return good;
    }

    private BuyDetail getBuyDetail(){
        BuyDetail buyDetail = new BuyDetail();
        buyDetail.setPrice(1000);
        buyDetail.setAmount(10);
        return buyDetail;
    }

    private Buy getBuy(){
        Buy buy = new Buy();
        buy.setDate(3);
        buy.setTime(3);
        buy.setSumOfPrice(300);
        return buy;
    }
}
