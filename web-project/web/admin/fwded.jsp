<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forwarded Page</title>
</head>
<body>
    <p>Forwarded page detail</p>
    <div>
        <span><c:out value="Welcome ${requestScope['name']}" /></span>
    </div>
    <div>
        <span><c:out value="Params: ${pageContext.request.queryString}" />  </span>
    </div>
    <div>
        <span> <c:out value="Test: ${pageContext.request.parameterMap['test'][0]}" /> </span>
    </div>
</body>
</html>