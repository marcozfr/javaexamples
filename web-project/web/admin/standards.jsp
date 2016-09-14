<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Standard Actions</title>
</head>
<body>
    <% List<String> defaultBadges= Arrays.asList("test","cool","megapower"); 
       pageContext.setAttribute("defBadges", defaultBadges);
    %>
    <jsp:useBean id="emp" type="com.example.web.bean.Person" class="com.example.web.bean.Employee" scope="request" > 
        <!-- Scope of useBean defaults to page -->
        <jsp:setProperty property="id" name="emp" value="11"/>
        <jsp:setProperty property="firstName" name="emp" value="Jon"/>
        <jsp:setProperty property="lastName" name="emp" value="Don"/>
         
        <jsp:setProperty property="badges" name="emp" value="${defBadges}"/>
        <%-- Conditional properties when inside the body of useBean--%>
    </jsp:useBean>
    <c:if test="${emp.id eq 4}" var="status" >
        <jsp:setProperty property="firstName" name="emp" /> <!-- param="firstName"/> --> <!-- param is optional if parameter name matches -->
	    <jsp:setProperty property="lastName" name="emp" /><!-- param="lastName"/> -->
	     
	    <!-- uncomment to set all parameters: -->
	    <jsp:setProperty property="*" name="emp"/>
    </c:if>
        
    <div><c:out value="Is emp variable new?: ${status}"></c:out></div>
    <div><c:out value="Employee id: "/><jsp:getProperty name="emp" property="id" /></div>
    <div><c:out value="Employee first name: "/><jsp:getProperty name="emp" property="firstName" /></div>
    <div><c:out value="Employee last name: "/><jsp:getProperty name="emp" property="lastName" /></div>
    <div><c:out value="Employee badges: "/><jsp:getProperty name="emp" property="badges" /></div>
</body>
</html> 