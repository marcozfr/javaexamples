<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Import Directive</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/include/header.jsp" >
        <jsp:param value="Directives Header" name="header"/>
    </jsp:include> <!-- runtime -->
    
    <%@ include file="/WEB-INF/include/header.jsp"%> <!-- translation time -->
    
</body>
</html>