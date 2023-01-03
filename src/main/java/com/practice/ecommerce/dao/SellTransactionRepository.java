package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.SellTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellTransactionRepository extends JpaRepository<SellTransaction, Long> {
}
