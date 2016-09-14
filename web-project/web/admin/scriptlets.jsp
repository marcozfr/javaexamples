<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="true" %>
<%@ page import="com.example.web.bean.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scriplets</title>
</head>
<body>
    <%@ include file="/WEB-INF/include/header.jsp"%>
    
    <%!Employee e = new Employee(45, "John", "Doe");
    
        public void jspInit(ServletConfig cfg) {
        System.out.println("Init Example.jsp");
        }
    %>
    
    <%
       pageContext.getRequest().setAttribute("testAttr", "$5000.0");
    %>
    
    <div>Employee first name: <%= e.getFirstName()%></div>
    <div>Session: <%=pageContext.getSession().getId() %></div>
    <div>App Init Param: <%=pageContext.getServletContext().getInitParameter("version") %></div>
    <div>Request param test value: <%=pageContext.getRequest().getParameter("test")%></div>
    <div>Get Attribute with *_SCOPE: <%=pageContext.getAttribute("testAttr",PageContext.REQUEST_SCOPE)%></div>
    <div>Finding attribute in scopes: <%=pageContext.findAttribute("testAttr")%></div>
    <div>Ignore EL : ${applicationScope.DefaultScope}</div>
</body>
</html>