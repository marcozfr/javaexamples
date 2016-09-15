<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mt" %>
<%@ taglib uri="MyTags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Tags 2nd round</title>
</head>
<body>
	<mt:headerTag description="Custom Tags Title"></mt:headerTag>
	<div>
		<my:multiply value1="99" value2="3" />
	</div>
	
	<div>
	   <mt:dynamicAttrsTag att1="test" att2="test3">
	       <jsp:body>${pageContext.servletContext.contextPath}</jsp:body>
	   </mt:dynamicAttrsTag>
	</div>
	
	<div>
	   <my:sum value1="55" v2="1" v3="1" />
	</div>
	
	<my:list title="List of request local items">
       <my:listItem value="${pageContext.request.localAddr}"/>
       <my:listItem value="${pageContext.request.localName}"/>
       <my:listItem value="${pageContext.request.localPort}"/>
    </my:list>
    
    <my:list title="List of request remote items">
       <my:listItem value="${pageContext.request.remoteAddr}"/>
       <my:listItem value="${pageContext.request.remoteHost}"/>
       <my:listItem value="${pageContext.request.remotePort}"/>
    </my:list>
    
    <my:list title="List of request server items">
        <my:listItem value="${pageContext.request.serverName}"/>
        <my:listItem value="${pageContext.request.serverPort}"/>
    </my:list>
    
    <my:body>
        This is a body tag that is using BodyTagSupport. Neat. Enclosing into a div
    </my:body>
	
	<mt:footerTag>
		Contact us at help@tags.com 
	</mt:footerTag>
</body>
</html>