<%@ page import="java.util.List,java.util.ArrayList"%> <!--directives : page, taglib and include-->
<%@ page import="java.util.concurrent.atomic.AtomicInteger"%>
<%! AtomicInteger rTimes = new AtomicInteger(); %> <!--declaration-->
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<h1>Recommendations</h1>
	</head>
	<body>
	<% 
	List<String> styles = (List<String>) request.getAttribute("styles");
	if(styles==null || styles.isEmpty()){
		out.println("<br> no recommendations for this :( ");
	}else{
		for(String style : styles){
			out.println("<br> try " + style);
		}
	}
	
	%>  <%--scriptlet--%>
	</body>
	<footer>
		<%="<br><br>Number of recommendations : "+rTimes.incrementAndGet()%>  <!--expression-->
		<br><br>
		<a href="${header['Referer']}" >Back</a>
	</footer>
</html>