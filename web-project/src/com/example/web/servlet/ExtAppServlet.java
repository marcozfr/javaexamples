package com.example.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.web.bean.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/extServlet")
public class ExtAppServlet extends HttpServlet {
	
	private List<User> userStore;
	
	@PostConstruct
	public void init(){
		userStore = new ArrayList<>();
		userStore.add(new User("John", "Doe", 32,"Active"));
		userStore.add(new User("Joe", "Cole", 23,"Inactive"));
		userStore.add(new User("Tom", "Res", 23,"Active"));
		userStore.add(new User("Jack", "Bauer", 23,"Active"));
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("b");
		
		if(action.equals("user")){
			buildUser(req,resp);
		}else if (action.equals("get")){
			getUsers(req,resp);
		}else if (action.equals("add")){
			addUser(req,resp);
		}
		
	}

	private void addUser(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		String user = req.getParameter("userJson");
		ObjectMapper om = new ObjectMapper();
		User u = om.readValue(user, User.class);
		userStore.add(u);
		om.writeValue(resp.getOutputStream(), userStore);
	}

	private void getUsers(HttpServletRequest req, HttpServletResponse resp) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		resp.setContentType("application/json");
		om.writeValue(resp.getOutputStream(), userStore);
	}

	private void buildUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		User user = new User();
		user.setFirstName(req.getParameter("firstName"));
		user.setLastName(req.getParameter("lastName"));
		String ageStr = req.getParameter("age");
		if(ageStr!=null){
			user.setAge(Integer.valueOf(ageStr));
		}
		
		resp.setContentType(req.getHeader("Accept"));
		try {
			
			ObjectMapper om = new ObjectMapper();
			String a = om.writeValueAsString(user);
			
			resp.getWriter().write(a);
			
		} catch (IOException e) {
			resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
		}
	}
	

}
