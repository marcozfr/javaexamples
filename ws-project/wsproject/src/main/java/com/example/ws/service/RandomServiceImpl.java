package com.example.ws.service;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService //(endpointInterface="com.example.ws.service.RandomService")
public class RandomServiceImpl implements RandomService {

	private static final int maxRands = 16;

	@WebMethod
	public int next() {
		return new Random().nextInt();
	}

	@WebMethod 
	public int[] nextN(final int n) {
		final int k = (n > maxRands) ? maxRands : Math.abs(n);
		int[] rands = new int[k];
		Random r = new Random();
		for (int i = 0; i < k; i++)
			rands[i] = r.nextInt();
		return rands;
	}

}
