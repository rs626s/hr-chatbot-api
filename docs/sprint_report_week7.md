# Team 4 -- Week 7 Sprint Report

Sprint Period: Week 7 (February 23--27, 2026)\
Project: HR Chatbot API

------------------------------------------------------------------------

## Sprint Goal

Transition from development environment to production-ready deployment.

-   Connect Spring Boot to Team 1's PostgreSQL
-   Implement user profile management APIs
-   Containerize application using Docker
-   Deploy within docker-compose environment
-   Verify full integration with infrastructure

------------------------------------------------------------------------

## Work Completed

-   Switched application from H2 to PostgreSQL production database
-   Configured Spring Boot PostgreSQL connection properties
-   Executed Flyway migrations on production database
-   Verified CRUD operations with persistent storage
-   Removed H2 dependency from project
-   Implemented Get Profile endpoint
-   Implemented Update Profile endpoint
-   Implemented Change Password endpoint
-   Secured all endpoints using JWT authentication
-   Created Dockerfile (multi-stage build)
-   Integrated Spring Boot service into docker-compose
-   Verified application connectivity within Docker network
-   Performed integration testing across services
-   Completed deployment and sprint documentation

------------------------------------------------------------------------

## Team Contributions

### Ravindra Saini -- Database Connection Lead

-   Configured PostgreSQL connection
-   Verified Flyway migrations
-   Ensured Hibernate validation mode
-   Tested registration and persistence
-   Removed H2 dependency
-   Confirmed production database stability

------------------------------------------------------------------------

### Tri Phung -- API Development Lead

-   Created UserController
-   Implemented profile retrieval endpoint
-   Implemented profile update endpoint
-   Implemented password change endpoint
-   Secured endpoints with JWT
-   Tested APIs with Postman
-   Verified persistence in PostgreSQL

------------------------------------------------------------------------

### Ahmad Tariq -- Containerization & Documentation Lead

-   Created multi-stage Dockerfile
-   Integrated Spring Boot into docker-compose
-   Configured environment variables for container
-   Verified container-to-database communication
-   Conducted integration testing
-   Prepared Week 7 sprint report and deployment guide

------------------------------------------------------------------------

## Challenges Faced

-   Ensuring correct Docker network configuration
-   Managing environment variables securely in containers
-   Removing all H2 references without breaking configuration
-   Testing JWT authentication inside containerized environment
-   Coordinating database readiness before container startup

------------------------------------------------------------------------

## Lessons Learned

-   Production database configuration best practices
-   Multi-stage Docker build optimization
-   Docker networking between services
-   Integration testing across containers
-   Importance of environment variable management in production
-   Coordination across team roles during deployment phase

------------------------------------------------------------------------

## Status

Week 7 Deliverables: Completed\
Database: Connected to PostgreSQL (Docker network)\
API: Profile management implemented\
Deployment: Dockerized and integrated\
Ready for Week 8: Yes
