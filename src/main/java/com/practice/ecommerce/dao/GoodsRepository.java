package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
