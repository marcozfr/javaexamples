<%@ page contentType="text/html"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<title>Register Beer</title>
	</head>
	<body>
		<%-- <% request.setAttribute("beer",new com.example.model.Beer()); %> --%>
		<jsp:useBean id="beer" class="com.example.model.Beer" scope="request"/>
		<jsp:setProperty name="beer" property="name" value="default" />


		<form action="RegisterBeer" method="POST">
			<h1>Register Beer</h1>
			<label for="name">Beer:</label>
			<input type="text" name="name" value="${requestScope.beer.name}">
			<br><br>
			<label for="style">Style:</label>

			<input type="text" name="style" value="${requestScope.beer.style.name}">
			<br><br>
			<input type="submit" name="send" value="Submit">
			<br><br>
			<a href="${header['Referer']}" >Back</a>
		</form>
	</body>
</html>