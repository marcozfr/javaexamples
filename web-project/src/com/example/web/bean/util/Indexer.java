package com.example.web.bean.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Indexer {
	
	private static AtomicInteger index = new AtomicInteger(0);
	
	public static int getNextIndex(){
		return index.incrementAndGet();
	}
	

}
