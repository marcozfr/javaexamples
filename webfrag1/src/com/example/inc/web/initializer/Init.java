package com.example.inc.web.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.example.inc.web.servlet.PackagedServlet;

public class Init implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext arg1) throws ServletException {
		System.out.println("Initializing " + arg1.getContextPath());
		ServletRegistration.Dynamic sr = arg1.addServlet("PackServlet",PackagedServlet.class);
		sr.addMapping("/Pack");
	}

}
