<!doctype HTML>
<%@ page import="java.util.*" %>
<%@ page import="com.example.web.RequestUtil" %>
<%@ page import="com.example.model.BeerRepository,com.example.model.Style" %>
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ page isELIgnored="false"%>	
<%@ page isThreadSafe="true"%>

<% Cookie nameCookie = RequestUtil.getUserNameCookie(request); %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<title>Beer advisor</title>
	</head>
	<body>
		<h1>Beer selection</h1>

		<% if (nameCookie!=null){ %>
			<p>Welcome back, ${cookie["name"].value}</p>
		<% } %>
		
		<form action="SelectBeer" method="POST">
			<div>
			<% if (nameCookie == null) { %>
				<label for="userName">Enter name: </label> 
				<input type="text" name="userName" value="" />
				<br><br>
			<% }; 
			   
			   java.util.List<Style> styles = BeerRepository.getInstance().getStyles();
			   pageContext.setAttribute("styles",styles);
			%>
			<label for="color">Select style: </label> 
			<select name="color" size="1">
			<% for(Style style : styles) {
				out.println("<option>"+style.getName()+"</option>");
			 } %>
			</select>
			<br><br>
			<input type="checkbox" name="trace" value="y">Trace request</input>
			<br><br>
			<input type="submit" value="Submit" />
			<br><br>
			<div>
				<a href="register.jsp" >Register</a> 
				<a href="registerStyle.jsp" >Add Style</a> 
			</div>
			</div>
		</form>
		<footer>
			<br><br>
			<span>App version: ${initParam.version}</span>
		</footer>
	</body>
</html>