javac -cp C:\opt\apache-tomcat-8.0.33\lib\servlet-api.jar -d web\beeradvisor\WEB-INF\classes src\com\example\web\BeerServlet.java
mkdir C:\opt\apache-tomcat-8.0.33\webapps\beeradvisor
xcopy web\beeradvisor C:\opt\apache-tomcat-8.0.33\webapps\beeradvisor /s /e /y