package com.example.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginLogoutServlet
 */
@WebServlet("/LoginLogoutServlet")
public class LoginLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.login(request.getParameter("user"), request.getParameter("pwd"));
			
			response.getWriter().append("<div>Logged In successfully at: ")
			.append(request.getServletPath())
			.append(". Auth Type:" +request.getAuthType())
			.append("</div>");
			
			if(request.getParameter("logout")!=null){
				
				request.logout();
				
				response.getWriter().append("<div>Logged Out successfully at: ")
				.append(request.getServletPath())
				.append("</div>");
			}
			
		} catch (Exception e) {
			response.getWriter().append("Exception: ").append(e.getMessage());
		}
	}

}
