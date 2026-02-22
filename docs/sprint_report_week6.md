# Team 4 – Week 6 Sprint Report

Sprint Period: Week 6  
Project: HR Chatbot API

---

## Sprint Goal

Upgrade the application to production-grade security and database infrastructure.

- Implement Spring Security framework
- Implement JWT authentication
- Secure registration and login endpoints
- Configure PostgreSQL with Docker
- Set up Flyway database migrations
- Prepare deployment documentation

---

## Work Completed

* Spring Security dependency added
* Security configuration implemented
* BCrypt password hashing configured
* JWT token generation and validation implemented
* JWT authentication filter added
* Registration endpoint updated with password hashing
* Login endpoint updated to return JWT token
* Input validation and global exception handling improved
* PostgreSQL Docker container configured
* Flyway migration system implemented
* Migration scripts created (Users, Conversations, Messages)
* H2 replaced with PostgreSQL for production profile
* Environment-based configuration implemented (.env)
* PostgreSQL setup documentation created
* Deployment and sprint documentation completed

---

## Team Contributions

### Ravindra Saini – Security Lead

* Configured Spring Security
* Implemented JWT utility class
* Implemented JWT authentication filter
* Configured stateless authentication
* Integrated BCrypt password encoder
* Created security unit and integration tests

---

### Tri Phung – API Development Lead

* Updated registration endpoint to hash passwords
* Implemented login endpoint with JWT response
* Added duplicate validation for username and email
* Implemented field validation using annotations
* Created global exception handler
* Tested API using Postman
* Prepared authentication API documentation

---

### Ahmad Tariq – Database & Documentation Lead

* Configured PostgreSQL Docker container
* Created docker-compose.yml
* Implemented Flyway dependency and configuration
* Created migration scripts (V1, V2, V3)
* Switched application from H2 to PostgreSQL (prod profile)
* Verified database connectivity and schema creation
* Prepared PostgreSQL setup guide
* Completed Week 6 sprint report and documentation

---

## Challenges Faced

* Configuring stateless JWT authentication correctly
* Ensuring Spring Security did not block public endpoints
* Integrating JWT filter into security chain
* Transitioning from H2 to PostgreSQL
* Configuring Flyway with Hibernate validation
* Managing environment variables securely using .env
* Ensuring Docker container health before application startup

---

## Lessons Learned

* How stateless authentication works in Spring Security
* JWT token lifecycle and validation process
* Secure password handling using BCrypt
* Production database best practices (Flyway + validate)
* Docker-based database deployment
* Importance of separating configuration by profiles
* Secure handling of environment variables

---

## Status

Week 6 Deliverables: Completed  
Security: Production-grade  
Database: PostgreSQL + Flyway  
Ready for Week 7: Yes