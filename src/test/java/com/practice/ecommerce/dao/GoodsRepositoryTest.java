package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoodsRepositoryTest {
    @Autowired
    GoodsRepository repository;
    @Test
    @Order(1)
    void save(){
        Assertions.assertNotNull(repository.save(getGood()));
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
    void delete(){
        repository.deleteById(1L);
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
}
