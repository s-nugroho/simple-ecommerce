package com.practice.ecommerce.service;

import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GoodsServiceTest {
    @Autowired
    GoodsService goodsService;

    @Test
    void save(){
        Goods goods = new Goods(1,"Sprite",100,300,10);
        goodsService.save(goods);
        var verify = goodsService.findById(4);
        Assertions.assertNotNull(verify);
    }

    @Test
    void find(){
        var verify = goodsService.findById(4);
        Assertions.assertNotNull(verify);
    }

    @Test
    void findAll(){
        var verify = goodsService.findAll();
        Assertions.assertNotNull(verify);
    }
}
