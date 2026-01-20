# FullSystem

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

**Users** (4 fields, 2 relationships)  
**Profile** (4 fields, 1 relationships)  
**Post** (4 fields, 2 relationships)  
**Category** (4 fields, 1 relationships)  

## API Endpoints

All entities support standard CRUD operations:
- `POST /api/{entity}` - Create
- `GET /api/{entity}` - List all
- `GET /api/{entity}/{id}` - Get by ID
- `PUT /api/{entity}/{id}` - Update
- `DELETE /api/{entity}/{id}` - Delete

- `/api/users` - Users
- `/api/profile` - Profile
- `/api/post` - Post
- `/api/category` - Category

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
