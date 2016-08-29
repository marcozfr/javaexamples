package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import com.example.model.*;

public class BeerRegisterServlet extends HttpServlet {
	
	static {
		System.out.println("static init");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		String styleName = request.getParameter("style");	
		String beerName= request.getParameter("name");

		if(beerName==null || styleName==null){
			response.getWriter().println("not enough parameters");
			return;
		}

		try{
			BeerRepository.getInstance().addBeer(styleName,beerName);	
		}catch(RuntimeException e){
			e.printStackTrace();
			response.getWriter().println("exception thrown :" + e.getMessage());
			return;
		}
		response.sendRedirect("index.jsp");
	}
	
}