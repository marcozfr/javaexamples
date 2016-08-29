package com.example.web;

import java.util.Enumeration;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;

public class InitParamsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {

		System.out.println("Parameter names :");
		Enumeration<String> names = getServletConfig().getInitParameterNames();
		while(names.hasMoreElements()){
			String initParamName = names.nextElement();
			System.out.println(initParamName+" : "+getServletConfig().getInitParameter(initParamName));
		}

	}


}