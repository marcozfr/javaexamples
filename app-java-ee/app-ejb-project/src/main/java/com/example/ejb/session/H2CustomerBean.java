package com.example.ejb.session;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.model.catalog.Customer;

@RequestScoped
public class H2CustomerBean {
	
	public static Logger logger = LogManager.getLogger(H2CustomerBean.class);
	
	@PersistenceUnit(unitName="catalogH2PU")
	private EntityManagerFactory h2EntityManagerFactory;
	
	public Customer createCustomer(Customer customer){
		
		EntityManager h2EntityManager = h2EntityManagerFactory.createEntityManager();
		
		EntityTransaction tx = h2EntityManager.getTransaction();
		
		tx.begin();
		h2EntityManager.persist(customer);

		tx.commit();
		
		logger.info("Saved customer with id {} and version {}", customer.getCustomerId(),customer.getVersion());
		
		return customer;
	}

}
