package com.example.web.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@WebServlet(asyncSupported=true,urlPatterns="/nashorn")
public class NashornServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream is = getServletContext().getResourceAsStream("/nashorn/script.js");
		InputStreamReader ir = new InputStreamReader(is);
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval(ir);
			
			Invocable invocable = (Invocable) engine;

			Object result = invocable.invokeFunction("fun1", "Peter Parker");
			
			resp.getWriter().println(result);
			resp.getWriter().println(result.getClass());
			
		} catch (ScriptException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}
