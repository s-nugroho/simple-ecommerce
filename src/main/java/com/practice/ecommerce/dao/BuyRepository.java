package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyRepository extends JpaRepository<Buy,Long> {
}
