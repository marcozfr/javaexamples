package com.example.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieInfoServlet
 */
@WebServlet("/CookieInfoServlet")
public class CookieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie jsession = Arrays.asList(request.getCookies()).stream().filter(c -> c.getName().equals("JSESSIONID")).findAny().orElse(null);
		if(jsession!=null){
			response.getWriter().append("<div> Cookie Jsession attrs: <table> <tr>")
				.append("<td>comment </td><td>").append(jsession.getComment()).append("</td></tr>")
				.append("<td>domain </td><td>").append(jsession.getDomain()).append("</td></tr>")
				.append("<td>name </td><td>").append(jsession.getName()).append("</td></tr>")
				.append("<td>path </td><td>").append(jsession.getPath()).append("</td></tr>")
				.append("<td>value </td><td>").append(jsession.getValue()).append("</td></tr>")
				.append("<td>max age </td><td>").append(String.valueOf(jsession.getMaxAge())).append("</td></tr>")
				.append("<td>secure </td><td>").append(String.valueOf(jsession.getSecure())).append("</td></tr>")
				.append("<td>version </td><td>").append(String.valueOf(jsession.getVersion())).append("</td></tr> </div>");
			jsession.setMaxAge(0);
			response.addCookie(jsession);
			
		}
		
		
	}

}
