package com.example.web.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.ejb.enums.DatabaseType;
import com.example.ejb.session.CustomerBean;
import com.example.ejb.session.H2CustomerBean;
import com.example.model.catalog.ContactInfo;
import com.example.model.catalog.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/customer")
@RequestScoped
public class CustomerResource {
	
	public static Logger logger = LogManager.getLogger(CustomerResource.class);
	
	@EJB
	CustomerBean customerBean;
	
	@Inject
	H2CustomerBean h2CustomerBean;

    @GET
    @Path("/{id:\\d+}")
    @Produces("application/json")
    public Response getCustomer(@PathParam("id") Long id) throws JsonProcessingException{
    	Customer customer = customerBean.findCustomer(id);
        return Response.ok(customer).build();
    }
    
    @POST
    @Produces("application/json")
    public Response getCustomer(@FormParam("firstName") String firstName,
    		@FormParam("lastName") String lastName,
    		@FormParam("birthDate") String birthDate, 
    		@FormParam("mail") String mail,
    		@FormParam("phoneNumber") String phoneNumber,
    		@HeaderParam("dbType") String dbType) throws JsonProcessingException, ParseException{
    	Customer customer = new Customer();
    	customer.setFirstName(firstName);
    	customer.setLastName(lastName);
    	Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
		customer.setDateOfBirth(dateOfBirth);
		customer.setCreationDate(new Date());
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setEmail(mail);
		contactInfo.setPhoneNumber(phoneNumber);
		customer.setContactInfo(contactInfo);
		if(DatabaseType.H2.toString().equals(dbType)){
			h2CustomerBean.createCustomer(customer);
		}else{
			customerBean.createCustomer(customer);
		}
    	
        return Response.ok(customer).build();
    }
    
    @PreDestroy
    public void end(){
    	logger.info("ending request {}",this);
    }
    
}
