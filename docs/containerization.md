# Ahmad Tariq - Spring Boot Containerization & Deployment

Week 7: February 23-27, 2026\
Role: Containerization & Documentation Lead

## Overview

This document describes the Docker containerization and deployment of
the Spring Boot API alongside Team 1 infrastructure.

## Dockerfile

``` dockerfile
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## docker-compose Integration

``` yaml
spring-boot-app:
  build: ./team4/spring-boot
  container_name: chatbot-api
  environment:
    POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
    JWT_SECRET: ${JWT_SECRET}
  ports:
    - "8080:8080"
  depends_on:
    - postgres
  networks:
    - chatbot-network
  restart: unless-stopped
```

## Integration Testing

-   Registration tested inside Docker
-   PostgreSQL connectivity verified
-   All services connected via shared network
-   API accessible through Nginx

## Sprint Outcome

-   Database connected
-   Profile APIs deployed
-   Application containerized
-   Ready for Week 8 integration

Status: COMPLETED
