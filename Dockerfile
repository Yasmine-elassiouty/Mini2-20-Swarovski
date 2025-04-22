FROM openjdk:23
VOLUME /tmp
COPY target/Task_4.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
