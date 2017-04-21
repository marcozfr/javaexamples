package com.example.ejb.session;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.ejb.annotations.CatalogManager;
import com.example.ejb.enums.DatabaseType;
import com.example.model.catalog.Customer;

public class CustomerBean {

	@Inject @CatalogManager(DatabaseType.MYSQL)
	private EntityManager entityManager;
	
	@Resource(name="customerTitle")
	private String defaultTitle;
	
	@Resource
	private SessionContext sessionContext;
	
	@PostConstruct
	public void initBean(){
	    
	    defaultTitle = defaultTitle == null ? "" : defaultTitle + " ";
	}
	
	@WebMethod(exclude=true)
	public Customer createCustomer(Customer customer){
	    customer.setFirstName(defaultTitle + customer.getFirstName());
		entityManager.persist(customer);
		return customer;
	}
	
	@WebMethod
	public Customer findCustomer(Long id){
		return entityManager.find(Customer.class, id);
	}
	
	@WebMethod
	public List<Customer> findCustomers(){
		TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
		return query.getResultList();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	
}