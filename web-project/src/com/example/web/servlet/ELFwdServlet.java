package com.example.web.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.web.bean.Employee;

/**
 * Servlet implementation class ELFwdServlet
 */
@WebServlet("/ELFwdServlet")
public class ELFwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELFwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Employee bob = new Employee(77, "Bob", "Rock");
		bob.setBadges(Arrays.asList("superglotons","busted"));
		request.setAttribute("employee", bob);
		
		request.getRequestDispatcher("/admin/elExpressions.jsp?showEmployee=true").forward(request, response);
	}


}
