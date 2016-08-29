package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BeerServlet extends HttpServlet {
	
	private int reqCount = 0 ;
	
	static {
		System.out.println("static init");
	}
	
	public BeerServlet(){
		System.out.println("servlet constructor");
	}
	
	public void init() throws ServletException {
		System.out.println("servlet init");
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
			
		String trace = request.getParameter("trace");	
		if(trace!= null && trace.equals("y")){
			System.out.println("cookies: " + Arrays.asList(request.getCookies()));
			System.out.println("user port: " + request.getRemotePort());
			System.out.println("local port: " + request.getLocalPort());
			System.out.println("server port: " + request.getServerPort());
			System.out.println("method: " + request.getMethod());
		}
		
		System.out.println("request count " + (++reqCount));		
		
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		//pw.print("<html><body>Bee selection advice <br>");
		String color = request.getParameter("color");
		//pw.print(color);
		//pw.println("</body></html>");
		List<String> styles = new ArrayList<String>();
		if(color.equals("light")){
			styles.add("Budweiser");
		}else {
			styles.add("Pilsen");
		}
		request.setAttribute("styles",styles);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request,response);
	}
}