package com.example.ws.http.client;

import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import com.example.ws.domain.util.WsUtils;

public class DispatchClientResfulSource {

	public static void main(String[] args) throws TransformerException {
		
		QName serviceName = new QName("http://resource.ws.example.com","CacheResource");
		QName portFormName = new QName("http://resource.ws.example.com","ParamsResourcePort");
		String endpoint2 = "http://localhost:8180/ws-jaxrs-impl/resources/features/media-type/save-book";
		
		Service service = Service.create(serviceName);
		
		service.addPort(portFormName, HTTPBinding.HTTP_BINDING, endpoint2);
		
		Dispatch<Source> dispatch2 = service.createDispatch(portFormName, Source.class, Service.Mode.PAYLOAD);
		
//		Map<String,List<String>> headers = new HashMap<>();
//		headers.put("content-type", Arrays.asList("application/books+xml"));
//		dispatch2.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		dispatch2.getRequestContext().put(MessageContext.HTTP_REQUEST_METHOD, "POST");
		
		Source response2 = dispatch2.invoke(new StreamSource(new StringReader("<book><id>100</id><isbn>ISBN102</isbn></book>")));
		
		System.out.println(WsUtils.fromSource(response2));
		
	}
	
}
