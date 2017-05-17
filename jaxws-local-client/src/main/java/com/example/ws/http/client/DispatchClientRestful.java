package com.example.ws.http.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import com.example.ws.domain.util.WsUtils;

public class DispatchClientRestful {
	
	public static void main(String[] args) throws TransformerException {
		
		QName serviceName = new QName("http://resource.ws.example.com","CacheResource");
		QName portCacheName = new QName("http://resource.ws.example.com","CacheResourcePort");
		String endpoint1 = "http://localhost:8180/ws-jaxrs-impl/resources/features/cache/cache-control";
		
		Service service = Service.create(serviceName);
		
		service.addPort(portCacheName, HTTPBinding.HTTP_BINDING, endpoint1);
		
		Dispatch<Source> dispatch1 = service.createDispatch(portCacheName, Source.class, Service.Mode.PAYLOAD);
		
		dispatch1.getRequestContext().put(MessageContext.HTTP_REQUEST_METHOD, "GET");
		
		Source response = dispatch1.invoke(null);
		
		System.out.println(WsUtils.fromSource(response));
		
	}

}
