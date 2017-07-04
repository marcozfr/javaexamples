package com.example.ws.endpoint;

import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.example.ws.services.users.UsersService;
import com.example.ws.services.users.UsersServiceImpl;

public class UsersJaxWsEndpoint {
    
    public static void main(String[] args) throws InterruptedException {
        UsersService usersService = new UsersServiceImpl();
        JaxWsServerFactoryBean jaxwsfb = new JaxWsServerFactoryBean();
        jaxwsfb.setAddress("http://localhost:9091/UsersService");
        jaxwsfb.setBindingId(SOAPBinding.SOAP12HTTP_BINDING);
        jaxwsfb.setServiceBean(usersService);
        jaxwsfb.getInInterceptors().add(new LoggingInInterceptor());
        jaxwsfb.getOutInterceptors().add(new LoggingOutInterceptor());
        Server jaxWSserver = jaxwsfb.create();

        Thread.sleep(10000 * 6);
        
        jaxWSserver.stop();
        
    }

}
