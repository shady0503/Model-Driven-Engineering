<p align="center">
  <img src="https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17+"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Eclipse%20EMF-2.40-purple?style=for-the-badge&logo=eclipse&logoColor=white" alt="Eclipse EMF"/>
  <img src="https://img.shields.io/badge/Epsilon-2.8.0-blue?style=for-the-badge" alt="Epsilon"/>
  <img src="https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge" alt="License"/>
</p>

<h1 align="center">⚒️ CodeForge</h1>

<p align="center">
  <strong>A Model-Driven Engineering (MDE) tool that generates production-ready Spring Boot REST APIs from YAML specifications using Eclipse Epsilon transformations.</strong>
</p>

<p align="center">
  <a href="#-overview">Overview</a> •
  <a href="#-features">Features</a> •
  <a href="#-installation">Installation</a> •
  <a href="docs/USAGE.md">📖 Full Documentation</a> •
  <a href="#-authors">Authors</a>
</p>

---

## 📑 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Architecture](#-architecture)
- [Technology Stack](#-technology-stack)
- [Project Structure](#-project-structure)
- [Installation](#-installation)
- [Usage](#-usage)
  - [Generate Command](#generate-command)
  - [Validate Command](#validate-command)
  - [Example YAML Model](#example-yaml-model)
- [Documentation](#-documentation)
- [Configuration](#-configuration)
  - [Supported Data Types](#supported-data-types)
  - [Supported Relationship Types](#supported-relationship-types)
  - [Database Configuration](#database-configuration)
  - [Environment Variables](#environment-variables-generated-project)
- [Testing](#-testing)
- [Development Guidelines](#-development-guidelines)
- [Roadmap](#-roadmap)
- [Limitations](#-limitations)
- [License](#-license)
- [Authors](#-authors)

---

## 🎯 Overview

CodeForge is a code generation CLI tool that transforms declarative YAML model specifications into fully functional Spring Boot backend applications. It leverages Model-Driven Engineering principles with Eclipse EMF (Eclipse Modeling Framework) and Eclipse Epsilon to automate the creation of entities, repositories, services, controllers, and Docker configurations.

### Why CodeForge?

| Benefit | Description |
|---------|-------------|
| 🚀 **Eliminate Boilerplate** | Define your data model once in YAML, get a complete REST API |
| 🎯 **Consistency** | Generated code follows best practices and consistent patterns |
| ⚡ **Speed** | Go from specification to running application in seconds |
| 🐳 **Docker-Ready** | Every generated project includes Dockerfile and docker-compose |

### Main Use Cases

- Rapid prototyping of REST APIs
- Generating microservice backends from data models
- Educational tool for learning Spring Boot architecture
- Starting point for production applications

---

## ✨ Features

- **YAML-to-Code Generation** — Transform YAML model definitions into complete Spring Boot projects
- **Full CRUD REST APIs** — Automatic generation of Create, Read, Update, Delete, and List endpoints
- **JPA Entity Generation** — Entities with proper annotations, relationships, and validation
- **Multiple Database Support** — PostgreSQL and MySQL configurations out of the box
- **Relationship Support** — OneToOne, OneToMany, ManyToOne, ManyToMany with proper JPA mappings
- **Model Validation** — EVL (Epsilon Validation Language) constraints ensure model correctness
- **Docker Integration** — Generates Dockerfile and docker-compose.yml for containerized deployment
- **OpenAPI/Swagger** — Auto-generated API documentation
- **Lombok Integration** — Reduces boilerplate with annotations
- **Audit Fields** — Support for `@CreatedDate` and `@LastModifiedDate`
- **CLI Interface** — User-friendly command-line interface with colored output
- **Cross-Platform** — Works on Windows, macOS, and Linux

---

## 🏗 Architecture

CodeForge implements a Model-Driven Engineering pipeline with two main transformation phases:

```
┌─────────────┐     T2M (Flexmi)      ┌─────────────┐     M2T (EGL)      ┌─────────────┐
│  YAML File  │ ──────────────────►   │ Forge Model │ ─────────────────► │ Spring Boot │
│ (Input DSL) │                       │    (EMF)    │                    │   Project   │
└─────────────┘                       └─────────────┘                    └─────────────┘
                                            │
                                            ▼
                                    ┌─────────────┐
                                    │     EVL     │
                                    │ Validation  │
                                    └─────────────┘
```

### Main Components

| Component | Responsibility |
|-----------|---------------|
| **ForgeCli** | Main CLI entry point using Picocli framework |
| **GenerateCommand** | Handles project generation workflow |
| **ValidateCommand** | Validates YAML models without generation |
| **FlexmiModelLoader** | Parses YAML into EMF model instances (T2M) |
| **EVLValidationEngine** | Executes OCL-based validation constraints |
| **EGLTemplateEngine** | Generates Java source code from templates (M2T) |
| **ForgeGenerator** | Orchestrates the complete generation pipeline |

### Metamodel (Forge.ecore)

The core metamodel defines:

- **BackendConfig** — Root element containing project, database, and API configurations
- **Project** — Project metadata (name, groupId, Java version, Spring Boot version)
- **Database** — Database configuration (type, host, port, tables)
- **Table** — Entity definition with columns and relations
- **Column** — Field definition with data types and constraints
- **Relation** — Relationship definitions (OneToOne, OneToMany, ManyToOne, ManyToMany)
- **Api** — REST API configuration with routes

---

## 🛠 Technology Stack

### Languages
- Java 17

### Frameworks & Libraries

| Category | Technology | Version |
|----------|------------|---------|
| Application Framework | Spring Boot | 3.5.6 |
| Metamodeling | Eclipse EMF | 2.40.0 |
| Model Transformations | Eclipse Epsilon | 2.8.0 |
| CLI Framework | Picocli | 4.7.7 |
| YAML Parsing | SnakeYAML | 2.5 |
| Testing | JUnit 5 + Mockito | - |

### Build Tools
- **Maven** — Build and dependency management
- **Maven Wrapper** — Ensures consistent Maven version

### Generated Project Stack
- Spring Boot (configurable version)
- Spring Data JPA
- Spring Web
- Lombok
- SpringDoc OpenAPI (Swagger UI)
- PostgreSQL / MySQL drivers

---

## 📁 Project Structure

```
CodeForge/
├── 📂 model/
│   ├── Forge.ecore                  # EMF metamodel definition
│   └── Forge.genmodel               # EMF code generation model
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/
│   │   │   ├── 📂 com/codeforge/
│   │   │   │   ├── 📂 cli/                  # CLI commands
│   │   │   │   ├── 📂 generator/            # Code generation
│   │   │   │   │   ├── 📂 egl/              # EGL template engine
│   │   │   │   │   └── 📂 evl/              # EVL validation engine
│   │   │   │   ├── 📂 loader/               # Model loading
│   │   │   │   └── 📂 validation/           # Validators
│   │   │   └── 📂 Forge/                    # Generated EMF classes
│   │   └── 📂 resources/
│   │       ├── 📂 templates/                # EGL templates
│   │       │   ├── 📂 config/               # application.properties
│   │       │   ├── 📂 controller/           # REST controllers
│   │       │   ├── 📂 docker/               # Docker files
│   │       │   ├── 📂 entity/               # JPA entities
│   │       │   ├── 📂 exception/            # Exception classes
│   │       │   ├── 📂 project/              # pom.xml, Application
│   │       │   ├── 📂 repository/           # JPA repositories
│   │       │   └── 📂 service/              # Service layer
│   │       └── 📂 evl/
│   │           └── SpringConstraints.evl    # Validation rules
│   └── 📂 test/                             # Unit tests
├── 📂 examples/
│   └── kitchen_sink.yaml                    # Example model
├── 📂 scripts/
│   └── forge.cmd                            # Windows wrapper
├── pom.xml                                  # Maven configuration
├── Makefile                                 # Build automation
└── .gitignore
```

---

## 📦 Installation

### Prerequisites

- **Java 17** or higher
- **Maven 3.9+** (or use included Maven Wrapper)
- **Git** (for cloning)

### Quick Install

```bash
# 1. Clone the repository
git clone https://github.com/shady0503/CodeForge.git
cd CodeForge

# 2. Build the project
./mvnw clean package -DskipTests

# 3. (Optional) Install globally on Windows
make install
```

### Verify Installation

```bash
java -jar target/forge.jar --version
```

---

## 🚀 Usage

### Generate Command

```bash
forge generate <yaml-file> [OPTIONS]
```

| Option | Description | Default |
|--------|-------------|---------|
| `-o, --output-dir` | Output directory | `./generated-project` |
| `--overwrite` | Overwrite existing files | `false` |
| `--clean` | Clean output directory first | `false` |
| `--no-zip` | Skip ZIP archive creation | `false` |
| `--skip-validation` | Skip model validation | `false` |
| `-v, --verbose` | Enable verbose output | `false` |

**Examples:**

```bash
# Generate with custom output directory
forge generate blog.yaml -o ./my-blog-api

# Clean and regenerate
forge generate healthcare.yaml -o ./output --clean --overwrite

# Verbose output for debugging
forge -v generate social-media.yaml
```

### Validate Command

```bash
forge validate <yaml-file> [OPTIONS]
```

| Option | Description | Default |
|--------|-------------|---------|
| `-f, --format` | Output format (text/json) | `text` |
| `--strict` | Treat warnings as errors | `false` |

**Examples:**

```bash
# Validate with strict mode
forge validate blog.yaml --strict

# JSON output for CI/CD
forge validate blog.yaml --format json
```

### Example YAML Model

```yaml
?nsuri: http://www.Forge.com/model/v1
BackendConfig:
  project:
    name: BlogSystem
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
          name: User
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: username, type: STRING, unique: true, nullable: false }
            - Column: { name: email, type: STRING, unique: true }
          relations:
            - Relation:
                name: posts
                targetTable: Post
                type: ONE_TO_MANY
                mappedBy: author
                
      - Table:
          name: Post
          columns:
            - Column: { name: id, type: LONG, primary: true }
            - Column: { name: title, type: STRING, nullable: false, length: 255 }
            - Column: { name: content, type: TEXT }
            - Column: { name: published, type: BOOLEAN }
          relations:
            - Relation:
                name: author
                targetTable: User
                type: MANY_TO_ONE
                owner: true
                joinColumnName: author_id

  api:
    basePath: /api/v1
    routes:
      - Route:
          entity: User
          methods: [CREATE, READ, UPDATE, DELETE, LIST]
      - Route:
          entity: Post
          methods: [CREATE, READ, UPDATE, DELETE, LIST]
```

### Running the Generated Project

```bash
cd ./generated-project

# Start with Docker Compose
docker compose up -d --build

# Or run locally (requires database)
mvn spring-boot:run

# Access the API
curl http://localhost:8080/api/users

# Access Swagger UI
open http://localhost:8080/swagger-ui.html
```

---

## 📖 Documentation

For comprehensive documentation, see the **[Full Documentation Guide](docs/USAGE.md)**.

### Quick Links

| Document | Description |
|----------|-------------|
| [📖 Full Documentation](docs/USAGE.md) | Complete usage guide with all features |
| [YAML Model Reference](docs/USAGE.md#-yaml-model-reference) | Detailed YAML schema documentation |
| [CLI Reference](docs/USAGE.md#-cli-reference) | All commands and options |
| [Relationship Guide](docs/USAGE.md#-working-with-relationships) | How to define entity relationships |
| [Examples](docs/USAGE.md#-examples) | E-Commerce, Healthcare system examples |
| [Troubleshooting](docs/USAGE.md#-troubleshooting) | Common issues and solutions |

---

## ⚙️ Configuration

### Supported Data Types

| YAML Type | Java Type | JPA Column |
|-----------|-----------|------------|
| `STRING` | `String` | `VARCHAR` |
| `INTEGER` | `Integer` | `INT` |
| `LONG` | `Long` | `BIGINT` |
| `BOOLEAN` | `Boolean` | `BOOLEAN` |
| `DATE` | `LocalDate` | `DATE` |
| `DATETIME` | `LocalDateTime` | `TIMESTAMP` |
| `TEXT` | `String` | `TEXT` |
| `UUID` | `UUID` | `UUID` |
| `DECIMAL` | `BigDecimal` | `DECIMAL` |

### Supported Relationship Types

| Type | Description | Owning Side |
|------|-------------|-------------|
| `ONE_TO_ONE` | Single entity reference | Configurable |
| `ONE_TO_MANY` | Collection of entities | No |
| `MANY_TO_ONE` | Single entity reference | Yes |
| `MANY_TO_MANY` | Many-to-many with join table | Configurable |

### Database Configuration

| Database | Type Value | Default Port |
|----------|------------|--------------|
| PostgreSQL | `POSTGRESQL` | 5432 |
| MySQL | `MYSQL` | 3306 |

### Environment Variables (Generated Project)

| Variable | Description | Default |
|----------|-------------|---------|
| `DB_HOST` | Database hostname | `localhost` |
| `DB_PORT` | Database port | `5432` / `3306` |
| `DB_NAME` | Database name | From YAML |
| `DB_USER` | Database username | `postgres` / `root` |
| `DB_PASSWORD` | Database password | `postgres` / `root` |
| `JPA_DDL_AUTO` | Hibernate DDL mode | `update` |

---

## 🧪 Testing

### Run All Tests

```bash
./mvnw test
```

### Run Specific Test Class

```bash
./mvnw test -Dtest=GenerateCommandTest
./mvnw test -Dtest=ValidateCommandTest
```

### Test Coverage

The project includes unit tests for:
- CLI commands (`GenerateCommandTest`, `ValidateCommandTest`)
- Model loading and validation
- Code generation templates

---

## 👩‍💻 Development Guidelines

### Contribution Workflow

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Make your changes
4. Run tests (`./mvnw test`)
5. Commit your changes (`git commit -m 'Add amazing feature'`)
6. Push to the branch (`git push origin feature/amazing-feature`)
7. Open a Pull Request

### Code Style

- Follow standard Java conventions
- Use meaningful variable and method names
- Add Javadoc for public methods
- Keep methods focused and small
- Write unit tests for new functionality

### Adding New Templates

1. Create EGL template in `src/main/resources/templates/`
2. Import helper functions: `[% import "../ForgeHelpers.eol"; %]`
3. Register template execution in `EGLTemplateEngine.java`
4. Test with example YAML files

### Modifying the Metamodel

1. Edit `model/Forge.ecore` using EMF tools
2. Regenerate model code from `model/Forge.genmodel`
3. Update EGL templates to use new metamodel elements
4. Update validators if needed
5. Add example usage to `examples/kitchen_sink.yaml`

---

## 🗺 Roadmap

### Planned Features

- [ ] **Additional Database Support** — MongoDB, H2, Oracle
- [ ] **Authentication Templates** — JWT, OAuth2 integration
- [ ] **GraphQL Support** — Generate GraphQL schemas and resolvers
- [ ] **Frontend Generation** — React/Angular admin panels
- [ ] **Cloud Deployment** — AWS, GCP, Azure configuration templates
- [ ] **Custom Template Support** — User-defined EGL templates
- [ ] **IDE Plugin** — Eclipse/IntelliJ plugin for visual modeling
- [ ] **Interactive Mode** — Wizard-style project creation
- [ ] **Migration Support** — Flyway/Liquibase scripts

### Technical Improvements

- [ ] Expand test coverage for edge cases
- [ ] Add integration tests for full generation pipeline
- [ ] Improve error messages with line number references
- [ ] Add YAML schema validation
- [ ] Support for custom validators

---

## ⚠️ Limitations

### Known Constraints

| Constraint | Description |
|------------|-------------|
| Single Module | Generates single-module Spring Boot projects only |
| Fixed Architecture | Follows Controller-Service-Repository pattern |
| Limited Customization | Generated code structure is fixed |
| Java Only | No support for Kotlin or other JVM languages |
| REST Only | No GraphQL or gRPC support currently |

### Assumptions

- Generated projects require Java 17+
- Docker is recommended for running generated projects
- Database must be running before application startup
- All entities must have a primary key

### Scalability

- Designed for small to medium-sized projects
- Large models (100+ tables) may impact generation time
- Generated code may need optimization for high-traffic applications

---

## 📄 License

This project is available under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## 👥 Authors

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/shady0503">
        <img src="https://github.com/shady0503.png" width="100px;" alt="Mohamed Chadi TAQI"/><br />
        <sub><b>Mohamed Chadi TAQI</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/ImaneBenabbou">
        <img src="https://github.com/ImaneBenabbou.png" width="100px;" alt="Imane BENABBOU"/><br />
        <sub><b>Imane BENABBOU</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/saadalaoui23">
        <img src="https://github.com/saadalaoui23.png" width="100px;" alt="Saad ALAOUI SOSSE"/><br />
        <sub><b>Saad ALAOUI SOSSE</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Shiame">
        <img src="https://github.com/Shiame.png" width="100px;" alt="Chaymae BOUAZZA"/><br />
        <sub><b>Chaymae BOUAZZA</b></sub>
      </a>
    </td>
  </tr>
</table>

---

<p align="center">
  Built with ❤️ using Model-Driven Engineering principles
</p>

<p align="center">
  <a href="#️-codeforge">⬆️ Back to Top</a>
</p>
