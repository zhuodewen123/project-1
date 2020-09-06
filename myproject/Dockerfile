FROM openjdk:8u191-jre-alpine3.9
ENTRYPOINT ["/usr/bin/java", "-jar", "/myproject-0.0.1-SNAPSHOT.jar"]
ARG JAR_FILE
ADD ${JAR_FILE} /myproject-0.0.1-SNAPSHOT.jar
EXPOSE 80

