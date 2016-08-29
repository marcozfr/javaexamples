javac -cp C:\opt\apache-tomcat-8.5.4\lib\servlet-api.jar -sourcepath src -d web\beeradvisor\WEB-INF\classes src\com\example\model\*.java src\com\example\web\*.java src\com\example\web\listener\*.java
rmdir /s /q C:\opt\apache-tomcat-8.5.4\webapps\beeradvisor
mkdir C:\opt\apache-tomcat-8.5.4\webapps\beeradvisor
xcopy web\beeradvisor C:\opt\apache-tomcat-8.5.4\webapps\beeradvisor /s /e /y