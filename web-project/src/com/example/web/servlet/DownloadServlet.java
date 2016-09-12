package com.example.web.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Retreiving PDf");
		
		InputStream is = getServletContext().getResourceAsStream("/pdfs/info.pdf");
		
		resp.setContentType("application/pdf");

		byte[] buffer = new byte[1024]; // Adjust if you want
	    int bytesRead;
	    while ((bytesRead = is.read(buffer)) != -1)
	    {
	        resp.getOutputStream().write(buffer, 0, bytesRead);
	    }
	    
	    resp.getOutputStream().flush();
	    resp.getOutputStream().close();

	}
	
}
