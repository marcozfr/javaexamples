<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uh Oh..</title>
</head>
<body>
    <div><p>Bad things happens.. Reload the page to try again</p></div>
    <div><p><%=(String)request.getAttribute("javax.servlet.error.message")%></p></div>
</body>
</html>