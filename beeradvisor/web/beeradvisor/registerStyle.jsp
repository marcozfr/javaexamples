<%@ page contentType="text/html"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<title>Register Style</title>
	</head>
	<body>
	
		<jsp:useBean id="style" class="com.example.model.Style" scope="page"/>
		
		<form action="RegisterStyle" method="POST">
			<h1>Register Style</h1>
			<label for="name">Style:</label>
			<input type="text" name="name" value="${style.name}">
			<br><br>
			<input type="submit" name="send" value="Submit">
			<br><br>
			<a href="${header['Referer']}" >Back</a>
		</form>
	</body>
</html>