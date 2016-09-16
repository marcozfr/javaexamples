<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Core Tags</title>
</head>
<body>

	<div>
		<c:set var="servletName" value="/Download"  property="key1" scope="request" />
		<c:out value="${servletName}"></c:out>
	</div>
	
	<div>
		<c:url value="/DownloadServlet" >
			<c:param name="test" value="5" />
			<c:param name="rest" value="9" />
		</c:url>  <!-- encoding -->
	</div>
	<%-- lols--%>
	
	<c:import url="/include/footer.jsp" >
		<c:param name="message" value="Visit us at ${pageContext.request.requestURL}" />
	 </c:import>
	 
	 
	 <c:catch var="myException">
	 	${8 mod 0}
	 	<c:out value="Lololol"></c:out>
	 </c:catch>
	 
	 <c:out value="${myException}"></c:out>
</body>
</html>