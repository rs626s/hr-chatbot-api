# Tri Phung - User Profile Management Endpoints

Week 7: February 23-27, 2026\
Role: API Development Lead

## Overview

This document outlines the development of secure user profile management
endpoints using JWT authentication and PostgreSQL.

## Implemented Endpoints

### 1. Get Profile

GET /api/users/profile\
Requires: Bearer JWT Token

Returns authenticated user profile details.

### 2. Update Profile

PUT /api/users/profile\
Requires: Bearer JWT Token

Allows updating first name, last name, and email.

### 3. Change Password

POST /api/users/change-password\
Requires: Bearer JWT Token

Validates old password before updating to new password.

## Testing

-   All endpoints tested with Postman
-   JWT authentication verified
-   Data persistence confirmed in PostgreSQL

## Security

-   All endpoints protected by Spring Security
-   Passwords encrypted using BCrypt
-   Old password required for change operation

Status: COMPLETED
