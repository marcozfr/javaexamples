package com.example.web.listener;

import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;

public class StylesAttributeListener implements ServletRequestAttributeListener{
	
	public void attributeAdded(ServletRequestAttributeEvent evt){
		System.out.println("adding styles attribute: " + evt.getName() + ":"+ evt.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent evt){
		System.out.println("removing styles attribute: " + evt.getName() + ":"+ evt.getValue());
	}

	public void attributeReplaced(ServletRequestAttributeEvent evt){

	}

}