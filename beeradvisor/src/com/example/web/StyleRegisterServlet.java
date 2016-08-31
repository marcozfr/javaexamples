package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import com.example.model.*;

public class StyleRegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		String styleName = request.getParameter("name");	

		if(styleName==null){
			response.getWriter().println("not enough parameters");
			return;
		}

		try{
			BeerRepository.getInstance().addStyle(styleName);	
		}catch(RuntimeException e){
			e.printStackTrace();
			response.getWriter().println("exception thrown :" + e.getMessage());
			return;
		}
		response.sendRedirect("index.jsp");
	}
	
}