# Authentication API Documentation

Team 4 - Week 6 Project: AI HR Chatbot Backend

------------------------------------------------------------------------

## Base URL

http://localhost:8080/api/auth

------------------------------------------------------------------------

# Overview

This API provides secure user authentication using:

-   Spring Security
-   BCrypt password hashing
-   JWT (JSON Web Token) authentication
-   Input validation
-   Proper HTTP status handling

All protected endpoints require a valid JWT token.

------------------------------------------------------------------------

# Endpoints

## 1. Register User

POST /register

Creates a new user account with a securely hashed password.

### Request Body

``` json
{
  "username": "jsmith",
  "email": "jsmith@example.com",
  "password": "SecurePass123!",
  "firstName": "John",
  "lastName": "Smith"
}
```

### Success Response

201 Created

User registered successfully!

### Validation Rules

-   Username: Required, 3-20 characters
-   Email: Required, valid email format
-   Password: Required, minimum 8 characters
-   First Name: Required
-   Last Name: Required

### Error Responses

400 Bad Request - Validation Errors

``` json
{
  "email": "Email must be valid",
  "password": "Password must be at least 8 characters"
}
```

400 Bad Request - Duplicate Username

Error: Username is already taken!

400 Bad Request - Duplicate Email

Error: Email is already in use!

------------------------------------------------------------------------

## 2. Login User

POST /login

Authenticates user credentials and returns a JWT token.

### Request Body

``` json
{
  "username": "jsmith",
  "password": "SecurePass123!"
}
```

### Success Response

200 OK

``` json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "id": 1,
  "username": "jsmith",
  "email": "jsmith@example.com",
  "role": "USER"
}
```

### Error Response

401 Unauthorized

Error: Invalid username or password!

------------------------------------------------------------------------

# Using JWT for Protected Endpoints

Include the token in the Authorization header:

Authorization: Bearer your_token_here

If the token is missing, invalid, or expired, the API returns 401
Unauthorized.

------------------------------------------------------------------------

# Security Features

-   Passwords stored using BCrypt hashing
-   Stateless authentication using JWT
-   Token expiration: 24 hours
-   Duplicate username and email prevention
-   Global validation error handling
-   Secure separation of public and protected endpoints

------------------------------------------------------------------------

# Version

Week 6 - Spring Security and JWT Implementation Team 4 - AI HR Chatbot
Backend
