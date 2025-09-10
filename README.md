# E-Learning Platform (Full Stack) - Containerized

This project contains a Spring Boot backend, an Angular frontend, and a MySQL database, all configured to run with Docker Compose.

Services:
- backend: Spring Boot app (port 8080)
- frontend: Angular app served with a lightweight static server (port 4200)
- db: MySQL 8 (port 3306)

Quick start (requires Docker & Docker Compose):
```bash
# from project root where docker-compose.yml is located
docker-compose up --build
```
- Backend will be reachable at: http://localhost:8080
- Frontend will be reachable at: http://localhost:4200
- Swagger UI: http://localhost:8080/swagger-ui/index.html

Edit `backend/src/main/resources/application.properties` to change settings if needed.

