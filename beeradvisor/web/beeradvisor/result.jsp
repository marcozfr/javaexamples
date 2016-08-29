<%@ page import="java.util.*"%>
<html>
	<head>
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
	
	%>
	</body>
</html>