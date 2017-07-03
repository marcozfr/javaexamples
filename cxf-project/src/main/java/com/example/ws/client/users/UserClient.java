package com.example.ws.client.users;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.example.ws.model.User;
import com.example.ws.services.users.UsersService;

public class UserClient {
    
    public static void main(String[] args) {
        JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
        cpfb.getInInterceptors().add(new LoggingInInterceptor());
        cpfb.getOutInterceptors().add(new LoggingOutInterceptor());
        cpfb.setAddress("http://localhost:8180/cxf-project/services/UserService");
        UsersService us = cpfb.create(UsersService.class);
        List<User> users = us.getUserList();
        users.forEach(System.out::println);
    }

}
