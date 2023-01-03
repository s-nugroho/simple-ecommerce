package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.DetailedBuyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailedBuyTransactionRepository extends JpaRepository<DetailedBuyTransaction, Long> {
}
