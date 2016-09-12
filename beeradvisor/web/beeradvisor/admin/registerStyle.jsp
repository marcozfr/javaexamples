<%@ page contentType="text/html"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
		<title>Register Style</title>
	</head>
	<body>
		<jsp:include page="/header.jsp" />

		<jsp:useBean id="style" class="com.example.model.Style" scope="page"/>
		
		<h2>Register Style</h2>
		<form action="${pageContext.request.contextPath}/RegisterStyle" method="POST">
			<label for="name">Style:</label>
			<input type="text" name="name" value="${style.name}">
			<br><br>
			<input type="submit" name="send" value="Submit">
		</form>
		<jsp:include page="/footer.jsp" />
	</body>
</html>