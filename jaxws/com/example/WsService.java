package com.example;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Random;

@WebService
public class WsService {
	
	@WebMethod
	public int[] randoms(int amount){

		return new Random().ints(amount, 0, 10).toArray();

	}

}