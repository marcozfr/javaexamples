package com.example.ws.topdown;

import javax.jws.WebService;

@WebService(name = "TopDownService", targetNamespace = "http://topdown.ws.example.com/TopDownService/", endpointInterface="com.example.ws.topdown.TopDownService")
public class TopDownServiceImpl implements TopDownService {

	@Override
	public String downloadImage(String in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisterUserResponse registerUser(BasicInfo basicInfo) {
		RegisterUserResponse r = new RegisterUserResponse();
		r.setOut("Hi " + basicInfo.getFirstName() + " " + basicInfo.getLastName());
		return r;
	}

}
