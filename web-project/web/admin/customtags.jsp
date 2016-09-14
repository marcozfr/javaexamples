<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div><c:out value="${param['input']}" escapeXml="true" /></div>
    
    <jsp:useBean id="emp" type="com.example.web.bean.Employee" scope="request" /> 
    
    <c:forEach items="${emp.badges}" var="badge" varStatus="loop">                      <!-- FOR EACH -->
        <c:choose>                                                                      <!-- CHOOSE WHEN OTHERWISE -->    
            <c:when test="${badge eq 'soccer'}">
                <div><b><c:out value="Badge ${loop.count}:${badge}"></c:out></b></div>
            </c:when>
            <c:otherwise>
                 <div><c:out value="Badge ${loop.count}:${badge}"></c:out></div>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    
     <c:set var="pageEmployee" scope="page" value="${emp}" />
        
     <div><%="Employee 1 stage 1: " +pageContext.getAttribute("pageEmployee") %></div>
     
     <c:set var="pageEmployee" scope="page" value="${null}" />
     
     <div><%="Employee 1 stage 2: " +pageContext.getAttribute("pageEmployee") %></div>  <!-- SET normal -->
     
     <c:set var="description" >                                                         <!-- SET with body -->
        Listening to othe leader landscape is important.
     </c:set>
     
     <div><c:out value="Description: ${pageScope['description']}"></c:out></div>
     
     <jsp:useBean id="emp2" class="com.example.web.bean.Employee" />
     
     <c:set target="${emp2}" property="firstName" value="Marco" />                      <!-- SET with target -->
     <c:set target="${emp2}" property="lastName" value="Flores" />
     
     <div><c:out value="Employee 2 stage 1: ${emp2}"></c:out></div>
     
     <c:remove var="emp2" />                                                            <!-- REMOVE -->
     
      <div><c:out value="Employee 2 stage 2 : ${empty emp2 ? 'no emp2 exists' : emp2}"></c:out></div>
	  
	  
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