<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session</title>
</head>
<body>
    <jsp:include page="/WEB-INF/include/header.jsp">
        <jsp:param value="Session Created" name="header"/>
    </jsp:include>
    
    <div><c:out value="Session Id: ${pageContext.session.id}"></c:out></div>
    
    <div><c:out value="Creation Time: ${requestScope.sessioncreationTime}"></c:out></div>
    
   <c:if test="${session.isNew}">
            <c:out value="Session is new"></c:out>
   </c:if>
</body>
</html>