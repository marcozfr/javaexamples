package com.example.web.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ejb.jms.JmsMessageProducer;

@WebServlet("/queueTest")
public class QueueTestServlet extends HttpServlet{
    
	private static final long serialVersionUID = 1L;
	
	@Inject
	JmsMessageProducer jmsMessageProducer;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		jmsMessageProducer.sendMessage(req.getParameter("message"),req.getParameter("origin"));
        
    }

}
