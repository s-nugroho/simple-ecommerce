package com.practice.ecommerce.service;

import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoodsServiceTest {
    @Autowired
    GoodsService service;

    @Test
    @Order(1)
    void save(){
        Assertions.assertNotNull(service.save(getGood()));
    }

    @Test
    @Order(2)
    void findOne(){
        Assertions.assertNotNull(service.findById(1));
    }

    @Test
    void findAll(){
        service.save(getGood());
        Assertions.assertEquals(service.findAll().stream().count(),2);
    }

    private Goods getGood(){
        Goods good = new Goods();
        good.setName("Sprite");
        good.setBuyPrice(100);
        good.setSellPrice(200);
        good.setStock(10);
        return good;
    }
}
