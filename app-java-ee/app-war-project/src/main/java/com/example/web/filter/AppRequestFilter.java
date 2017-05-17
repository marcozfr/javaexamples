package com.example.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns="/*")
public class AppRequestFilter implements Filter {
	
	public static Logger logger = LogManager.getLogger(AppRequestFilter.class);

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		
		logger.info("# Request received # ");
		logger.info("{} {} {}" ,request.getMethod(), request.getRequestURL() , request.getRemoteAddr());
		Enumeration enm = request.getHeaderNames();
		while(enm.hasMoreElements()){
			String headerName = (String)enm.nextElement();
			logger.info("{}:{}", headerName, request.getHeader(headerName));
		}
		
		logger.info("Query String: {}", request.getQueryString());
		
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
