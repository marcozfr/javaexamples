package com.example.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserFilter implements Filter {
	
	public void init(FilterConfig fcg) throws ServletException{
		System.out.println("Init UserFilter: "+fcg.getInitParameter("tag"));
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("user requesting: "+req.getRemoteUser());

		chain.doFilter(request,response);
	}

	public void destroy(){
		System.out.println("Destroy UserFilter ");
	}

}