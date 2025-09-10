# Run with Docker Compose

Make sure Docker and Docker Compose are installed.

From project root:
```bash
docker-compose up --build
```
- Wait until MySQL, backend and frontend are up (backend logs will show 'Started ElearningApplication').
- Frontend: http://localhost:4200
- Backend API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui/index.html

Stopping:
```bash
docker-compose down
```

If you need to run frontend locally (without Docker):
1. cd frontend
2. npm install
3. ng serve --open
