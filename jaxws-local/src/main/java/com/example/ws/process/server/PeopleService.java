package com.example.ws.process.server;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

@WebService
@HandlerChain(file="handlers.xml")
public class PeopleService {
	
	@WebMethod
    public synchronized W3CEndpointReference login(Long peopleInstanceId) {
        PeopleInstanceService instanceService = new PeopleInstanceService(peopleInstanceId);
        return PeopleInstanceService.manager.export(instanceService);
    }

}
