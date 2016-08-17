javac -cp ..\..\lib\servlet-api.jar -d web\beeradvisor\WEB-INF\classes src\com\example\web\BeerServlet.java
mkdir ..\..\webapps\beeradvisor
xcopy web\beeradvisor ..\..\webapps\beeradvisor /s /e /y