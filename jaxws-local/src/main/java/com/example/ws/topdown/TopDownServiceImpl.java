package com.example.ws.topdown;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

@WebService(name = "TopDownService", targetNamespace = "http://topdown.ws.example.com/TopDownService/", endpointInterface="com.example.ws.topdown.TopDownService")
public class TopDownServiceImpl implements TopDownService {
	
	@Resource
	WebServiceContext webServiceContext;

	@Override
	public String downloadImage(String in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisterUserResponse registerUser(BasicInfo basicInfo) {
		RegisterUserResponse r = new RegisterUserResponse();
		r.setOut("Hi " + basicInfo.getFirstName() + " " + basicInfo.getLastName());
		
		ServletContext servletContext = (ServletContext) webServiceContext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		String storageFolder = servletContext.getInitParameter("fileStorage");
		
		try {
			String cType = basicInfo.getImage().getContentType();
			String cats[] = cType.split("name=");
			String title = null;
			if(cats.length < 2){
				title = "unknown " + basicInfo.getImage().toString() + ".png";
			}else{
				title = cats[1];
			}
			InputStream initialStream = basicInfo.getImage().getInputStream();
			byte[] buffer = new byte[initialStream.available()];
			initialStream.read(buffer);
			
			File file = new File(storageFolder + title);
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(buffer);
			outputStream.close();
			
		} catch (IOException e) {
			throw new WebServiceException(e);
		}
		
		return r;
	}

}
