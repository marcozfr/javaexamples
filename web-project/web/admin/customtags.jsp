<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="my"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Tags</title>
</head>
<body>
	<div>
		<c:out value="Result : " />
		<my:multiply value2="5" value1="4"></my:multiply>
	</div>
	<div>
		<c:out value="Result 2: " />
		<my:multiply>
			<jsp:attribute name="value1" >4</jsp:attribute>
			<jsp:attribute name="value2" >90</jsp:attribute>
		</my:multiply>
	</div>
	
</body>
</html>