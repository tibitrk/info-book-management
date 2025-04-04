#FROM openjdk:17-jdk-alpine
#
#LABEL mentainer="rktibibit@gmail.com"
#
#WORKDIR /app
#
#COPY target/book-management-0.0.1-SNAPSHOT.jar /app/book-management.jar
#
#ENTRYPOINT ["java", "-jar","book-management.jar"]

FROM openjdk:17-jdk-alpine
COPY target/book-management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
