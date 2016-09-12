<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.DispatcherType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Default admin</title>
</head>
<body>
    <div>
        <p>Default Admin</p>
        <c:if test="${pageContext.request.dispatcherType eq DispatcherType.FORWARD}" >
            <c:out value="Comes from forward: ${requestScope['javax.servlet.forward.request_uri']}"></c:out>
        </c:if>
    </div>
</body>
</html>