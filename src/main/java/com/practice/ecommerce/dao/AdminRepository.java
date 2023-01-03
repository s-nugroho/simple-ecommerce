package com.practice.ecommerce.dao;

import com.practice.ecommerce.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
