package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Goods;
import com.practice.ecommerce.entity.Sell;
import com.practice.ecommerce.entity.SellDetail;
import org.hibernate.sql.ast.tree.expression.Over;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SellRepositoryTest {

    @Autowired
    SellRepository sellRepository;

    @Test
    void save(){
        Goods good = getGood();
        List<SellDetail> sellDetails = new ArrayList<>();
        Sell sell = getSell();

        sellDetails.add(getSellDetail());
        sellDetails.get(0).setGood(good);
        sellDetails.get(0).setSell(sell);

        sell.setSellDetails(sellDetails);
        var verify = sellRepository.save(sell);
        Assertions.assertNotNull(verify);
    }

    @Test
    void findAll(){
        var verify = sellRepository.findAll().size();
        Assertions.assertEquals(verify,2);
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
}
