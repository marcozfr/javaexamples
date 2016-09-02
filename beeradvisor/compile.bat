javac -cp "C:\opt\apache-tomcat-8.0.33\lib\*;lib\*" -sourcepath src -d web\beeradvisor\WEB-INF\classes src\com\example\model\*.java src\com\example\web\*.java src\com\example\web\listener\*.java src\com\example\web\tags\*.java
rmdir /s /q C:\opt\apache-tomcat-8.0.33\webapps\beeradvisor
mkdir C:\opt\apache-tomcat-8.0.33\webapps\beeradvisor
xcopy web\beeradvisor C:\opt\apache-tomcat-8.0.33\webapps\beeradvisor /s /e /y
xcopy lib C:\opt\apache-tomcat-8.0.33\webapps\beeradvisor\WEB-INF\lib /s /e /y