<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forwarded Page</title>
</head>
<body>
	<p>Forwarded page detail</p>
	<div>
		<span>Welcome ${requestScope['name']} </span>
	</div>
	<div>
		<span>Params: ${pageContext.request.queryString}</span>
	</div>
	<div>
		<span>Param Test: ${pageContext.request.parameterMap['test'][0]}</span>
	</div>
</body>
</html>