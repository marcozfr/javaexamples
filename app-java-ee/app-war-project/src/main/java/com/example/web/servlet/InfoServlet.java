package com.example.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/info",name="info",displayName="Information Servlet")
public class InfoServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pr = resp.getWriter();
        pr.println("Request URL: " + req.getRequestURL());
        pr.println("Path: " + req.getContextPath());
        pr.println("Port: " + req.getServerPort());
        pr.println("Method: " + req.getMethod());
        pr.println("Servlet: " + req.getServletPath());
        pr.println("Remote Addr: " + req.getRemoteAddr());
        pr.println("Remote Port: " + req.getRemotePort());
        
        resp.setContentType("text/plain");
        
        pr.flush();
        pr.close();
    }
    
}
