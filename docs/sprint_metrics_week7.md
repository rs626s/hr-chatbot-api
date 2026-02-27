# Sprint Metrics -- Week 7

Ravindra: PostgreSQL Connection\
Tri: Profile Endpoints\
Ahmad: Containerization & Deployment

------------------------------------------------------------------------

## Time Tracking

  Team Member      Planned Hours   Actual Hours   Variance
  ---------------- --------------- -------------- ----------
  Ravindra Saini   8               8              0
  Tri Phung        8               8              0
  Ahmad Tariq      8               8              0
  TOTAL            24              24             0

------------------------------------------------------------------------

## Task Completion Rate

Tasks Planned: 6\
Tasks Completed: 6\
Completion Rate: 100%

------------------------------------------------------------------------

## Code Metrics

-   Java files created/updated: 12+
-   New REST endpoints added: 3 (Get Profile, Update Profile, Change
    Password)
-   Controllers added: 1 (UserController)
-   DTO classes added: 3+
-   JWT secured endpoints verified: 3
-   Dockerfile created: 1
-   docker-compose services updated: 1 (Spring Boot app)

------------------------------------------------------------------------

## API Metrics

-   Public endpoints: /api/auth/\*\*
-   Protected endpoints: /api/users/\*\*
-   Authentication: JWT (Stateless)
-   Profile retrieval: Implemented
-   Profile update: Implemented
-   Password change validation: Implemented

------------------------------------------------------------------------

## Database Metrics

-   Database type: PostgreSQL 16
-   Connection method: Docker network (postgres:5432)
-   Hibernate mode: validate
-   Flyway migrations: Verified
-   Tables verified: users, conversations, messages
-   Data persistence across restarts: Confirmed

------------------------------------------------------------------------

## Containerization Metrics

-   Dockerfile: Multi-stage build
-   Base image: eclipse-temurin 17
-   Exposed port: 8080
-   docker-compose integration: Completed
-   Service dependency: postgres
-   Network: chatbot-network
-   Restart policy: unless-stopped

------------------------------------------------------------------------

## Build & Testing Metrics

-   Registration tested inside container: Yes
-   Profile endpoints tested: Yes
-   Password change tested: Yes
-   PostgreSQL connectivity inside Docker: Verified
-   Integration testing: Successful
-   API accessible via Nginx: Verified

------------------------------------------------------------------------

## Deployment Readiness

-   Production database connected: Yes
-   Dockerized backend: Yes
-   All services on shared network: Yes
-   Documentation complete: Yes

Week 7 Status: Production deployment completed and fully integrated.
