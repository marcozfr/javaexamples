package com.example.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.web.bean.Employee;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/CreateSessionServlet")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<div>Served at: ").append(request.getServletPath()).append("<div>");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("empName")==null){
			session.setAttribute("empName", new Employee(43, "Marco", "Flores"));
		}
		
		session.setMaxInactiveInterval(60*2);
		
		response.getWriter().append("<div>Creation time:").append((new Date(session.getCreationTime())).toString()).append("<div>");
		
		response.getWriter().append("<div>").append(request.getSession().isNew()? "Session is new" : "").append("<div>");
	}

}
