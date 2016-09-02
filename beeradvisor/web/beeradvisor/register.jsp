<%@ page contentType="text/html"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<title>Register Beer</title>
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<%-- <% request.setAttribute("beer",new com.example.model.Beer()); %> --%>
		<jsp:useBean id="beer" class="com.example.model.Beer" scope="request"/>
		<jsp:setProperty name="beer" property="name" value="default" />

		<h2>Register Beer</h2>

		<form action="RegisterBeer" method="POST">
			<label for="name">Beer:</label>
			<input type="text" name="name" value="${requestScope.beer.name}">
			<br><br>
			<label for="style">Style:</label>

			<input type="text" name="style" value="${requestScope.beer.style.name}">
			<br><br>
			<input type="submit" name="send" value="Submit">
			<br><br>
		</form>
		<jsp:include page="footer.jsp" />
	</body>
</html>