package com.example.web.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExampleServlet
 */
@WebServlet(name="ExampleServlet",urlPatterns="/example/*",
	description="Description of Example Servlet",
	displayName="Example Sservlet",
	initParams={
		@WebInitParam(name="version",value="1.0")
})
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {
		System.out.println("info:"+getServletInfo());
		System.out.println("version:"+getServletConfig().getInitParameter("version"));
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addIntHeader("status", 500);
		
		response.getWriter().append("Served at: ").append(request.getRequestURI());
		
//		response.sendError(HttpServletResponse.SC_BAD_REQUEST);

		response.setLocale(new Locale("es"));
		
//		throw new ServletException("generated exception");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
