package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BuyRepositoryTest {
    @Autowired
    BuyRepository buyRepository;
    @Test
    void saveTest(){
        Goods good = getGood();

        List<BuyDetail> buyDetails = new ArrayList<BuyDetail>();
        buyDetails.add(getBuyDetail());
        buyDetails.get(0).setGood(good);
        buyDetails.get(0).setBuy(getBuy());

        Buy buy = getBuy();
        buy.setBuyDetails(buyDetails);
        var verify = buyRepository.save(buy);
        Assertions.assertNotNull(verify);
    }

    private Goods getGood(){
        Goods good = new Goods();
        good.setId(4);
        good.setName("Sprite");
        good.setBuyPrice(100);
        good.setSellPrice(300);
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
        buy.setId(1);
        buy.setDate(1);
        buy.setTime(1);
        buy.setSumOfPrice(100);
        return buy;
    }
}
