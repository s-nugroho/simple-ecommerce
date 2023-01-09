package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GoodsRepositoryTest {

    @Autowired
    GoodsRepository goodsRepository;
    @Test
    void save(){
        Goods goods = new Goods(1,"Sprite",100,200,10);
        var save = goodsRepository.save(goods);
        Assertions.assertNotNull(save);
    }

    @Test
    void findAll(){
        var find = goodsRepository.findAll();
        Assertions.assertNotNull(find);
    }

    @Test
    void findOne(){
        var verify = goodsRepository.findById(1L);
        Assertions.assertNotNull(verify);
    }

    @Test
    void delete(){
        goodsRepository.deleteById(3L);
//        var findDeleted = goodsRepository.findById(1L);
        assertThat(goodsRepository.count()).isEqualTo(0);
    }
}
