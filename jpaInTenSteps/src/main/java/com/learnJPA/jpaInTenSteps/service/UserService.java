package com.learnJPA.jpaInTenSteps.service;

import com.learnJPA.jpaInTenSteps.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;


    public long insertUser(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
