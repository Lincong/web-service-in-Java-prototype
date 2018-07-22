It is a playground that creates a Java-base RESTful web service using Jetty, Jersey and Gradle.

Build:
  gradle build

Start server:
  1. gradle jettyRunWar
  2. In browser: http://localhost:8080/chiando/<resource>

        eg: 
        http://localhost:8080/chiando/users/<userID>
