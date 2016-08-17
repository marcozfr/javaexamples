<%@ page import="java.util.*"%>
<html>
	<head>
		<h1>Recommendations</h1>
	</head>
	<body>
	<%
	List<String> styles = (List<String>) request.getAttribute("styles");
	for(String style : styles){
		out.println("<br> try " + style);
	}
	%>
	</body>
</html>