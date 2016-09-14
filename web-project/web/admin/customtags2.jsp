<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mt" %>
<%@ taglib uri="MyTags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Tags 2nd round</title>
</head>
<body>
	<mt:headerTag description="Custom Tags Title"></mt:headerTag>
	<div>
		<my:multiply value1="99" value2="999" />
	</div>
	<mt:footerTag>
		Contact us at help@tags.com 
	</mt:footerTag>
</body>
</html>