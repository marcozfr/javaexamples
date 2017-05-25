package com.example.ws.process.server;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.BindingType;
import javax.xml.ws.FaultAction;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.AddressingFeature.Responses;
import javax.xml.ws.soap.SOAPBinding;

import com.example.ws.domain.PersonList;
import com.example.ws.domain.PersonType;
import com.sun.xml.ws.developer.Stateful;
import com.sun.xml.ws.developer.StatefulWebServiceManager;

@WebService(targetNamespace="http://process.ws.example.com")
@Addressing(responses=Responses.NON_ANONYMOUS,enabled=true,required=true) 
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
@Stateful
@HandlerChain(file="handlers.xml")
public class PeopleInstanceService {
	
	private final Long id;
	private PersonList personList;
	
	public PeopleInstanceService(Long id) {
		this.id = id;
	}
	
	public static StatefulWebServiceManager<PeopleInstanceService> manager;
	
	@WebMethod
	@Action(input="http://process.ws.example.com/Input",
			output="http://process.ws.example.com/Output",
			fault={@FaultAction(value="ProcessException",className=ProcessException.class)})
	public boolean addPerson(PersonType person) throws ProcessException {
		return personList.getPerson().add(person);
	}
	
	@WebMethod
	@Action(input="http://process.ws.example.com/InputReply",
			output="http://process.ws.example.com/OutputReply",
			fault={@FaultAction(value="ProcessException",className=ProcessException.class)})
	public PersonList getPeople() throws ProcessException {
		return personList;
	}
	
	public static void setManager(StatefulWebServiceManager<PeopleInstanceService> manager) {
		PeopleInstanceService.manager = manager;
	}
	
}
