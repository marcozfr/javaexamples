package com.example.web.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.example.ejb.session.CustomerBean;
import com.example.model.catalog.ContactInfo;
import com.example.model.catalog.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/customer")
@RequestScoped
public class CustomerResource {
	
	@EJB
	CustomerBean customerBean;

    @GET
    @Path("/{id:\\d+}")
    @Produces("application/json")
    public Response getCustomer(@PathParam("id") Long id) throws JsonProcessingException{
    	Customer customer = customerBean.findCustomer(id);
    	String customerString = new ObjectMapper().writeValueAsString(customer);
        return Response.ok(customerString).build();
    }
    
    @POST
    @Produces("application/json")
    public Response getCustomer(@FormParam("firstName") String firstName,
    		@FormParam("lastName") String lastName,
    		@FormParam("birthDate") String birthDate, 
    		@FormParam("mail") String mail,
    		@FormParam("phoneNumber") String phoneNumber) throws JsonProcessingException, ParseException{
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
    	customerBean.createCustomer(customer);
    	String customerString = new ObjectMapper().writeValueAsString(customer);
        return Response.ok(customerString).build();
    }
    
}
