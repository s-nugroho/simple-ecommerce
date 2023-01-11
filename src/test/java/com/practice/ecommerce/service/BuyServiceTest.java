package com.practice.ecommerce.service;

import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BuyServiceTest {
    @Autowired
    private BuyService service;

    @Test
    @Order(1)
    void save(){
        Assertions.assertNotNull(service.save(getBuyFilled()));
    }

    @Test
    @Order(2)
    void findOne(){
        Assertions.assertNotNull(service.findById(1));
    }

    @Test
    @Order(3)
    void findAll(){
        service.save(getBuyFilled());
        Assertions.assertEquals(service.findAll().size(),2);
    }

    private Buy getBuyFilled(){
        Goods good = getGood();
        Buy buy = getBuy();
        List<BuyDetail> buyDetails = new ArrayList<>();

        buyDetails.add(getBuyDetail());
        buyDetails.get(0).setGood(good);
        buyDetails.get(0).setBuy(buy);

        buy.setBuyDetails(buyDetails);
        return buy;
    }

    private Goods getGood(){
        Goods good = new Goods();
//        good.setId(1);
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
