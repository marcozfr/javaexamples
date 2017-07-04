package com.example.ws.services.users;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.ws.model.User;

@WebService(name="UsersServicePortType", serviceName="UsersService",portName= "UsersServicePort",
    endpointInterface="com.example.ws.services.users.UsersService")
public class UsersServiceImpl implements UsersService {

    @Override
    @WebMethod(operationName="getUsers")
    public List<User> getUserList() {
        User user1 = new User(1l, "cgdt" ,"clsd" ,"xmdx" );
        User user2 = new User(2l, "zsk" ,"zoosk" ,"lkask" );
        return Arrays.asList(user1,user2);
    }

}
