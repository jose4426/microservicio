# Usa una imagen base de Java 17
FROM openjdk:17-jdk-slim

LABEL author=JG.club

ENV DATABASE_URL jdbc:mysql://192.168.1.9:3306/microservice
ENV DATABASE_USERNAME root
ENV DATABASE_PASSWORD password
ENV DATABASE_PLATFORM org.hibernate.dialect.MySQL8Dialect
ENV DATABASE_DRIVER com.mysql.cj.jdbc.Driver

COPY target/microservicio-demo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

