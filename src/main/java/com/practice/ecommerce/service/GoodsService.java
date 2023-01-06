package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.GoodsRepository;
import com.practice.ecommerce.entity.Goods;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GoodsService {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Autowired
    private GoodsRepository goodsRepository;

    public Goods saveGoods(Goods goods){
        return goodsRepository.save(goods);
    }

    public Iterable<Goods> findAllGoods(){
        return goodsRepository.findAll();
    }

    public Goods findGoodsById(long id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Goods> query = em.createQuery("SELECT g FROM Goods g WHERE g.id=:id", Goods.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public void updateGoods(Goods goods){
        goodsRepository.save(goods);
    }
}
