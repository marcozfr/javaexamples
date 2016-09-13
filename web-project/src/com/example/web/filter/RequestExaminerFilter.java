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
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class RequestExaminerFilter
 */
@WebFilter(filterName="ReqEx",urlPatterns="/*",initParams={
	@WebInitParam(name="aaa", value="123")
})
public class RequestExaminerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestExaminerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		// pass the request along the filter chain
		//
		System.out.println("Filtering request " + req.getMethod() + " ## "+req.getRequestURI());
		
		//response.getWriter().write("Ending on filter");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init Filter " + fConfig.getFilterName());
		Enumeration<String> paramNames = fConfig.getInitParameterNames();
		while(paramNames.hasMoreElements()){
			String name = paramNames.nextElement();
			System.out.println(name + ":#:" +fConfig.getInitParameter(name));
		}
	}

}
