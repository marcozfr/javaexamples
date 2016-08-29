package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import com.example.model.*;

public class BeerServlet extends HttpServlet {
	
	static {
		System.out.println("static init");
	}
	
	public void init() throws ServletException {
//		System.out.println("App version: " + getServletContext().getInitParameter("version"));
		System.out.println("App version: " + getServletContext().getAttribute("app-version"));
//		beerRepository = BeerRepository.getInstance();
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

		String trace = request.getParameter("trace");	
		if(trace!= null && trace.equals("y")){
			RequestUtil.printRequestInfo(request);
		}
		
		String color = request.getParameter("color");
		List<String> styles = BeerRepository.getInstance().getBeers(color);
		
		request.setAttribute("styles",styles);

		HttpSession session = request.getSession();		
		String key = "track-"+session.getId();
		List savedSearch = (List)session.getAttribute(key);
		if(savedSearch == null){
			savedSearch = new ArrayList();
		}
		savedSearch.add(styles);
		session.setAttribute(key,savedSearch);

		System.out.println("saved search for "+session.getId()+" : "+ savedSearch);
		
		RequestDispatcher rd = request.getRequestDispatcher(response.encodeURL("/result.jsp"));
		rd.forward(request,response);
	}

}