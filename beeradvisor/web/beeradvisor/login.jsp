<!doctype html>
<%@ page session="false" %>
<html>
	<title>
		Login failed
	</title>
	<body>
		<form method="POST" action="j_security_check">
			<label for="j_username">User: </label>
			<input type="text" name="j_username" />
			<br><br>
			<label for="j_password">Password: </label>
			<input type="password" name="j_password" />
			<br><br>
			<input type="submit" name="submit" value="Login">
		</form>
	</body>
</html>