package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.GoodsRepository;
import com.practice.ecommerce.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository repository;

    @Transactional(readOnly = false)
    public Goods save(Goods goods){
        return repository.save(goods);
    }

    @Transactional(readOnly = true)
    public List<Goods> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Goods> findById(long id){
        return repository.findById(id);
    }
}
