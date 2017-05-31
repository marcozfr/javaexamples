package com.example.ws.topdown;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.BindingType;
import javax.xml.ws.http.HTTPBinding;

@WebService(portName="TopDownServicePort", 
	serviceName="TopDownService", name="TopDownServicePortType", 
	targetNamespace="http://topdown.ws.example.com/TopDownService/")
@SOAPBinding(parameterStyle=ParameterStyle.BARE,style=Style.DOCUMENT,use=Use.LITERAL)
@BindingType(HTTPBinding.HTTP_BINDING)
public interface TopDownService {
	
	public String downloadImage();
	
	public String registerUser();

}
