package com.example.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface RandomService {
	
	@WebMethod
	public int next();
	
	@WebMethod 
	public int[] nextN(final int n);

}
