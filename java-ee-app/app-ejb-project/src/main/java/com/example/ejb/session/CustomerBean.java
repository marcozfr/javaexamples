package com.example.ejb.session;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.model.catalog.Customer;

@Stateless
public class CustomerBean {

	@PersistenceContext(unitName="catalogJTAPU")
	private EntityManager entityManager;
	
	@Resource(name="customerTitle")
	private String defaultTitle;
	
	@PostConstruct
	public void initBean(){
	    defaultTitle = defaultTitle == null ? "" : defaultTitle + " ";
	}
	
	public Customer createCustomer(Customer customer){

	    customer.setFirstName(defaultTitle + customer.getFirstName());
	    
		entityManager.persist(customer);
		
		return customer;
	}
	
}