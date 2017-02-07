package com.example.ejb.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DependsOn("CustomerBean")
@Lock(LockType.READ)
public class CacheBean {
	
	private Map<String,Object> cache = new HashMap<>();
	
	public void add(String key, Object object){
		cache.put(key, object);
	}
	
	public Object remove(String key){
		return cache.remove(key);
	}
	
	@AccessTimeout(value=20,unit=TimeUnit.SECONDS)
	@Lock(LockType.WRITE)
	public Object get(String key){
		return cache.getOrDefault(key, null);
	}

}
