package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.AdminRepository;
import com.practice.ecommerce.entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private AdminRepository adminRepository;

    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public Iterable<Admin> findAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin findAdminById(long id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a WHERE a.idAdmin=:id", Admin.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
