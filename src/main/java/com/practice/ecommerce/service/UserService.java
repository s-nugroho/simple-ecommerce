package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.UserRepository;
import com.practice.ecommerce.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Iterable<User> findAllUser(){
        return userRepository.findAll();
    }

    public User findUserById(long id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id =:id", User.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
