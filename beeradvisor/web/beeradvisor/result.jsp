<%@ page import="java.util.List,java.util.ArrayList"%> <!--directives : page, taglib and include-->
<%@ page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="rf" tagdir="/WEB-INF/tags" %>
<%! AtomicInteger rTimes = new AtomicInteger(); %> <!--declaration-->
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>
	<%@ include file="header.jsp"%>
	
	<body>
		<h2>Recommendations</h2>
		<c:if test="${requestScope['styles'].size() le 0}">
			<br><c:out value="No recommendations available" />
		</c:if>
		<c:forEach var="style" items="${styles}">
			<br><c:out value="Try ${style}" />
		</c:forEach>
		
		<%-- 
		List<String> styles = (List<String>) request.getAttribute("styles");
		if(styles==null || styles.isEmpty()){
			out.println("<br> no recommendations for this :( ");
		}else{
			for(String style : styles){
				out.println("<br> try " + style);
			}
		}
		--%>  
		<% pageContext.setAttribute("tm",rTimes.incrementAndGet());%>
		<%--scriptlet has been deleted--%>
		<rf:rfooter times="${tm}">
			Number of recommendations
		</rf:rfooter>
	</body>
		
	<jsp:include page="footer.jsp" />

</html>