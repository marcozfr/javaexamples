package com.example.ejb.singleton;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class BmcCacheBean {

    private Map<String,Object> cache = new HashMap<>();
	
	public synchronized void add(String key, Object object){
		cache.put(key, object);
	}
	
	public synchronized Object remove(String key){
		return cache.remove(key);
	}
	
	public Object get(String key){
		return cache.getOrDefault(key, null);
	}
	
}
