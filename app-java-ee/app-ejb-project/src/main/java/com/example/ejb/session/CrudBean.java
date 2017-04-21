package com.example.ejb.session;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.example.ejb.annotations.CatalogManager;
import com.example.ejb.enums.DatabaseType;
import com.example.ejb.session.extension.LoggingInterceptor;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class CrudBean {

    @Inject @CatalogManager(DatabaseType.MYSQL)
    private EntityManager entityManager;
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected <T> T save(T t){
        entityManager.persist(t);
        return t;
    }
    
    protected <T> T findById(Class<T> clazz, Object id){
        return entityManager.find(clazz, id);
    }
    
}
