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
 * Servlet implementation class CustomTagsServlet
 */
@WebServlet("/CustomTagsServlet")
public class CustomTagsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomTagsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Employee p = new Employee(1, "Jon", "Doe");
		p.setBadges(Arrays.asList("tuner","uberuser","gymguy","soccer"));
		
		request.setAttribute("emp", p);
		
		request.getRequestDispatcher("/admin/customtags.jsp").forward(request, response);
	}

}
