package com.practice.ecommerce.service;

import com.practice.ecommerce.entity.Goods;
import com.practice.ecommerce.entity.Sell;
import com.practice.ecommerce.entity.SellDetail;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SellServiceTest {

    @Autowired
    private SellService service;

    @Test
    @Order(1)
    void save(){
        Assertions.assertNotNull(service.save(getSellFilled()));
    }

    @Test
    @Order(3)
    void findAll(){
        service.save(getSellFilled());
        Assertions.assertEquals(service.findAll().size(),2);
    }

    @Test
    @Order(2)
    void findOne(){
        Assertions.assertNotNull(service.findOne(1L));
    }

    private Sell getSellFilled(){
        Goods good = getGood();
        List<SellDetail> sellDetails = new ArrayList<>();
        Sell sell = getSell();

        sellDetails.add(getSellDetail());
        sellDetails.get(0).setGood(good);
        sellDetails.get(0).setSell(sell);

        sell.setSellDetails(sellDetails);

        return sell;
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

    private SellDetail getSellDetail(){
        SellDetail sellDetail = new SellDetail();
        sellDetail.setPrice(300);
        sellDetail.setAmount(1);

        return sellDetail;
    }

    private Sell getSell(){
        Sell sell = new Sell();
        sell.setDate(1);
        sell.setTime(1);
        sell.setSumOfPrice(300);

        return sell;
    }
}
