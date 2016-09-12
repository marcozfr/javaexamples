set SERVER_DIR=C:\opt\apache-tomcat-8.5.4
javac -cp "%SERVER_DIR%\lib\*;lib\*" -sourcepath src -d web\beeradvisor\WEB-INF\classes src\com\example\model\*.java src\com\example\web\*.java src\com\example\web\listener\*.java src\com\example\web\tags\*.java src\com\example\web\filter\*.java
rmdir /s /q %SERVER_DIR%\webapps\beeradvisor
mkdir %SERVER_DIR%\webapps\beeradvisor
xcopy web\beeradvisor %SERVER_DIR%\webapps\beeradvisor /s /e /y
xcopy lib %SERVER_DIR%\webapps\beeradvisor\WEB-INF\lib /s /e /y