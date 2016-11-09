package com.example.web.servlet;

import java.io.IOException;
<<<<<<< HEAD
=======

>>>>>>> d621bd165561d338549813825690b1c8bb6c0e9e
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
<<<<<<< HEAD
=======
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
>>>>>>> d621bd165561d338549813825690b1c8bb6c0e9e
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
/**
 * Servlet implementation class SecuredServlet
 */
@WebServlet("/SecuredServlet")
@ServletSecurity(
		value=@HttpConstraint(rolesAllowed="tomcat"),
		httpMethodConstraints=@HttpMethodConstraint(value="POST"))
public class SecuredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecuredServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

=======
@WebServlet(value="/SecuredServlet",name="Secured Servlet")
/*
@ServletSecurity(
        @HttpConstraint(rolesAllowed="tomcat")
)*/

@ServletSecurity(
        httpMethodConstraints={
                @HttpMethodConstraint(value="OPTIONS"),
                @HttpMethodConstraint(value="POST",rolesAllowed="tomcat"),
                @HttpMethodConstraint(value="GET",rolesAllowed={"tomcat","role1"},emptyRoleSemantic=EmptyRoleSemantic.DENY)
        }
)
public class SecuredServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    
>>>>>>> d621bd165561d338549813825690b1c8bb6c0e9e
}
