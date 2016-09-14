<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL Expressions</title>
</head>
<body>
    <div>Version Context Init Param: ${initParam.version}</div>
    <div>Default Locale: ${applicationScope['DefaultLocale']}</div>
    <div>Person first name: ${employee["firstName"]}</div>
    <div>Person first badge: ${employee.badges[0]}</div>
    <div>Param values: ${paramValues}</div>
    <div>Param: ${param}</div>
    <div>Headers: ${headerValues}</div>
    <div>Host Header: ${header.host}</div>
    <div>Init Param Version: ${initParam['app-version']}</div>
    <div>Cookie: ${cookie}</div>
</body>
</html>