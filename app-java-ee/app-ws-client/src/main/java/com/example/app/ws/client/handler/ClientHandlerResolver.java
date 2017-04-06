package com.example.app.ws.client.handler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class ClientHandlerResolver implements HandlerResolver {
	
	List<Handler> handlers;
	
	public ClientHandlerResolver(boolean timestampHeader, String authCode){
		handlers = new ArrayList<>();
		if(timestampHeader){
			handlers.add(new TimeStampHandler());
		}
		if(authCode!=null){
			handlers.add(new AuthHandler(authCode));
		}
	}
	
	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		return handlers;
	}
	
}
