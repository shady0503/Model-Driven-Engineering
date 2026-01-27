# CodeForge Documentation

> Complete guide for using CodeForge to generate Spring Boot applications from YAML models.

---

## 📑 Table of Contents

- [Getting Started](#-getting-started)
  - [System Requirements](#system-requirements)
  - [Installation](#installation)
  - [Your First Project](#your-first-project)
- [YAML Model Reference](#-yaml-model-reference)
  - [Model Structure](#model-structure)
  - [Project Configuration](#project-configuration)
  - [Database Configuration](#database-configuration)
  - [Table Definition](#table-definition)
  - [Column Definition](#column-definition)
  - [Relationship Definition](#relationship-definition)
  - [API Configuration](#api-configuration)
- [CLI Reference](#-cli-reference)
  - [Global Options](#global-options)
  - [Generate Command](#generate-command)
  - [Validate Command](#validate-command)
- [Generated Project Structure](#-generated-project-structure)
- [Working with Relationships](#-working-with-relationships)
  - [One-to-One](#one-to-one)
  - [One-to-Many / Many-to-One](#one-to-many--many-to-one)
  - [Many-to-Many](#many-to-many)
  - [Self-Referencing](#self-referencing)
- [Database Support](#-database-support)
  - [PostgreSQL](#postgresql)
  - [MySQL](#mysql)
- [Docker Deployment](#-docker-deployment)
- [API Documentation](#-api-documentation)
- [Validation Rules](#-validation-rules)
- [Troubleshooting](#-troubleshooting)
- [Examples](#-examples)

---

## 🚀 Getting Started

### System Requirements

| Requirement | Minimum Version |
|-------------|-----------------|
| Java | 17 or higher |
| Maven | 3.9+ (or use Maven Wrapper) |
| Docker | 20.10+ (optional, for deployment) |
| OS | Windows 10+, macOS 10.15+, Linux |

### Installation

#### Option 1: Build from Source

```bash
# Clone the repository
git clone https://github.com/shady0503/CodeForge.git
cd CodeForge

# Build with Maven Wrapper
./mvnw clean package -DskipTests

# The JAR file will be at target/forge.jar
```

#### Option 2: Global Installation (Windows)

```bash
# After building, run:
make install

# This will:
# 1. Copy forge.jar to ~/.codeforge/bin/
# 2. Add the bin directory to your PATH
# 3. Copy example files to ~/.codeforge/examples/

# Restart your terminal, then use:
forge --help
```

#### Verify Installation

```bash
# If installed globally:
forge --version

# Or using JAR directly:
java -jar target/forge.jar --version
```

### Your First Project

**Step 1: Create a YAML model file**

Create a file named `blog.yaml`:

```yaml
?nsuri: http://www.Forge.com/model/v1
BackendConfig:
  project:
    name: BlogAPI
    groupId: com.example.blog
    javaVersion: 17
    springBootVersion: 3.5.6
    
  database:
    type: POSTGRESQL
    name: blog_db
    host: localhost
    port: 5432
    tables:
      - Table:
          name: Post
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: title, type: STRING, nullable: false }
            - Column: { name: content, type: TEXT }
            - Column: { name: published, type: BOOLEAN }

  api:
    basePath: /api/v1
    routes:
      - Route:
          entity: Post
          methods: [CREATE, READ, UPDATE, DELETE, LIST]
```

**Step 2: Generate the project**

```bash
forge generate blog.yaml -o ./blog-api
```

**Step 3: Run the generated project**

```bash
cd blog-api
docker compose up -d --build
```

**Step 4: Test the API**

```bash
# Create a post
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{"title": "Hello World", "content": "My first post", "published": true}'

# Get all posts
curl http://localhost:8080/api/posts

# Access Swagger UI
open http://localhost:8080/swagger-ui.html
```

---

## 📝 YAML Model Reference

### Model Structure

Every CodeForge model follows this structure:

```yaml
?nsuri: http://www.Forge.com/model/v1    # Required: Namespace URI
BackendConfig:                            # Root element
  project:                                # Project configuration
    ...
  database:                               # Database configuration
    ...
  api:                                    # API configuration (optional)
    ...
```

> ⚠️ **Important**: The `?nsuri` directive is required and must be the first line.

### Project Configuration

```yaml
project:
  name: MyProject                    # Required: Project name (used for artifact ID)
  groupId: com.example.myproject     # Required: Maven group ID / Java package
  javaVersion: 17                    # Optional: Java version (default: 17)
  springBootVersion: 3.5.6           # Optional: Spring Boot version (default: 3.5.6)
  version: 1.0.0                     # Optional: Project version (default: 1.0.0)
```

| Property | Required | Default | Description |
|----------|----------|---------|-------------|
| `name` | ✅ | - | Project name, used as Maven artifact ID |
| `groupId` | ✅ | - | Maven group ID, becomes base Java package |
| `javaVersion` | ❌ | `17` | Java version for compilation |
| `springBootVersion` | ❌ | `3.5.6` | Spring Boot parent version |
| `version` | ❌ | `1.0.0` | Project version |

### Database Configuration

```yaml
database:
  type: POSTGRESQL                   # Required: Database type
  name: my_database                  # Required: Database name
  host: localhost                    # Required: Database host
  port: 5432                         # Required: Database port
  tables:                            # Required: List of tables
    - Table:
        ...
```

| Property | Required | Description |
|----------|----------|-------------|
| `type` | ✅ | Database type: `POSTGRESQL` or `MYSQL` |
| `name` | ✅ | Database name |
| `host` | ✅ | Database hostname |
| `port` | ✅ | Database port number |
| `tables` | ✅ | List of table definitions |

### Table Definition

```yaml
- Table:
    name: User                       # Required: Table/Entity name (PascalCase)
    columns:                         # Required: List of columns
      - Column:
          ...
    relations:                       # Optional: List of relationships
      - Relation:
          ...
```

| Property | Required | Description |
|----------|----------|-------------|
| `name` | ✅ | Entity name in PascalCase (e.g., `User`, `BlogPost`) |
| `columns` | ✅ | List of column definitions |
| `relations` | ❌ | List of relationship definitions |

### Column Definition

#### Full Syntax

```yaml
- Column:
    name: email                      # Required: Column name
    type: STRING                     # Required: Data type
    primary: false                   # Optional: Is primary key?
    unique: true                     # Optional: Unique constraint?
    nullable: false                  # Optional: Allow null values?
    length: 255                      # Optional: Max length (for STRING)
    defaultValueLiteral: "default"   # Optional: Default value
```

#### Shorthand Syntax

```yaml
- Column: { name: id, type: LONG, primary: true }
- Column: { name: email, type: STRING, unique: true, nullable: false }
```

#### Column Properties

| Property | Required | Default | Description |
|----------|----------|---------|-------------|
| `name` | ✅ | - | Column name (snake_case recommended) |
| `type` | ✅ | - | Data type (see table below) |
| `primary` | ❌ | `false` | Primary key flag |
| `unique` | ❌ | `false` | Unique constraint |
| `nullable` | ❌ | `true` | Allow NULL values |
| `length` | ❌ | `0` | Max length for STRING type |
| `defaultValueLiteral` | ❌ | - | Default value as string |

#### Supported Data Types

| Type | Java Type | JPA/SQL Type | Notes |
|------|-----------|--------------|-------|
| `STRING` | `String` | `VARCHAR` | Use `length` to set max size |
| `TEXT` | `String` | `TEXT` | For long text content |
| `INTEGER` | `Integer` | `INT` | 32-bit integer |
| `LONG` | `Long` | `BIGINT` | 64-bit integer, use for IDs |
| `BOOLEAN` | `Boolean` | `BOOLEAN` | true/false values |
| `DATE` | `LocalDate` | `DATE` | Date without time |
| `DATETIME` | `LocalDateTime` | `TIMESTAMP` | Date with time |
| `UUID` | `UUID` | `UUID` | Universally unique identifier |
| `DECIMAL` | `BigDecimal` | `DECIMAL` | Precise decimal numbers |

### Relationship Definition

```yaml
- Relation:
    name: posts                      # Required: Relationship field name
    targetTable: Post                # Required: Target entity name
    type: ONE_TO_MANY                # Required: Relationship type
    owner: false                     # Required for bidirectional
    mappedBy: author                 # Required for non-owning side
    cascade: ALL                     # Optional: Cascade type
    fetch: LAZY                      # Optional: Fetch strategy
    joinColumnName: author_id        # Optional: FK column name
    joinTableName: user_roles        # Required for M2M owning side
    inverseJoinColumnName: role_id   # Required for M2M owning side
```

#### Relationship Properties

| Property | Required | Default | Description |
|----------|----------|---------|-------------|
| `name` | ✅ | - | Field name for the relationship |
| `targetTable` | ✅ | - | Target entity name |
| `type` | ✅ | - | `ONE_TO_ONE`, `ONE_TO_MANY`, `MANY_TO_ONE`, `MANY_TO_MANY` |
| `owner` | ✅* | `true` | Owning side of relationship |
| `mappedBy` | ✅* | - | Field name on owning side (non-owning only) |
| `cascade` | ❌ | `ALL` | JPA cascade type |
| `fetch` | ❌ | `LAZY` | `LAZY` or `EAGER` |
| `joinColumnName` | ❌ | Auto | Foreign key column name |
| `joinTableName` | ❌ | - | Join table name (M2M only) |
| `inverseJoinColumnName` | ❌ | - | Inverse FK column (M2M only) |

### API Configuration

```yaml
api:
  basePath: /api/v1                  # Optional: Base path for all routes
  routes:
    - Route:
        entity: User                 # Required: Entity name
        methods: [CREATE, READ, UPDATE, DELETE, LIST]  # Required: HTTP methods
```

#### Available Methods

| Method | HTTP | Endpoint | Description |
|--------|------|----------|-------------|
| `CREATE` | POST | `/api/{entity}s` | Create new entity |
| `READ` | GET | `/api/{entity}s/{id}` | Get entity by ID |
| `UPDATE` | PUT | `/api/{entity}s/{id}` | Full update |
| `DELETE` | DELETE | `/api/{entity}s/{id}` | Delete entity |
| `LIST` | GET | `/api/{entity}s` | List all (paginated) |

---

## 💻 CLI Reference

### Global Options

These options can be used with any command:

```bash
forge [OPTIONS] <command> [COMMAND-OPTIONS]
```

| Option | Description |
|--------|-------------|
| `-v, --verbose` | Enable verbose output with detailed logging |
| `--no-color` | Disable ANSI color output |
| `-h, --help` | Show help message |
| `-V, --version` | Print version information |

### Generate Command

Generate a Spring Boot project from a YAML model.

```bash
forge generate <yaml-file> [OPTIONS]
```

**Aliases:** `gen`, `g`

#### Options

| Option | Description | Default |
|--------|-------------|---------|
| `-o, --output-dir <dir>` | Output directory | `./generated-project` |
| `--overwrite` | Overwrite existing files | `false` |
| `--clean` | Clean output directory first | `false` |
| `--no-zip` | Skip ZIP archive creation | `false` |
| `--skip-validation` | Skip model validation | `false` |

#### Examples

```bash
# Basic generation
forge generate model.yaml

# Custom output directory
forge generate model.yaml -o ./my-project

# Clean and overwrite
forge generate model.yaml -o ./output --clean --overwrite

# Verbose mode
forge -v generate model.yaml

# Skip validation (not recommended)
forge generate model.yaml --skip-validation
```

### Validate Command

Validate a YAML model without generating code.

```bash
forge validate <yaml-file> [OPTIONS]
```

**Aliases:** `val`, `v`

#### Options

| Option | Description | Default |
|--------|-------------|---------|
| `-f, --format <format>` | Output format: `text` or `json` | `text` |
| `--strict` | Treat warnings as errors | `false` |

#### Examples

```bash
# Basic validation
forge validate model.yaml

# Strict mode (fail on warnings)
forge validate model.yaml --strict

# JSON output for CI/CD
forge validate model.yaml --format json
```

#### Exit Codes

| Code | Meaning |
|------|---------|
| `0` | Success |
| `1` | File not found / Input error |
| `2` | Validation error |
| `3` | Generation error |
| `4` | I/O error |
| `5` | Configuration error |

---

## 📂 Generated Project Structure

After running `forge generate`, you'll get this structure:

```
generated-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/project/
│   │   │       ├── Application.java          # Spring Boot main class
│   │   │       ├── config/
│   │   │       │   └── JpaAuditingConfig.java
│   │   │       ├── controller/
│   │   │       │   ├── UserController.java   # REST controllers
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       ├── entity/
│   │   │       │   └── User.java             # JPA entities
│   │   │       ├── exception/
│   │   │       │   └── ResourceNotFoundException.java
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java   # Spring Data repos
│   │   │       └── service/
│   │   │           └── UserService.java      # Service layer
│   │   └── resources/
│   │       └── application.properties        # Spring configuration
├── pom.xml                                   # Maven build file
├── Dockerfile                                # Multi-stage Docker build
├── docker-compose.yml                        # Docker Compose config
├── .dockerignore
└── README.md                                 # Project documentation
```

### Generated Files Description

| File | Description |
|------|-------------|
| `Application.java` | Spring Boot entry point with `@SpringBootApplication` |
| `*Controller.java` | REST controllers with CRUD endpoints |
| `*Entity.java` | JPA entities with Lombok annotations |
| `*Repository.java` | Spring Data JPA repository interfaces |
| `*Service.java` | Business logic layer with transactions |
| `application.properties` | Database and Spring configuration |
| `Dockerfile` | Multi-stage build for production |
| `docker-compose.yml` | App + database orchestration |

---

## 🔗 Working with Relationships

### One-to-One

**Example:** User has one Profile

```yaml
tables:
  - Table:
      name: User
      columns:
        - Column: { name: id, type: LONG, primary: true }
        - Column: { name: username, type: STRING }
      relations:
        - Relation:
            name: profile
            targetTable: Profile
            type: ONE_TO_ONE
            owner: true                    # User owns the relationship
            cascade: ALL
            fetch: LAZY
            joinColumnName: profile_id     # FK column in User table

  - Table:
      name: Profile
      columns:
        - Column: { name: id, type: LONG, primary: true }
        - Column: { name: bio, type: TEXT }
      relations:
        - Relation:
            name: user
            targetTable: User
            type: ONE_TO_ONE
            mappedBy: profile              # References User.profile field
            owner: false
```

**Generated JPA:**

```java
// User.java
@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "profile_id")
private Profile profile;

// Profile.java
@OneToOne(mappedBy = "profile")
private User user;
```

### One-to-Many / Many-to-One

**Example:** Department has many Employees

```yaml
tables:
  - Table:
      name: Department
      columns:
        - Column: { name: id, type: LONG, primary: true }
        - Column: { name: name, type: STRING }
      relations:
        - Relation:
            name: employees
            targetTable: Employee
            type: ONE_TO_MANY
            mappedBy: department           # References Employee.department
            cascade: ALL
            owner: false                   # ONE_TO_MANY is never the owner

  - Table:
      name: Employee
      columns:
        - Column: { name: id, type: LONG, primary: true }
        - Column: { name: name, type: STRING }
      relations:
        - Relation:
            name: department
            targetTable: Department
            type: MANY_TO_ONE
            owner: true                    # MANY_TO_ONE is always the owner
            joinColumnName: dept_id        # FK column in Employee table
```

**Generated JPA:**

```java
// Department.java
@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
@JsonIgnore
private List<Employee> employees;

// Employee.java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "dept_id")
private Department department;
```

### Many-to-Many

**Example:** Students enroll in Courses

```yaml
tables:
  - Table:
      name: Student
      columns:
        - Column: { name: id, type: LONG, primary: true }
        - Column: { name: name, type: STRING }
      relations:
        - Relation:
            name: courses
            targetTable: Course
            type: MANY_TO_MANY
            owner: true                         # Student owns the relationship
            joinTableName: student_courses      # Join table name
            joinColumnName: student_id          # FK to Student
            inverseJoinColumnName: course_id    # FK to Course

  - Table:
      name: Course
      columns:
        - Column: { name: id, type: LONG, primary: true }
        - Column: { name: title, type: STRING }
      relations:
        - Relation:
            name: students
            targetTable: Student
            type: MANY_TO_MANY
            mappedBy: courses                   # References Student.courses
            owner: false
```

**Generated JPA:**

```java
// Student.java
@ManyToMany
@JoinTable(
    name = "student_courses",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;

// Course.java
@ManyToMany(mappedBy = "courses")
private List<Student> students;
```

### Self-Referencing

**Example:** Category hierarchy (parent/children)

```yaml
tables:
  - Table:
      name: Category
      columns:
        - Column: { name: id, type: LONG, primary: true }
        - Column: { name: name, type: STRING }
      relations:
        - Relation:
            name: parent
            targetTable: Category
            type: MANY_TO_ONE
            owner: true
            joinColumnName: parent_id
        - Relation:
            name: children
            targetTable: Category
            type: ONE_TO_MANY
            mappedBy: parent
            owner: false
```

---

## 🗄 Database Support

### PostgreSQL

```yaml
database:
  type: POSTGRESQL
  name: mydb
  host: localhost
  port: 5432
```

**Generated `application.properties`:**

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:mydb}
spring.datasource.username=${DB_USER:postgres}
spring.datasource.password=${DB_PASSWORD:postgres}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

**Generated `docker-compose.yml`:**

```yaml
services:
  postgres:
    image: postgres:15-alpine
    environment:
      POSTGRES_DB: mydb
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
```

### MySQL

```yaml
database:
  type: MYSQL
  name: mydb
  host: localhost
  port: 3306
```

**Generated `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:mydb}
spring.datasource.username=${DB_USER:root}
spring.datasource.password=${DB_PASSWORD:root}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## 🐳 Docker Deployment

### Quick Start

```bash
cd generated-project
docker compose up -d --build
```

### Docker Compose Services

The generated `docker-compose.yml` includes:

| Service | Description | Port |
|---------|-------------|------|
| `app` | Spring Boot application | 8080 |
| `postgres` / `mysql` | Database server | 5432 / 3306 |

### Environment Variables

Override defaults using environment variables:

```bash
# Using .env file
DB_HOST=production-db.example.com
DB_PORT=5432
DB_NAME=production_db
DB_USER=prod_user
DB_PASSWORD=secure_password
JPA_DDL_AUTO=validate

# Or inline
DB_PASSWORD=secret docker compose up -d
```

### Production Considerations

```bash
# Build for production
docker build -t myapp:latest .

# Run with custom config
docker run -d \
  -p 8080:8080 \
  -e DB_HOST=prod-db.example.com \
  -e DB_PASSWORD=secure_password \
  -e JPA_DDL_AUTO=validate \
  myapp:latest
```

---

## 📖 API Documentation

### Swagger UI

Every generated project includes SpringDoc OpenAPI:

```
http://localhost:8080/swagger-ui.html
```

### OpenAPI JSON

```
http://localhost:8080/v3/api-docs
```

### Generated Endpoints

For each entity, these endpoints are generated:

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/{entity}s` | Create new |
| `GET` | `/api/{entity}s/{id}` | Get by ID |
| `GET` | `/api/{entity}s` | List all (paginated) |
| `GET` | `/api/{entity}s/all` | List all (no pagination) |
| `PUT` | `/api/{entity}s/{id}` | Full update |
| `PATCH` | `/api/{entity}s/{id}` | Partial update |
| `DELETE` | `/api/{entity}s/{id}` | Delete |

### Pagination

List endpoints support pagination:

```bash
# Default pagination
curl "http://localhost:8080/api/users"

# Custom page and size
curl "http://localhost:8080/api/users?page=0&size=20"

# With sorting
curl "http://localhost:8080/api/users?sort=name,asc"
```

---

## ✅ Validation Rules

CodeForge validates your model before generation using EVL (Epsilon Validation Language) constraints.

### Built-in Validations

| Rule | Description |
|------|-------------|
| **HasProject** | BackendConfig must define a project |
| **HasDatabase** | BackendConfig must define a database |
| **HasColumns** | Every table must have at least one column |
| **PrimaryKeyRequired** | Every table should have a primary key |
| **UniqueTableNames** | Table names must be unique |
| **ManyToOneShouldBeOwner** | MANY_TO_ONE relations must be owner=true |
| **OneToManyShouldNotBeOwner** | ONE_TO_MANY relations must be owner=false |
| **ManyToManyRequiresJoinTable** | Owning M2M must define joinTableName |
| **JavaReservedKeywords** | Names cannot be Java reserved words |
| **SqlReservedKeywords** | Names cannot be SQL reserved words |

### Validation Output

```bash
$ forge validate model.yaml

╔════════════════════════════════════════════════════════╗
║              YAML MODEL VALIDATION                     ║
╚════════════════════════════════════════════════════════╝

File: /path/to/model.yaml

VALIDATION RESULTS
──────────────────
✓ VALIDATION PASSED
  - Root element: BackendConfig ✓
  - Project configuration: valid ✓
  - Database configuration: valid ✓
  - 5 tables defined ✓
```

---

## 🔧 Troubleshooting

### Common Issues

#### "YAML file not found"

```bash
# Error
[ERROR] File not found: model.yaml

# Solution: Check file path
ls -la model.yaml
forge generate ./path/to/model.yaml
```

#### "Root element is not a BackendConfig"

```bash
# Error
Root element is not a BackendConfig. Found: Map

# Solution: Ensure ?nsuri directive is first line
# ✅ Correct:
?nsuri: http://www.Forge.com/model/v1
BackendConfig:
  ...

# ❌ Wrong:
BackendConfig:
  ...
```

#### "Package not registered"

```bash
# Error
Package with URI 'http://www.Forge.com/model/v1' not found

# Solution: This is an internal error. Try:
./mvnw clean package -DskipTests
```

#### "Validation failed"

```bash
# Error
✗ VALIDATION FAILED
  [Table: User] Table must have at least one column

# Solution: Add columns to your table
tables:
  - Table:
      name: User
      columns:                    # ← Add columns
        - Column: { name: id, type: LONG, primary: true }
```

#### "Database connection refused"

```bash
# Error
Connection refused: localhost:5432

# Solution: Start the database first
docker compose up -d postgres
# Wait a few seconds, then start app
docker compose up -d app
```

### Debug Mode

Enable verbose output for debugging:

```bash
forge -v generate model.yaml
```

This shows:
- File paths and sizes
- Parsing progress
- Validation details
- Generation steps

---

## 📚 Examples

### E-Commerce System

```yaml
?nsuri: http://www.Forge.com/model/v1
BackendConfig:
  project:
    name: ECommerceAPI
    groupId: com.example.ecommerce
    javaVersion: 17
    springBootVersion: 3.5.6

  database:
    type: POSTGRESQL
    name: ecommerce_db
    host: localhost
    port: 5432
    tables:
      - Table:
          name: Customer
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: email, type: STRING, unique: true, nullable: false }
            - Column: { name: name, type: STRING, nullable: false }
            - Column: { name: created_at, type: DATETIME }
          relations:
            - Relation:
                name: orders
                targetTable: Order
                type: ONE_TO_MANY
                mappedBy: customer
                owner: false

      - Table:
          name: Product
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: name, type: STRING, nullable: false }
            - Column: { name: description, type: TEXT }
            - Column: { name: price, type: DECIMAL }
            - Column: { name: stock, type: INTEGER }

      - Table:
          name: Order
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: order_date, type: DATETIME }
            - Column: { name: total, type: DECIMAL }
            - Column: { name: status, type: STRING }
          relations:
            - Relation:
                name: customer
                targetTable: Customer
                type: MANY_TO_ONE
                owner: true
                joinColumnName: customer_id
            - Relation:
                name: items
                targetTable: OrderItem
                type: ONE_TO_MANY
                mappedBy: order
                owner: false

      - Table:
          name: OrderItem
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: quantity, type: INTEGER }
            - Column: { name: price, type: DECIMAL }
          relations:
            - Relation:
                name: order
                targetTable: Order
                type: MANY_TO_ONE
                owner: true
                joinColumnName: order_id
            - Relation:
                name: product
                targetTable: Product
                type: MANY_TO_ONE
                owner: true
                joinColumnName: product_id

  api:
    basePath: /api/v1
    routes:
      - Route: { entity: Customer, methods: [CREATE, READ, UPDATE, DELETE, LIST] }
      - Route: { entity: Product, methods: [CREATE, READ, UPDATE, DELETE, LIST] }
      - Route: { entity: Order, methods: [CREATE, READ, UPDATE, LIST] }
      - Route: { entity: OrderItem, methods: [CREATE, READ, DELETE] }
```

### Healthcare System

```yaml
?nsuri: http://www.Forge.com/model/v1
BackendConfig:
  project:
    name: HealthcareAPI
    groupId: com.example.healthcare
    javaVersion: 17

  database:
    type: POSTGRESQL
    name: healthcare_db
    host: localhost
    port: 5432
    tables:
      - Table:
          name: Patient
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: first_name, type: STRING, nullable: false }
            - Column: { name: last_name, type: STRING, nullable: false }
            - Column: { name: date_of_birth, type: DATE }
            - Column: { name: email, type: STRING, unique: true }
            - Column: { name: phone, type: STRING }
          relations:
            - Relation:
                name: appointments
                targetTable: Appointment
                type: ONE_TO_MANY
                mappedBy: patient
                owner: false

      - Table:
          name: Doctor
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: first_name, type: STRING, nullable: false }
            - Column: { name: last_name, type: STRING, nullable: false }
            - Column: { name: specialization, type: STRING }
            - Column: { name: license_number, type: STRING, unique: true }
          relations:
            - Relation:
                name: appointments
                targetTable: Appointment
                type: ONE_TO_MANY
                mappedBy: doctor
                owner: false

      - Table:
          name: Appointment
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: appointment_date, type: DATETIME, nullable: false }
            - Column: { name: status, type: STRING }
            - Column: { name: notes, type: TEXT }
          relations:
            - Relation:
                name: patient
                targetTable: Patient
                type: MANY_TO_ONE
                owner: true
                joinColumnName: patient_id
            - Relation:
                name: doctor
                targetTable: Doctor
                type: MANY_TO_ONE
                owner: true
                joinColumnName: doctor_id

  api:
    basePath: /api/v1
    routes:
      - Route: { entity: Patient, methods: [CREATE, READ, UPDATE, DELETE, LIST] }
      - Route: { entity: Doctor, methods: [CREATE, READ, UPDATE, DELETE, LIST] }
      - Route: { entity: Appointment, methods: [CREATE, READ, UPDATE, DELETE, LIST] }
```

---

## 📞 Support

- **Issues**: [GitHub Issues](https://github.com/shady0503/CodeForge/issues)
- **Discussions**: [GitHub Discussions](https://github.com/shady0503/CodeForge/discussions)

---

<p align="center">
  <a href="#codeforge-documentation">⬆️ Back to Top</a>
</p>
