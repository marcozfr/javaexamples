<%@ page import="java.util.*" %>
<html>
	<head>
		<style>
			div {
				display: block;
			}
		</style>
	</head>
	<body>
		<h1>Beer selection</h1>
		<form action="SelectBeer" method="POST">
			<div>
			<p>Select characteristics</p>
			<select name="color" size="1">
				<option>ale</option>
				<option>lager</option>
				<option>red</option>
				<option>black</option>
			</select>
			<input type="checkbox" name="trace" value="y">Trace request</input>
			<input type="submit" value="Send" />
			</div>
		</form>
	</body>
</html>