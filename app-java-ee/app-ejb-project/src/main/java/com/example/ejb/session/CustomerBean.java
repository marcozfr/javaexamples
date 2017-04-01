package com.example.ejb.session;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

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
	
	@Resource
	private UserTransaction userTransaction;
	
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
	
	public List<Customer> findCustomers(){
		TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
		return query.getResultList();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    // TODO Auto-generated method stub
	    return super.clone();
	}
	
}