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
        goodsService.saveGoods(goods);
        var verify = goodsService.findGoodsById(4);
        Assertions.assertNotNull(verify);
    }

    @Test
    void find(){
        var verify = goodsService.findGoodsById(4);
        Assertions.assertNotNull(verify);
    }

    @Test
    void findAll(){
        var verify = goodsService.findAllGoods();
        Assertions.assertNotNull(verify);
    }
}
