It is a playground that creates a Java-base RESTful web service using Jetty, Jersey and Gradle.

Build:
  gradle build

Start server:
  1. gradle jettyRunWar
  2. In browser: http://localhost:8080/chiando/<resource>

        example:
        http://localhost:8080/chiando/users/<userID>

URL endpoints:

Login: http://localhost:8080/chiando/authentication/login



Example of using MySQL script:

mysql --user="username" --database="databasename" --password="yourpassword" < "filepath"
