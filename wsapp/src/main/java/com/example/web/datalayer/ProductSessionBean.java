package com.example.web.datalayer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.web.model.Product;

@Stateless
public class ProductSessionBean {

    @PersistenceContext(unitName="catalogUnit")
    EntityManager entityManager;
    
    public void save(Product t){
        entityManager.persist(t);
    }
    
}
