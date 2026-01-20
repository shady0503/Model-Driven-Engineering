# TestManyToMany

REST API generated with MDE Backend Generator.

## Stack

- Java 17 + Spring Boot 3.5.6
- POSTGRESQL database
- Docker Compose ready

## Quick Start

```bash
docker compose up -d --build
```

API available at: `http://localhost:8080`

## Entities

**Student** (4 fields, 1 relationships)  
**Course** (4 fields, 1 relationships)  

## API Endpoints

All entities support standard CRUD operations:
- `POST /api/{entity}` - Create
- `GET /api/{entity}` - List all
- `GET /api/{entity}/{id}` - Get by ID
- `PUT /api/{entity}/{id}` - Update
- `DELETE /api/{entity}/{id}` - Delete

- `/api/student` - Student
- `/api/course` - Course

## Development

Start database only:
```bash
docker compose up -d postgres```

Run locally:
```bash
mvn spring-boot:run
```

Run tests:
```bash
mvn test
```

Stop services:
```bash
docker compose down -v
```
