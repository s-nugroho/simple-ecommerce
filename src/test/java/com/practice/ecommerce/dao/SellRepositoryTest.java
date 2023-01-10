package com.practice.ecommerce.dao;

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
public class SellRepositoryTest {

    @Autowired
    private SellRepository repository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    @Order(1)
    void save(){
        Goods good = getGood();
        List<SellDetail> sellDetails = new ArrayList<>();
        Sell sell = getSell();

        sellDetails.add(getSellDetail());
        sellDetails.get(0).setGood(good);
        sellDetails.get(0).setSell(sell);

        sell.setSellDetails(sellDetails);
        Assertions.assertNotNull(repository.save(sell));
    }

    @Test
    @Order(2)
    void findAll(){
        Assertions.assertEquals(repository.findAll().size(),1);
    }

    @Test
    @Order(3)
    void findOne(){
        Assertions.assertNotNull(repository.findById(1L));
    }

    @Test
    @Order(4)
    void delete(){
        repository.deleteAll();
        Assertions.assertEquals(repository.findAll().size(),0);
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

    @BeforeAll
    public void preTest(){
        //considering to use val 'create' on "spring.jpa.hibernate.ddl-auto= . . . "
//        repository.deleteAll();
//        goodsRepository.deleteAll();
        goodsRepository.save(getGood());
    }
}
