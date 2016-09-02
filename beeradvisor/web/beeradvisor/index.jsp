<!doctype HTML>
<%@ page import="java.util.*" %>
<%@ page import="com.example.web.RequestUtil" %>
<%@ page import="com.example.model.BeerRepository,com.example.model.Style" %>
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ page isELIgnored="false"%>	
<%@ page isThreadSafe="true"%>
<%@ taglib uri="RequestUtils" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/beer/advise" prefix="beer"%>

<%-- Cookie nameCookie = RequestUtil.getUserNameCookie(request); --%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<title>Beer advisor</title>
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<h2>Beer selection</h2>

		<c:if test="${cookie.name.value ne null}">
			<p><c:out value="Welcome back, ${cookie.name.value}" default="guest" escapeXml="false" /></p>
		</c:if>
		
		<form action="SelectBeer" method="POST">
			<div>
			<c:if test="${cookie.name eq null}">
				<label for="userName">Enter name: </label> 
				<input type="text" name="userName" value="" />
				<br><br>
			</c:if>
			<c:set var="styles" scope="page" value="${BeerRepository.getInstance().getStyles()}" />
			<%--
			   java.util.List<Style> styles = BeerRepository.getInstance().getStyles();
			   pageContext.setAttribute("styles",styles);
			--%>
			<label for="color">Select style: </label> 
			<select name="color" size="1">
				<c:forEach var="style" items="${styles}" varStatus="loopCount" >
					<option><c:out value="${style.name}"/></option>
				</c:forEach>
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
			<br><br><br><br>
			<span><beer:random user="${cookie.name.value}" /></span>
			</div>
		</form>

	</body>
</html>