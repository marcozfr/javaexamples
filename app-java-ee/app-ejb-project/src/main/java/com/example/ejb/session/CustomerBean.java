package com.example.ejb.session;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.example.ejb.annotations.CatalogManager;
import com.example.ejb.enums.DatabaseType;
import com.example.model.catalog.Customer;

@Stateless
public class CustomerBean {

	@Inject @CatalogManager(DatabaseType.MYSQL)
	private EntityManager entityManager;
	
	@Resource(name="customerTitle")
	private String defaultTitle;
	
	@Resource
	private SessionContext sessionContext;
	
	@PostConstruct
	public void initBean(){
	    sessionContext.getTimerService();
	    defaultTitle = defaultTitle == null ? "" : defaultTitle + " ";
	}
	
	public Customer createCustomer(Customer customer){
	    customer.setFirstName(defaultTitle + customer.getFirstName());
		entityManager.persist(customer);
		return customer;
	}
	
	public Customer findCustomer(Long id){
		return entityManager.find(Customer.class, id);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    // TODO Auto-generated method stub
	    return super.clone();
	}
	
}