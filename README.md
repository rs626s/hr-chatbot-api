# HR Chatbot Application

## Overview

The HR Chatbot API is a Spring Boot backend service that provides authentication, conversation management, and integration with AI services.

It supports local development with H2 and production deployment with PostgreSQL and Flyway.

## Key Features

1. Spring Security authentication
2. JWT based stateless authorization
3. BCrypt password hashing
4. PostgreSQL database with Flyway migrations
5. Environment based configuration using .env
6. Actuator health and monitoring endpoints

## Project Structure

```text
hr-chatbot-api/
├── src/
├── Dockerfile
├── docker-compose.yml
├── .env
├── .env.example
├── init-scripts/
├── nginx/
├── docs/
└── pom.xml
```

## Prerequisites

Local Development

1. Java 17
2. Maven
3. Docker optional

Server Deployment

1. Linux server
2. Docker Engine
3. Docker Compose
4. Git

## Running Locally

Default profile is local.

Build

```bash
mvn clean install
```

Run

```bash
mvn spring-boot:run
```

Application URL

```text
http://localhost:8080
```

H2 Console

```text
http://localhost:8080/h2-console
```

Local profile uses H2 in memory database with automatic schema creation.

## Running with PostgreSQL in Production Mode

Step 1 Create environment file

```bash
cp .env.example .env
nano .env
```

Example .env

```env
POSTGRES_DB=chatbotdb
POSTGRES_USER=chatbot_user
POSTGRES_PASSWORD=StrongSecurePasswordHere
POSTGRES_PORT=5432

SPRING_PROFILES_ACTIVE=prod
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/chatbotdb
SPRING_DATASOURCE_USERNAME=chatbot_user
SPRING_DATASOURCE_PASSWORD=StrongSecurePasswordHere

JWT_SECRET=VeryStrongJWTSecretKey
JWT_EXPIRATION=86400000
```

Step 2 Start PostgreSQL

```bash
docker compose up -d
```

Step 3 Run Spring Boot

```bash
export $(grep -v '^#' .env | xargs)
mvn spring-boot:run
```

Production profile uses PostgreSQL and Flyway with ddl auto set to validate.

## Full Docker Deployment Optional

Build and run all services

```bash
docker compose up -d --build
```

## API Endpoints

Authentication

```text
POST /api/auth/register
POST /api/auth/login
```

For protected endpoints, include JWT token in the Authorization header

```text
Authorization: Bearer <token>
```

System endpoints

```text
GET /
GET /system
GET /info
GET /actuator/health
```

## Database

Local

H2 in memory database

Production

PostgreSQL 16 running in Docker  
Flyway manages schema migrations

Tables

1. users
2. conversations
3. messages

## Environment Variables

Database

1. POSTGRES_DB
2. POSTGRES_USER
3. POSTGRES_PASSWORD
4. POSTGRES_PORT

Spring Boot

1. SPRING_PROFILES_ACTIVE
2. SPRING_DATASOURCE_URL
3. SPRING_DATASOURCE_USERNAME
4. SPRING_DATASOURCE_PASSWORD

Security

1. JWT_SECRET
2. JWT_EXPIRATION

AI Services

1. CHROMADB_URL
2. OLLAMA_BASE_URL

## Deployment on Server

Install Docker

```bash
docker --version
docker compose version
```

Clone project

```bash
git clone <repository-url>
cd hr-chatbot-api
```

Configure environment

```bash
cp .env.example .env
nano .env
```

Start PostgreSQL

```bash
docker compose up -d
```

Run application

```bash
export $(grep -v '^#' .env | xargs)
mvn spring-boot:run
```

## Updating Deployment

Pull latest changes and rebuild

```bash
git pull
mvn clean package
```

If using full Docker deployment

```bash
docker compose down
docker compose up -d --build
```

## Stop Services

```bash
docker compose down
```

## Database Backup

Backup

```bash
docker exec chatbot-postgres pg_dump -U chatbot_user chatbotdb > backup.sql
```

Restore

```bash
cat backup.sql | docker exec -i chatbot-postgres psql -U chatbot_user -d chatbotdb
```

## Architecture Overview

```text
Nginx
  |
Spring Boot Application
  |
PostgreSQL Database
ChromaDB
Ollama
```

## Contributors

Team 4  
Missouri State University  
CSC 615 Advanced Internet Programming
