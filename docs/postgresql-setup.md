# PostgreSQL Docker Setup Guide

HR Chatbot - Production Database Configuration

---

## Overview

This guide explains how to configure PostgreSQL using Docker and connect it to the Spring Boot application using the production profile.

Architecture:
- Docker runs PostgreSQL
- Maven runs Spring Boot with prod profile
- Flyway manages schema migrations
- Hibernate validates schema (does NOT create or update in production)

---

## Prerequisites

- Docker installed
- Docker Compose installed
- Java 17 or higher
- Maven installed
- Project cloned to server

---

## Step 1: Create .env File

Create a .env file in the same directory as docker-compose.yml.

```
# PostgreSQL
POSTGRES_DB=chatbotdb
POSTGRES_USER=chatbot_user
POSTGRES_PASSWORD=StrongSecurePasswordHere
POSTGRES_PORT=5432

# Spring Boot
SPRING_PROFILES_ACTIVE=prod
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/chatbotdb
SPRING_DATASOURCE_USERNAME=chatbot_user
SPRING_DATASOURCE_PASSWORD=StrongSecurePasswordHere

# JWT
JWT_SECRET=VeryStrongJWTSecretKeyAtLeast256BitsLong
JWT_EXPIRATION=86400000
```

Important:
- Never commit .env to Git
- Add .env to .gitignore

---

## Step 2: docker-compose.yml (PostgreSQL Only)

```
version: '3.8'

services:
  postgres:
    image: postgres:16
    container_name: chatbot-postgres
    environment:
      POSTGRES_DB: ${POSTGRES_DB:-chatbotdb}
      POSTGRES_USER: ${POSTGRES_USER:-chatbot_user}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
      POSTGRES_INITDB_ARGS: "--encoding=UTF8"
    ports:
      - "${POSTGRES_PORT:-5432}:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    restart: unless-stopped
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U ${POSTGRES_USER:-chatbot_user}"]
      interval: 10s
      timeout: 5s
      retries: 5

volumes:
  postgres_data:
```

---

## Step 3: Start PostgreSQL

```
docker compose up -d
```

Check status:

```
docker compose ps
```

---

## Step 4: Verify Database

```
docker exec -it chatbot-postgres psql -U chatbot_user -d chatbotdb
```

Inside PostgreSQL:

```
\l
\dt
\q
```

---

## Step 5: Spring Boot Production Configuration

application-prod.properties should contain:

```
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration

spring.h2.console.enabled=false
```

Important:
- Always use ddl-auto=validate in production
- Flyway manages schema changes

---

## Step 6: Load Environment Variables

```
export $(grep -v '^#' .env | xargs)
```

---

## Step 7: Start Spring Boot in Production Mode

```
mvn spring-boot:run
```

Since .env sets:

```
SPRING_PROFILES_ACTIVE=prod
```

The application will use:
- application.properties
- application-prod.properties

---

## Step 8: Verify Application

Health endpoint:

```
curl http://localhost:8080/actuator/health
```

Verify tables:

```
SELECT * FROM users;
```

---

## Production Safety Rules

Never use in production:
- ddl-auto=create
- ddl-auto=update
- ddl-auto=create-drop

Always use:
- ddl-auto=validate
- Flyway migrations

Never:
- Commit .env
- Hardcode passwords
- Expose database port publicly in cloud environments

---

## Stop PostgreSQL

```
docker compose down
```

To remove volume (warning: deletes data):

```
docker compose down -v
```

---

## Final Architecture

Server
- Docker runs PostgreSQL with persistent volume
- Maven runs Spring Boot with production profile
- Application connects via localhost:5432

PostgreSQL Docker setup is complete and production ready.
