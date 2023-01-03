package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
