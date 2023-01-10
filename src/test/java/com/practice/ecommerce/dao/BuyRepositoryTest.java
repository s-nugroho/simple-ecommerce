package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Buy;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public class BuyRepositoryTest {
    @Autowired
    BuyRepository repository;
    @Autowired
    GoodsRepository goodsRepository;

    @Test
    @Order(1)
    void save(){
        Goods good = getGood();
        Buy buy = getBuy();
        List<BuyDetail> buyDetails = new ArrayList<>();

        buyDetails.add(getBuyDetail());
        buyDetails.get(0).setGood(good);
        buyDetails.get(0).setBuy(buy);

        buy.setBuyDetails(buyDetails);
        Assertions.assertNotNull(repository.save(buy));
    }

    @Test
    @Order(3)
    void findAll(){
        Assertions.assertEquals(repository.findAll().size(),1);
    }

    @Test
    @Order(2)
    void findOne(){
        Assertions.assertNotNull(repository.findById(1L));
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

    @BeforeAll
    public void preTest(){
        //considering to use val 'create' on "spring.jpa.hibernate.ddl-auto= . . . "
//        repository.deleteAll();
//        goodsRepository.deleteAll();
        goodsRepository.save(getGood());
    }
}
