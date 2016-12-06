package com.example.ws.resource.provider;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.example.ws.annotation.MaxAge;
import com.example.ws.resource.filter.CacheControlFilter;

@Provider
public class MaxAgeFeature implements DynamicFeature {

	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		MaxAge max = resourceInfo.getResourceMethod().getAnnotation(MaxAge.class);
		if(max == null) return;
		CacheControlFilter cacheControlFilter = new CacheControlFilter(max.value());
		context.register(cacheControlFilter);
		
	}

}
