# 🎨 PHASE 4: COMPLETE STANDALONE GUIDE
## Code Generation Templates - Context Metamodel & EGL Templates

---

## 📋 **OVERVIEW**

**Phase 4 Goal**: Create the infrastructure for Model-to-Text (M2T) code generation

**What You'll Build:**
1. **Context.ecore** - Platform-Specific Model (PSM) metamodel for code generation
2. **EGL Templates** - Templates that generate Java/Spring Boot code from Context models

**Time Estimate**: 3-4 days

**Prerequisites**: 
- ✅ Phase 1-3 completed (project setup, metamodel, parser)
- ✅ Eclipse Modeling Tools installed
- ✅ Understanding of MDE.ecore metamodel structure

---

## 🎯 **PART A: CONTEXT METAMODEL DESIGN (Days 1-2)**

### **Why Do We Need a Context Metamodel?**

```
BackendConfig (PIM) → [ETL Transform] → Context (PSM) → [EGL Templates] → Java Code
```

**The Context metamodel is a PSM (Platform-Specific Model) that:**
- Contains Java/Spring Boot specific information
- Is optimized for code generation (naming conventions, package paths, etc.)
- Separates domain concerns (PIM) from platform concerns (PSM)
- Makes templates simpler and cleaner

---

## 📝 **STEP 1: CREATE CONTEXT.ECORE FILE**

### **1.1 Open Eclipse Modeling Tools**

1. Launch Eclipse
2. Switch to "Modeling" perspective (Window → Perspective → Open Perspective → Other → Modeling)

### **1.2 Create New Ecore Model**

1. **Right-click** on `model/` folder in Project Explorer
2. Select **New → Other → Eclipse Modeling Framework → Ecore Model**
3. **File name**: `Context.ecore`
4. Click **Finish**

### **1.3 Set Package Properties**

Double-click `Context.ecore` to open the graphical editor.

In the **Properties** view (bottom panel), set:
- **Name**: `Context`
- **Ns Prefix**: `context`
- **Ns URI**: `http://www.mde.com/context`

---

## 🏗️ **STEP 2: DESIGN CONTEXT ECLASSES**

You'll create **5 main EClasses** for code generation context.

---

### **EClass 1: ProjectContext** (Project-level information)

**Purpose**: Holds all project-wide configuration for code generation

**How to Create:**
1. Right-click on the `Context` package in the tree
2. Select **New Child → EClass**
3. Set **Name**: `ProjectContext`

**Add Attributes** (Right-click on `ProjectContext` → New Child → EAttribute):

| Attribute Name | EType | Multiplicity | Description |
|----------------|-------|--------------|-------------|
| `groupId` | EString | 1..1 | Maven group ID (com.example) |
| `artifactId` | EString | 1..1 | Maven artifact ID (blog-api) |
| `version` | EString | 1..1 | Project version (1.0.0) |
| `packageName` | EString | 1..1 | Base Java package (com.example.blog) |
| `javaVersion` | EString | 1..1 | Java version (17, 21) |
| `springBootVersion` | EString | 1..1 | Spring Boot version (3.2.0) |
| `databaseType` | EString | 1..1 | Database type (postgresql, mysql) |
| `databaseName` | EString | 1..1 | Database name |

**Add Reference** (Right-click on `ProjectContext` → New Child → EReference):

| Reference Name | EType | Containment | Multiplicity | Description |
|----------------|-------|-------------|--------------|-------------|
| `entities` | EntityContext | ✅ Yes | 0..* | List of all entities |

---

### **EClass 2: EntityContext** (Per-entity information)

**Purpose**: Contains all information needed to generate code for one entity (User, Post, etc.)

**How to Create:**
1. Right-click on the `Context` package
2. Select **New Child → EClass**
3. Set **Name**: `EntityContext`

**Add Attributes:**

| Attribute Name | EType | Multiplicity | Description |
|----------------|-------|--------------|-------------|
| `tableName` | EString | 1..1 | Original table name (users) |
| `className` | EString | 1..1 | Java class name (User) |
| `packageName` | EString | 1..1 | Full package path (com.example.blog.entity) |
| `hasRelationships` | EBoolean | 1..1 | Whether entity has relationships |

**Add References:**

| Reference Name | EType | Containment | Multiplicity | Description |
|----------------|-------|-------------|--------------|-------------|
| `fields` | FieldContext | ✅ Yes | 1..* | List of fields |
| `relations` | RelationContext | ✅ Yes | 0..* | List of relationships |
| `primaryKey` | FieldContext | ❌ No | 1..1 | Reference to PK field |

---

### **EClass 3: FieldContext** (Per-field information)

**Purpose**: Contains information for generating one field in an entity

**Create EClass:**
1. Right-click on `Context` package → New Child → EClass
2. Name: `FieldContext`

**Add Attributes:**

| Attribute Name | EType | Multiplicity | Description |
|----------------|-------|--------------|-------------|
| `columnName` | EString | 1..1 | Database column name (user_id) |
| `fieldName` | EString | 1..1 | Java field name (userId) |
| `javaType` | EString | 1..1 | Java type (String, Integer, LocalDateTime) |
| `isPrimaryKey` | EBoolean | 1..1 | Is this the primary key? |
| `isNullable` | EBoolean | 1..1 | Can this be null? |
| `isUnique` | EBoolean | 1..1 | Is this unique? |

---

### **EClass 4: RelationContext** (JPA relationship information)

**Purpose**: Contains information for generating JPA relationships

**Create EClass:**
1. Right-click on `Context` package → New Child → EClass
2. Name: `RelationContext`

**Add Attributes:**

| Attribute Name | EType | Multiplicity | Description |
|----------------|-------|--------------|-------------|
| `fieldName` | EString | 1..1 | Relationship field name (author, posts) |
| `targetEntity` | EString | 1..1 | Target entity class name (User) |
| `relationType` | EString | 1..1 | JPA annotation (@ManyToOne, @OneToMany) |
| `isOwner` | EBoolean | 1..1 | Is this the owning side? |
| `joinColumnName` | EString | 0..1 | Join column name (user_id) |
| `mappedBy` | EString | 0..1 | MappedBy attribute for inverse side |
| `cascadeType` | EString | 1..1 | Cascade operations (ALL, PERSIST, etc.) |
| `fetchType` | EString | 1..1 | Fetch strategy (LAZY, EAGER) |

---

### **EClass 5: DependencyContext** (Maven dependency information)

**Purpose**: Represents Maven dependencies for pom.xml generation

**Create EClass:**
1. Right-click on `Context` package → New Child → EClass
2. Name: `DependencyContext`

**Add Attributes:**

| Attribute Name | EType | Multiplicity | Description |
|----------------|-------|--------------|-------------|
| `groupId` | EString | 1..1 | Dependency group ID |
| `artifactId` | EString | 1..1 | Dependency artifact ID |
| `version` | EString | 0..1 | Version (optional) |
| `scope` | EString | 0..1 | Scope (compile, test, runtime) |

**Add Reference to ProjectContext:**

Go back to `ProjectContext`:
- Right-click → New Child → EReference
- Name: `dependencies`
- EType: `DependencyContext`
- Containment: ✅ Yes
- Lower Bound: `0`
- Upper Bound: `-1` (unlimited)

---

## ✅ **STEP 3: VALIDATE YOUR METAMODEL**

### **3.1 Visual Check**

Your Context.ecore should look like this:

```
Context (package)
├── ProjectContext
│   ├── groupId: EString
│   ├── artifactId: EString
│   ├── version: EString
│   ├── packageName: EString
│   ├── javaVersion: EString
│   ├── springBootVersion: EString
│   ├── databaseType: EString
│   ├── databaseName: EString
│   ├── entities: EntityContext [0..*] (containment)
│   └── dependencies: DependencyContext [0..*] (containment)
│
├── EntityContext
│   ├── tableName: EString
│   ├── className: EString
│   ├── packageName: EString
│   ├── hasRelationships: EBoolean
│   ├── fields: FieldContext [1..*] (containment)
│   ├── relations: RelationContext [0..*] (containment)
│   └── primaryKey: FieldContext [1..1] (reference)
│
├── FieldContext
│   ├── columnName: EString
│   ├── fieldName: EString
│   ├── javaType: EString
│   ├── isPrimaryKey: EBoolean
│   ├── isNullable: EBoolean
│   └── isUnique: EBoolean
│
├── RelationContext
│   ├── fieldName: EString
│   ├── targetEntity: EString
│   ├── relationType: EString
│   ├── isOwner: EBoolean
│   ├── joinColumnName: EString [0..1]
│   ├── mappedBy: EString [0..1]
│   ├── cascadeType: EString
│   └── fetchType: EString
│
└── DependencyContext
    ├── groupId: EString
    ├── artifactId: EString
    ├── version: EString [0..1]
    └── scope: EString [0..1]
```

### **3.2 Save the Model**

Press **Ctrl+S** to save `Context.ecore`

---

## 🔧 **STEP 4: GENERATE JAVA CODE FROM CONTEXT.ECORE**

### **4.1 Create GenModel**

1. Right-click on `Context.ecore` in Project Explorer
2. Select **New → Other → Eclipse Modeling Framework → EMF Generator Model**
3. **File name**: `Context.genmodel`
4. Click **Next**
5. Select **Ecore model** as the model importer
6. Click **Next**
7. Browse and select `Context.ecore`
8. Click **Finish**

### **4.2 Configure GenModel**

Double-click `Context.genmodel` to open it.

**Set Properties** (select the root `Context` node in tree):
- **Base Package**: `com.mde.generator`
- **Model Directory**: `/model-driven-engineering/src/main/java`
- **Compliance Level**: `17.0`

### **4.3 Generate Model Code**

1. Right-click on the root `Context` package in the GenModel
2. Select **Generate Model Code**
3. Wait for code generation to complete

**Generated Code Location:**
```
src/main/java/com/mde/generator/Context/
├── ProjectContext.java
├── EntityContext.java
├── FieldContext.java
├── RelationContext.java
├── DependencyContext.java
├── ContextFactory.java
├── ContextPackage.java
└── impl/
    ├── ProjectContextImpl.java
    ├── EntityContextImpl.java
    ├── FieldContextImpl.java
    ├── RelationContextImpl.java
    └── DependencyContextImpl.java
```

---

## 🎯 **PART B: CREATE EGL TEMPLATES (Days 3-4)**

### **What are EGL Templates?**

EGL (Epsilon Generation Language) templates are text files with embedded expressions that generate code from models.

**Syntax:**
- `[% ... %]` - EOL code blocks (loops, conditions, variables)
- `[%= expression %]` - Output an expression value
- `[* ... *]` - Comments (not in output)
- Plain text - Copied directly to output

---

## 📁 **STEP 5: CREATE TEMPLATE DIRECTORY STRUCTURE**

Create the following folders in your project:

```
model-driven-engineering/
└── templates/
    ├── project/
    │   ├── pom.egl
    │   └── application.egl
    ├── entity/
    │   └── Entity.egl
    ├── repository/
    │   └── Repository.egl
    ├── service/
    │   └── Service.egl
    ├── controller/
    │   └── Controller.egl
    ├── docker/
    │   └── docker-compose.egl
    └── README.egl
```

---

## 📝 **STEP 6: CREATE POM.XML TEMPLATE**

**File**: `templates/project/pom.egl`

```xml
[* This template generates the Maven pom.xml file *]
[% var project = ProjectContext.all.first(); %]
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>[%= project.springBootVersion %]</version>
        <relativePath/>
    </parent>

    <groupId>[%= project.groupId %]</groupId>
    <artifactId>[%= project.artifactId %]</artifactId>
    <version>[%= project.version %]</version>
    <name>[%= project.artifactId %]</name>
    <description>Generated Spring Boot application</description>

    <properties>
        <java.version>[%= project.javaVersion %]</java.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- Database Driver -->
        [% if (project.databaseType = "postgresql") { %]
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        [% } else if (project.databaseType = "mysql") { %]
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        [% } %]

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- Test Dependencies -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        [* Custom dependencies *]
        [% for (dep in project.dependencies) { %]
        <dependency>
            <groupId>[%= dep.groupId %]</groupId>
            <artifactId>[%= dep.artifactId %]</artifactId>
            [% if (dep.version.isDefined()) { %]
            <version>[%= dep.version %]</version>
            [% } %]
            [% if (dep.scope.isDefined()) { %]
            <scope>[%= dep.scope %]</scope>
            [% } %]
        </dependency>
        [% } %]
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## 📝 **STEP 7: CREATE APPLICATION.YML TEMPLATE**

**File**: `templates/project/application.egl`

```yaml
[* This template generates application.yml for Spring Boot configuration *]
[% var project = ProjectContext.all.first(); %]
spring:
  application:
    name: [%= project.artifactId %]
  
  datasource:
    [% if (project.databaseType = "postgresql") { %]
    url: jdbc:postgresql://localhost:5432/[%= project.databaseName %]
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
    [% } else if (project.databaseType = "mysql") { %]
    url: jdbc:mysql://localhost:3306/[%= project.databaseName %]
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
    [% } %]
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: [% if (project.databaseType = "postgresql") { %]org.hibernate.dialect.PostgreSQLDialect[% } else { %]org.hibernate.dialect.MySQLDialect[% } %]

server:
  port: 8080

logging:
  level:
    [%= project.packageName %]: DEBUG
    org.springframework.web: INFO
    org.hibernate: INFO
```

---

## 📝 **STEP 8: CREATE ENTITY TEMPLATE**

**File**: `templates/entity/Entity.egl`

```java
[* This template generates JPA Entity classes *]
[% for (entity in EntityContext.all) { %]
package [%= entity.packageName %];

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
[* Import Java types based on fields *]
[% for (field in entity.fields) { %]
  [% if (field.javaType = "LocalDateTime" or field.javaType = "LocalDate") { %]
import java.time.[%= field.javaType %];
  [% } %]
  [% if (field.javaType = "UUID") { %]
import java.util.UUID;
  [% } %]
[% } %]
[% if (entity.hasRelationships) { %]
import java.util.List;
import java.util.Set;
[% } %]

/**
 * Entity class for [%= entity.tableName %] table
 * Generated by MDE Backend Generator
 */
@Entity
@Table(name = "[%= entity.tableName %]")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class [%= entity.className %] implements Serializable {

    [* Generate Fields *]
    [% for (field in entity.fields) { %]
    [% if (field.isPrimaryKey) { %]
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    [% } %]
    @Column(name = "[%= field.columnName %]", nullable = [%= field.isNullable %][% if (field.isUnique) { %], unique = true[% } %])
    private [%= field.javaType %] [%= field.fieldName %];
    
    [% } %]

    [* Generate Relationships *]
    [% for (relation in entity.relations) { %]
    [%= relation.relationType %][% if (relation.fetchType.isDefined()) { %](fetch = FetchType.[%= relation.fetchType %])[% } %]
    [% if (relation.isOwner and relation.joinColumnName.isDefined()) { %]
    @JoinColumn(name = "[%= relation.joinColumnName %]")
    [% } %]
    [% if (not relation.isOwner and relation.mappedBy.isDefined()) { %]
    (mappedBy = "[%= relation.mappedBy %]")
    [% } %]
    [% if (relation.relationType.endsWith("ToMany")) { %]
    private List<[%= relation.targetEntity %]> [%= relation.fieldName %];
    [% } else { %]
    private [%= relation.targetEntity %] [%= relation.fieldName %];
    [% } %]
    
    [% } %]
}
[% } %]
```

---

## 📝 **STEP 9: CREATE REPOSITORY TEMPLATE**

**File**: `templates/repository/Repository.egl`

```java
[* This template generates Spring Data JPA Repository interfaces *]
[% for (entity in EntityContext.all) { %]
package [%= entity.packageName.replace('.entity', '.repository') %];

import [%= entity.packageName %].[%= entity.className %];
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

[% var pkType = entity.primaryKey.javaType; %]

/**
 * Repository interface for [%= entity.className %] entity
 * Generated by MDE Backend Generator
 */
@Repository
public interface [%= entity.className %]Repository extends JpaRepository<[%= entity.className %], [%= pkType %]> {
    
    // Custom query methods can be added here
    
}
[% } %]
```

---

## 📝 **STEP 10: CREATE SERVICE TEMPLATE**

**File**: `templates/service/Service.egl`

```java
[* This template generates Service layer classes *]
[% for (entity in EntityContext.all) { %]
package [%= entity.packageName.replace('.entity', '.service') %];

import [%= entity.packageName %].[%= entity.className %];
import [%= entity.packageName.replace('.entity', '.repository') %].[%= entity.className %]Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

[% var pkType = entity.primaryKey.javaType; %]

/**
 * Service class for [%= entity.className %] entity
 * Generated by MDE Backend Generator
 */
@Service
@Transactional
public class [%= entity.className %]Service {

    private final [%= entity.className %]Repository repository;

    public [%= entity.className %]Service([%= entity.className %]Repository repository) {
        this.repository = repository;
    }

    /**
     * Create a new [%= entity.className %]
     */
    public [%= entity.className %] create([%= entity.className %] entity) {
        return repository.save(entity);
    }

    /**
     * Find [%= entity.className %] by ID
     */
    public Optional<[%= entity.className %]> findById([%= pkType %] id) {
        return repository.findById(id);
    }

    /**
     * Get all [%= entity.className %] entities
     */
    public List<[%= entity.className %]> findAll() {
        return repository.findAll();
    }

    /**
     * Update an existing [%= entity.className %]
     */
    public [%= entity.className %] update([%= pkType %] id, [%= entity.className %] entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("[%= entity.className %] not found with id: " + id);
        }
        entity.set[%= entity.primaryKey.fieldName.firstToUpperCase() %](id);
        return repository.save(entity);
    }

    /**
     * Delete [%= entity.className %] by ID
     */
    public void delete([%= pkType %] id) {
        repository.deleteById(id);
    }

    /**
     * Check if [%= entity.className %] exists by ID
     */
    public boolean exists([%= pkType %] id) {
        return repository.existsById(id);
    }
}
[% } %]
```

---

## 📝 **STEP 11: CREATE CONTROLLER TEMPLATE**

**File**: `templates/controller/Controller.egl`

```java
[* This template generates REST Controller classes *]
[% for (entity in EntityContext.all) { %]
package [%= entity.packageName.replace('.entity', '.controller') %];

import [%= entity.packageName %].[%= entity.className %];
import [%= entity.packageName.replace('.entity', '.service') %].[%= entity.className %]Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

[% var pkType = entity.primaryKey.javaType; %]

/**
 * REST Controller for [%= entity.className %] entity
 * Generated by MDE Backend Generator
 */
@RestController
@RequestMapping("/api/[%= entity.tableName %]")
@CrossOrigin(origins = "*")
public class [%= entity.className %]Controller {

    private final [%= entity.className %]Service service;

    public [%= entity.className %]Controller([%= entity.className %]Service service) {
        this.service = service;
    }

    /**
     * Create a new [%= entity.className %]
     * POST /api/[%= entity.tableName %]
     */
    @PostMapping
    public ResponseEntity<[%= entity.className %]> create(@RequestBody [%= entity.className %] entity) {
        [%= entity.className %] created = service.create(entity);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * Get [%= entity.className %] by ID
     * GET /api/[%= entity.tableName %]/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<[%= entity.className %]> getById(@PathVariable [%= pkType %] id) {
        return service.findById(id)
                .map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get all [%= entity.className %] entities
     * GET /api/[%= entity.tableName %]
     */
    @GetMapping
    public ResponseEntity<List<[%= entity.className %]>> getAll() {
        List<[%= entity.className %]> entities = service.findAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    /**
     * Update an existing [%= entity.className %]
     * PUT /api/[%= entity.tableName %]/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<[%= entity.className %]> update(
            @PathVariable [%= pkType %] id,
            @RequestBody [%= entity.className %] entity) {
        try {
            [%= entity.className %] updated = service.update(id, entity);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete [%= entity.className %] by ID
     * DELETE /api/[%= entity.tableName %]/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable [%= pkType %] id) {
        if (!service.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
[% } %]
```

---

## 📝 **STEP 12: CREATE DOCKER-COMPOSE TEMPLATE**

**File**: `templates/docker/docker-compose.egl`

```yaml
[* This template generates docker-compose.yml for database *]
[% var project = ProjectContext.all.first(); %]
version: '3.8'

services:
  [% if (project.databaseType = "postgresql") { %]
  postgres:
    image: postgres:15-alpine
    container_name: [%= project.artifactId %]-db
    environment:
      POSTGRES_DB: [%= project.databaseName %]
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    networks:
      - [%= project.artifactId %]-network

volumes:
  postgres_data:

  [% } else if (project.databaseType = "mysql") { %]
  mysql:
    image: mysql:8.0
    container_name: [%= project.artifactId %]-db
    environment:
      MYSQL_DATABASE: [%= project.databaseName %]
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql
    networks:
      - [%= project.artifactId %]-network

volumes:
  mysql_data:

  [% } %]
networks:
  [%= project.artifactId %]-network:
    driver: bridge
```

---

## 📝 **STEP 13: CREATE APPLICATION MAIN CLASS TEMPLATE**

**File**: `templates/project/Application.egl`

```java
[* This template generates the main Spring Boot Application class *]
[% var project = ProjectContext.all.first(); %]
package [%= project.packageName %];

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application
 * Generated by MDE Backend Generator
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

---

## 📝 **STEP 14: CREATE README TEMPLATE**

**File**: `templates/README.egl`

```markdown
[% var project = ProjectContext.all.first(); %]
# [%= project.artifactId %]

Generated Spring Boot application using MDE Backend Generator.

## 📋 Project Information

- **Group ID**: [%= project.groupId %]
- **Artifact ID**: [%= project.artifactId %]
- **Version**: [%= project.version %]
- **Java Version**: [%= project.javaVersion %]
- **Spring Boot Version**: [%= project.springBootVersion %]
- **Database**: [%= project.databaseType.toUpperCase() %]

## 🏗️ Generated Entities

[% for (entity in project.entities) { %]
### [%= entity.className %]
- **Table**: `[%= entity.tableName %]`
- **Fields**: [%= entity.fields.size() %]
[% if (entity.hasRelationships) { %]
- **Relationships**: [%= entity.relations.size() %]
[% } %]

[% } %]

## 🚀 Getting Started

### Prerequisites

- Java [%= project.javaVersion %] or higher
- Maven 3.8+
- Docker (for database)

### Running the Application

1. **Start the database**:
   ```bash
   docker-compose up -d
   ```

2. **Build the application**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

The API will be available at: `http://localhost:8080`

## 📚 API Endpoints

[% for (entity in project.entities) { %]
### [%= entity.className %]

- `POST /api/[%= entity.tableName %]` - Create new [%= entity.className %]
- `GET /api/[%= entity.tableName %]` - Get all [%= entity.className %]
- `GET /api/[%= entity.tableName %]/{id}` - Get [%= entity.className %] by ID
- `PUT /api/[%= entity.tableName %]/{id}` - Update [%= entity.className %]
- `DELETE /api/[%= entity.tableName %]/{id}` - Delete [%= entity.className %]

[% } %]

## 🧪 Testing

Run tests with:
```bash
mvn test
```

## 📝 License

This is generated code. Add your license information here.
```

---

## ✅ **VERIFICATION CHECKLIST**

### **Context Metamodel (Context.ecore):**
- [ ] Context.ecore file created in `model/` directory
- [ ] 5 EClasses defined: ProjectContext, EntityContext, FieldContext, RelationContext, DependencyContext
- [ ] All attributes added with correct ETypes and multiplicities
- [ ] References between classes properly configured (containment vs reference)
- [ ] Context.genmodel created and configured
- [ ] Java code generated from Context.genmodel
- [ ] Generated code compiles without errors

### **EGL Templates:**
- [ ] Template directory structure created
- [ ] pom.egl template complete (Maven configuration)
- [ ] application.egl template complete (Spring Boot config)
- [ ] Entity.egl template complete (JPA entities)
- [ ] Repository.egl template complete (Spring Data repositories)
- [ ] Service.egl template complete (Service layer)
- [ ] Controller.egl template complete (REST controllers)
- [ ] docker-compose.egl template complete (Database setup)
- [ ] Application.egl template complete (Main class)
- [ ] README.egl template complete (Documentation)

---

## 🎯 **WHAT'S NEXT (PHASE 5)?**

After completing Phase 4, you'll have:
- ✅ Context metamodel (PSM) designed and generated
- ✅ All EGL templates ready for code generation

**Phase 5 will implement:**
1. **ETL Transformation Module** - Transform BackendConfig → Context models
2. **EGL Execution Engine** - Execute templates to generate code
3. **File Writers** - Write generated code to filesystem
4. **Generator Coordinator** - Orchestrate the entire pipeline

---

## 📚 **ADDITIONAL RESOURCES**

### **EGL Syntax Reference:**
- `[% %]` - Code blocks
- `[%= %]` - Output expression
- `[* *]` - Comments
- `.all` - Get all instances of a type (e.g., `EntityContext.all`)
- `.first()` - Get first element
- `.size()` - Get collection size
- `.select(condition)` - Filter collection
- `.isDefined()` - Check if value is not null

### **Common EOL Operations:**
- String manipulation: `.toLowerCase()`, `.toUpperCase()`, `.replace(old, new)`
- Collections: `.size()`, `.isEmpty()`, `.includes(item)`, `.select()`, `.collect()`
- Conditionals: `if (condition) { } else { }`
- Loops: `for (item in collection) { }`

### **Naming Convention Helpers (to implement in Phase 5):**
- `toEntityName()` - users → User (snake_case → PascalCase)
- `toCamelCase()` - user_id → userId (snake_case → camelCase)
- `toPackagePath()` - com.example.blog → com/example/blog
- `firstToUpperCase()` - id → Id

---

## ❓ **TROUBLESHOOTING**

### **Issue**: Generated Context code has errors
**Solution**: 
1. Check that all EAttribute types are correct (EString, EBoolean, etc.)
2. Verify GenModel settings (base package, model directory)
3. Clean and regenerate: Right-click GenModel → Generate Model Code

### **Issue**: Template syntax errors
**Solution**:
1. Check all `[% %]` blocks are properly closed
2. Verify variable names match Context metamodel
3. Use `[%= %]` for output, not `[% %]`

### **Issue**: Can't find Context classes in Java code
**Solution**:
1. Refresh Eclipse project (F5)
2. Clean project (Project → Clean)
3. Rebuild project (Project → Build)

---

## 🎉 **COMPLETION**

Once you've completed this guide, you will have:

✅ **Context.ecore metamodel** - Platform-specific model for code generation
✅ **Generated Context Java classes** - Type-safe model API
✅ **10 EGL templates** - Complete code generation templates

**Your Phase 4 is complete!** You're now ready to move to Phase 5 where you'll implement the transformation engine that uses these templates to generate actual Spring Boot projects.

---

**Need Help?** Refer back to the existing `MDE.ecore` metamodel as a reference example for creating Context.ecore.

**Good luck! 🚀**