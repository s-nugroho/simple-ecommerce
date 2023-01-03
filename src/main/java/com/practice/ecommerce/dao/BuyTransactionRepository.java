package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.BuyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyTransactionRepository extends JpaRepository<BuyTransaction ,Long> {
}
