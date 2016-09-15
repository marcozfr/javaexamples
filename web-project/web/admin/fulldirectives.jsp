<jsp:directive.page import="java.util.*" isELIgnored="false" isErrorPage="false" />
<!DOCTYPE html>
<html>
<jsp:declaration>
   String pageTitle;
</jsp:declaration>
<jsp:scriptlet>pageTitle = "Directive Examples";</jsp:scriptlet>
<head>
    <title>
        <jsp:expression>pageTitle</jsp:expression>
    </title>
    <body>
        <h2><jsp:text>Directives Title</jsp:text></h2>        
    </body>
</head>
</html>