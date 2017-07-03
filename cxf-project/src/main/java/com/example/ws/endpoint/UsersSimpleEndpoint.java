package com.example.ws.endpoint;

import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.example.ws.services.users.UsersService;
import com.example.ws.services.users.UsersServiceImpl;

public class UsersSimpleEndpoint {
    
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        ServerFactoryBean sfb = new ServerFactoryBean();
        sfb.setAddress("http://localhost:9091/UsersService");
        sfb.setBindingId(SOAPBinding.SOAP12HTTP_BINDING);
        sfb.setServiceBean(usersService);
        sfb.getInInterceptors().add(new LoggingInInterceptor());
        sfb.getOutInterceptors().add(new LoggingOutInterceptor());
        Server jaxWSserver = sfb.create();

    }

}
