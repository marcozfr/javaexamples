package com.example.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.web.bean.Employee;

/**
 * Servlet implementation class StandardsFwdServlet
 */
@WebServlet("/StandardsFwdServlet")
public class StandardsFwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StandardsFwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String create = request.getParameter("create");
		if(create !=null && !create.isEmpty()){
			request.setAttribute("emp", new Employee(4,"def","def"));
		}
		
		request.getRequestDispatcher("/admin/standards.jsp").forward(request, response);
	}


}
