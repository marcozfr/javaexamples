package com.example.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
}
