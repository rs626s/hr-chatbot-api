# Ravindra Saini - PostgreSQL Database Connection

Week 7: February 23-27, 2026\
Role: Team Captain & Database Connection Lead

## Overview

This document describes the configuration and verification of the
PostgreSQL database connection for the AI HR Chatbot Spring Boot
application.

## Objectives

-   Connect Spring Boot to Team 1's PostgreSQL database
-   Execute Flyway migrations
-   Verify CRUD operations
-   Remove H2 dependencies
-   Ensure production-ready configuration

## PostgreSQL Configuration

``` properties
spring.datasource.url=jdbc:postgresql://postgres:5432/chatbotdb
spring.datasource.username=chatbot_user
spring.datasource.password=${POSTGRES_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
```

## Verification Steps

### 1. Start Application

mvn spring-boot:run

### 2. Verify Tables

Connect to the database:

```bash
\c chatbotdb
```

List all tables:

```bash
\dt
```

View data from the users table:

```sql
SELECT * FROM users;
```

### 3. Test Registration API

curl -X POST http://localhost:8080/api/auth/register

## Success Criteria

-   PostgreSQL connected successfully
-   Flyway migrations executed
-   Registration/login working
-   Data persists across restarts
-   H2 dependency removed

Status: COMPLETED
