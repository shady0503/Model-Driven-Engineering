# Model-Driven Backend Generator
## YAML-to-Spring Boot Code Generation using Eclipse EMF and Epsilon

---

## 📅 Project Timeline: 5-6 Weeks

```
Week 1-2: Ecore Meta-Model & Model Generation
Week 3-4: YAML Parser & Code Generation
Week 5:   Integration & Testing
Week 6:   Polish & Documentation
```

---

# 🎯 PHASE 1: Project Setup (Days 1-2)

**Status: ✅ COMPLETED (~90%)**

## Step 1.1: Create Project Structure

✅ **COMPLETED** - The project follows standard Maven structure:

1. Main project directory: `model-driven-engineering/`
2. Standard Maven directories:
   - `src/main/java` - Java source code ✅
   - `src/main/resources` - Configuration files ✅
   - `src/test/java` - Unit tests ✅
   - `model/` - Ecore model files (`MDE.ecore`, `MDE.genmodel`) ✅
   - `templates/` - EGL templates (created but empty) ⚠️
   - `examples/` - Two working YAML examples ✅

## Step 1.2: Set Up Maven Configuration

✅ **COMPLETED** - `pom.xml` configured with:
- Java 17 as compiler target ✅
- Eclipse EMF dependencies (ecore, common, xmi) ✅
- **Eclipse Epsilon** dependencies for the transformation stack:
  - **Flexmi** for T2M parsing (YAML → Model) ✅
  - **ETL** (Epsilon Transformation Language) for M2M transformations ⚠️
  - **EGL** (Epsilon Generation Language) for M2T code generation ⚠️
- Spring Boot Starter dependency ✅
- Picocli for CLI interface ✅
- JUnit 5 for testing ✅
- Maven Shade plugin configuration pending ⚠️

**MDE Note**: This project uses the **Eclipse Epsilon stack** - an integrated family of MDE languages and tools. Epsilon provides a consistent approach across all transformation types: Text-to-Model (Flexmi), Model-to-Model (ETL), and Model-to-Text (EGL), all with shared EOL-based query capabilities and metamodel awareness.

## Step 1.3: Install Eclipse Modeling Tools

✅ **COMPLETED** - Eclipse Modeling Tools used:
- Eclipse EMF utilized for meta-model development ✅
- Ecore meta-model created and maintained ✅
- GenModel configured for Java code generation ✅

---

# 🏗️ PHASE 2: Define Ecore Meta-Model (Days 3-5)

**Status: ✅ COMPLETED (100%)**

## Step 2.1: Understand the Meta-Model Architecture

✅ **COMPLETED** - Full understanding of the four-layer metamodeling stack:

**MDE Principle - Four-Layer Metamodeling Architecture:**
- **M3 (Meta-metamodel layer)**: Ecore itself - the reflexive metamodeling language provided by EMF that describes metamodeling concepts
- **M2 (Metamodel layer)**: `MDE.ecore` - Our domain-specific metamodel that defines the abstract syntax of our YAML-based backend configuration language
- **M1 (Model layer)**: User's YAML files (e.g., `blog-example.yaml`) - Concrete instances that *conformTo* our M2 metamodel
- **M0 (Instance layer)**: Generated Spring Boot application - The running system with actual data

**conformsTo Relationships:**
- M3 ← M2: `MDE.ecore` conforms to Ecore meta-metamodel
- M2 ← M1: YAML files conform to `MDE.ecore` metamodel
- M1 ← M0: Runtime data conforms to generated application model

This creates a well-founded metamodeling stack where each layer is precisely defined by the layer above it.

## Step 2.2: Create Ecore Model File

✅ **COMPLETED** - File created: `model/MDE.ecore`

The metamodel establishes our namespace as `com.mde.ModelDrivenEngineering`.

## Step 2.3: Define Root Container Class

✅ **COMPLETED** - `BackendConfig` EClass defined as root:
- Represents the top-level configuration container
- Contains three main composition relationships:
  - `project: Project [1..1]` - Project metadata
  - `database: Database [1..1]` - Database schema definition
  - `api: Api [0..1]` - Optional API configuration

**MDE Concept**: This follows the *composite pattern* in metamodeling, where `BackendConfig` acts as the root node in our abstract syntax tree.

## Step 2.4: Define EClasses for Major Concepts

✅ **COMPLETED** - Eight EClasses implemented:

### Core Configuration Classes:
1. **BackendConfig**: Root container for entire configuration
2. **Project**: Project metadata (name, groupId, version, language, framework)
3. **Database**: Database configuration (type, name, collection of tables)
4. **Table**: Table/entity definition (name, collection of columns)
5. **Column**: Column/field definition (name, type, nullable, primaryKey, optional relation)
6. **Relation**: Foreign key relationship (targetTable, targetColumn, relationType, cascadeTypes)
7. **Api**: API configuration (basePath, collection of routes)
8. **Route**: REST endpoint definition (entity, collection of HTTP methods)

**MDE Principle**: Each EClass represents a *concept* in our domain-specific modeling language (DSML). The metamodel defines the *abstract syntax* - the structure and relationships between concepts - independent of any concrete syntax (YAML, XML, or graphical notation).

## Step 2.5: Define EEnums for Controlled Vocabularies

✅ **COMPLETED** - Seven EEnums defined:

1. **Language**: JAVA, KOTLIN, TYPESCRIPT
2. **Framework**: SPRING_BOOT, QUARKUS, MICRONAUT
3. **DatabaseType**: POSTGRESQL, MYSQL, MONGODB
4. **DataType**: STRING, INTEGER, LONG, BOOLEAN, DATE, TIMESTAMP, UUID, TEXT, DOUBLE, FLOAT
5. **RelationType**: ONE_TO_ONE, ONE_TO_MANY, MANY_TO_ONE, MANY_TO_MANY
6. **CascadeType**: ALL, PERSIST, MERGE, REMOVE, REFRESH, DETACH
7. **HttpMethod**: GET, POST, PUT, DELETE, PATCH

**MDE Note**: EEnums provide type-safe, closed vocabularies ensuring metamodel instances can only use valid enumeration literals, enforcing well-formedness constraints at the M1 layer.

## Step 2.6: Create GenModel Configuration

✅ **COMPLETED** - `model/MDE.genmodel` created with proper configuration:
- Base Package: `com.mde` ✅
- Model Directory: `src/main/java` ✅
- Compliance Level: Java 17 ✅
- Copyright text and other generation properties configured ✅

**MDE Context**: The GenModel is a *model-to-model (M2M)* transformation specification that controls how our Ecore metamodel (M2) is transformed into Java code, which then serves as the foundation for further transformations.

## Step 2.7: Generate Java Model Code

✅ **COMPLETED** - Full EMF code generation executed:

Generated package structure in `src/main/java/com/mde/ModelDrivenEngineering/`:

**Interface Layer** (Abstract syntax):
- `ModelDrivenFactory.java` - Factory for creating model instances ✅
- `ModelDrivenPackage.java` - Package metadata and EClass/EEnum descriptors ✅
- `BackendConfig.java`, `Project.java`, `Database.java`, etc. - EClass interfaces ✅
- `Language.java`, `Framework.java`, `DataType.java`, etc. - EEnum interfaces ✅

**Implementation Layer** (`impl/` package):
- `ModelDrivenFactoryImpl.java` - Concrete factory implementation ✅
- `ModelDrivenPackageImpl.java` - Package initialization ✅
- `BackendConfigImpl.java`, `ProjectImpl.java`, etc. - EClass implementations ✅
- All EEnum implementations ✅

**Utility Layer** (`util/` package):
- `ModelDrivenAdapterFactory.java` - Adapter pattern support ✅
- `ModelDrivenSwitch.java` - Visitor pattern support ✅

**MDE Principle**: EMF's code generator applies *model-driven code generation* where the metamodel is the single source of truth. All Java interfaces, implementations, and utilities are *derived artifacts* automatically synchronized with the metamodel.

## Step 2.8: Verify Generated Code

✅ **COMPLETED** - Comprehensive verification performed:
- Factory pattern implementation verified ✅
- All 8 EClass interfaces and implementations present ✅
- All 7 EEnum interfaces and implementations present ✅
- Proper containment and cross-reference accessors ✅
- EMF's notification and adapter framework integrated ✅
- Serialization support (XMI) available ✅

**Current Package**: `com.mde.ModelDrivenEngineering`

---

# 🔧 PHASE 3: YAML Parser Implementation (Days 6-9)

**Status: ✅ MOSTLY COMPLETED (~85%)**

**ARCHITECTURAL DECISION**: This project leverages **Flexmi** - a flexible metamodel-driven parser from Eclipse Epsilon that automatically handles YAML-to-Ecore model transformation.

**MDE Advantages of Flexmi Approach:**
1. **Metamodel-Driven Parsing**: Flexmi reads our Ecore metamodel and automatically understands how to parse YAML into model instances - a true *conformsTo* relationship
2. **Declarative Approach**: No imperative mapping code needed; the metamodel itself defines the structure
3. **Type Safety**: Automatic validation against metamodel constraints during parsing
4. **Line-Number Error Reporting**: Parse errors include exact line numbers from YAML file
5. **Reduced Code Maintenance**: Changes to metamodel automatically reflect in parsing behavior
6. **Alignment with MDE Principles**: Parser leverages the metamodel as single source of truth

## Step 3.1: Plan Parser Architecture

✅ **COMPLETED** - Architecture defined using Flexmi:

**Model-to-Model (M2M) Transformation Context:**
- **Source**: YAML text (concrete syntax in grammarware technical space)
- **Target**: EMF model instance (abstract syntax in modelware technical space)
- **Transformation**: Flexmi acts as a *text-to-model (T2M)* transformation engine
- **Metamodel**: `MDE.ecore` drives the transformation behavior

The parser architecture consists of:
1. **ModelPackageRegistrar**: Registers Ecore package and Flexmi resource factory globally
2. **FlexmiModelLoader**: Facade that loads YAML files into BackendConfig instances
3. **LoadException**: Custom exception for parse/load errors
4. **EMF ResourceSet**: Manages model resources and cross-reference resolution

## Step 3.2: Create Parser Package Structure

✅ **COMPLETED** - Package created: `com.mde.loader`

Files created:
- `FlexmiModelLoader.java` - Main loader facade ✅
- `ModelPackageRegistrar.java` - Package and factory registration ✅
- `LoadException.java` - Custom exception class ✅

## Step 3.3: Implement Main Parser Class

✅ **COMPLETED** - `FlexmiModelLoader` implemented with:

**Key Methods:**
```java
public BackendConfig load(String filePath) throws LoadException
public BackendConfig load(File file) throws LoadException
public BackendConfig load(Path path) throws LoadException
```

**Implementation Details:**
1. Creates EMF `ResourceSet` for managing resources
2. Validates file existence and readability
3. Converts file path to EMF URI
4. Uses Flexmi's resource factory to parse YAML
5. Resolves all cross-references via `EcoreUtil.resolveAll()`
6. Extracts and validates root `BackendConfig` object
7. Provides detailed error messages with line numbers

**MDE Principle**: This loader implements the *injection* phase of a model transformation, converting textual artifacts (YAML) into model elements that conform to our metamodel.

## Step 3.4: Implement Section Parsers

✅ **NOT NEEDED** - Flexmi handles this automatically!

Flexmi automatically:
- Recognizes YAML structure based on metamodel
- Creates appropriate EClass instances
- Populates attributes from YAML properties
- Establishes containment and cross-references
- Validates structure against metamodel

**Example YAML automatically parsed:**
```yaml
BackendConfig:
  project:
    name: BlogPlatform
    groupId: com.example
    ...
  database:
    name: blog_db
    tables:
      - name: users
        columns:
          - name: id
            type: UUID
            ...
```

**MDE Insight**: This demonstrates the power of metamodel-driven parsing - the metamodel *is* the parser specification.

## Step 3.5: Implement Helper Methods

⚠️ **PARTIALLY NEEDED** - Flexmi handles most parsing, but FlexmiModelLoader provides:

**Implemented Helpers:**
- `loadResource(URI)` - Loads EMF resource with error handling
- `extractRootObject(Resource)` - Extracts and validates BackendConfig root
- File validation (exists, readable, is file)
- URI conversion utilities

**Not Needed:**
- Type conversion helpers (Flexmi handles this)
- Required field extraction (EMF validation handles this)
- Enum parsing (Flexmi uses metamodel enums directly)

## Step 3.6: Add Validation Logic

✅ **IMPLEMENTED** via EMF's built-in validation:

**Validation Layers:**
1. **Structural Validation**: Flexmi ensures YAML structure matches metamodel
2. **Type Validation**: EAttributes must match declared EDataTypes
3. **Multiplicity Validation**: Required features must be present [1..1]
4. **Enum Validation**: Enum literals must match defined EEnum values
5. **Cross-Reference Validation**: References must point to valid objects

**Load-Time Validation:**
- Parser checks `resource.getErrors()` for structural issues
- Parser logs `resource.getWarnings()` for non-critical issues
- LoadException thrown for any validation failures with line numbers

**MDE Note**: Validation is declarative - defined once in metamodel, enforced everywhere automatically.

## Step 3.7: Implement Error Handling

✅ **COMPLETED** - Comprehensive error handling:

**Error Categories Handled:**
- File not found / not readable / not a file
- Invalid YAML syntax (from Flexmi)
- Structure doesn't match metamodel (from Flexmi)
- Invalid enum values (from Flexmi with line numbers)
- Missing required fields (from EMF)
- Type mismatches (from EMF)
- Empty or invalid root element

**Error Message Format:**
```
Errors in YAML file:
  Line 15: Invalid value 'POSTGRES' for attribute 'type'. Expected one of: [POSTGRESQL, MYSQL, MONGODB]
  Line 23: Required attribute 'name' is missing for Table
```

**MDE Principle**: Error messages reference the *metamodel concepts* (attributes, types, multiplicity) making them meaningful to users familiar with the domain.

## Step 3.8: Create Unit Tests

✅ **COMPLETED** - Comprehensive test suite in `FlexmiModelLoaderTest`:

**Test Cases Implemented:**
1. **testLoadMinimalExample()** ✅
   - Tests loading `examples/minimal-example.yaml`
   - Verifies Project, Database, and Table structure
   - Confirms attribute values correctly parsed

2. **testLoadBlogExample()** ✅
   - Tests loading `examples/blog-example.yaml`
   - Verifies complex model with 3 tables
   - Validates relationship parsing (user_id → users.id foreign key)
   - Confirms cross-references properly resolved

3. **testMissingFile()** ✅
   - Verifies LoadException thrown for non-existent files
   - Confirms appropriate error message

**Test Coverage:**
- Valid YAML parsing ✅
- Complex relationships ✅
- Error handling ✅

**Still Needed:**
- Invalid enum value tests ⚠️
- Missing required field tests ⚠️
- Malformed YAML tests ⚠️
- Edge cases (empty lists, null values) ⚠️

**MDE Testing Principle**: Tests validate both *syntactic conformance* (valid YAML structure) and *semantic conformance* (meaningful model instances).

---

# 🎨 PHASE 4: Code Generation - Templates (Days 10-14)

**Status: ❌ NOT STARTED (~5%)**

**MDE Context**: This phase implements *Model-to-Text (M2T) transformations* using EGL (Epsilon Generation Language). Platform-independent models (M1 layer) are transformed into platform-specific code (Java source files). This is the core generative aspect of our MDSE approach.

## Step 4.1: Choose Template Engine

✅ **PLANNED** - **EGL (Epsilon Generation Language)** selected as M2T transformation language:

**Rationale:**
- **Metamodel-aware**: EGL understands Ecore metamodels natively
- **OCL-based querying**: Uses EOL (Epsilon Object Language) which extends OCL for model navigation
- **Template-based**: Separates static code structure from dynamic model-driven content
- **Integrated tooling**: Part of Eclipse Epsilon ecosystem alongside Flexmi and ETL
- **Protected regions**: Built-in support for preserving manually-written code sections
- **Mature MDE tool**: Specifically designed for model-to-text transformations

**MDE Principle**: EGL is a dedicated M2T transformation language that provides first-class support for models, metamodels, and MDE concepts.

**Epsilon Stack Integration:**
- **Flexmi** (T2M): YAML → BackendConfig model
- **ETL** (M2M): BackendConfig model → Context models
- **EGL** (M2T): Context models → Java source code

This creates a consistent transformation pipeline using the Epsilon family of languages.

## Step 4.2: Create Template Directory Structure

❌ **NOT STARTED** - `templates/` directory exists but is empty

**Planned Structure (EGL Templates):**
```
templates/
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

**EGL Template Syntax:**
- `[% ... %]` - Code blocks for EOL (Epsilon Object Language) expressions
- `[%= expression %]` - Output expressions (like `<%= %>` in JSP)
- `[* ... *]` - Comments
- Direct text output (everything outside markers)

**MDE Note**: Each `.egl` template represents a *transformation rule* that takes model elements as input and produces text as output. The template structure mirrors the target architecture while EOL expressions provide model-driven content.

## Step 4.3: Design Context Metamodel (PSM)

❌ **NOT STARTED** - Context metamodel to be created

**Create `Context.ecore` Metamodel:**

The Context metamodel defines the Platform-Specific Model (PSM) layer - an intermediate model optimized for code generation. This is separate from the BackendConfig metamodel (PIM).

**Context EClasses (PSM):**

1. **ProjectContext**: Project-level code generation data
   - groupId: String
   - artifactId: String
   - version: String
   - javaVersion: String
   - frameworkVersion: String
   - dependencies: List<Dependency>

2. **EntityContext**: Per-entity code generation data
   - tableName: String
   - className: String (PascalCase)
   - packageName: String
   - fields: List<FieldContext>
   - relations: List<RelationContext>

3. **FieldContext**: Per-field code generation data
   - columnName: String
   - fieldName: String (camelCase)
   - javaType: String
   - nullable: Boolean
   - isPrimaryKey: Boolean
   - annotations: List<String>

4. **RelationContext**: JPA relationship data
   - relationType: String (@ManyToOne, @OneToMany, etc.)
   - targetEntity: String
   - joinColumn: String
   - mappedBy: String
   - cascadeTypes: List<String>

**MDE Architecture:**
```
PIM (BackendConfig.ecore) 
  ↓ [ETL Transformation]
PSM (Context.ecore) 
  ↓ [EGL Templates]
Code (Java files)
```

**Why a Separate Context Metamodel?**
- **Separation of Concerns**: PIM focuses on domain concepts; PSM focuses on code generation needs
- **Multiple Targets**: Same PIM could generate different PSMs (Spring Boot, Quarkus, Micronaut)
- **Transformation Clarity**: ETL rules explicitly show PIM→PSM mapping
- **Template Simplicity**: EGL templates work with code-optimized data structures

This is the classic **MDA approach**: CIM → PIM → PSM → Code, where our BackendConfig is the PIM and Context is the PSM.

## Step 4.4: Create POM Template

❌ **NOT STARTED** - `pom.egl` to be designed

**Template Should Include:**
- Project coordinates using EGL expressions: `[%= context.groupId %]`, `[%= context.artifactId %]`
- Java version: `[%= context.javaVersion %]`
- Spring Boot parent and version
- Dependencies: Spring Web, Spring Data JPA, database driver, Lombok
- Build plugins: Maven compiler, Spring Boot plugin

**Example EGL Template Snippet:**
```xml
<groupId>[%= context.groupId %]</groupId>
<artifactId>[%= context.projectName %]</artifactId>
<version>[%= context.version %]</version>

[% for (dependency in context.dependencies) { %]
<dependency>
    <groupId>[%= dependency.groupId %]</groupId>
    <artifactId>[%= dependency.artifactId %]</artifactId>
</dependency>
[% } %]
```

**MDE Concept**: This template embodies the M2T transformation where `[%= ... %]` expressions are *metamodel-aware queries* that extract values from the context model. EGL's EOL expressions can navigate model structures, call operations, and use OCL-like collection operations.

## Step 4.5: Create Application Configuration Template

❌ **NOT STARTED** - `application.egl` to be designed

**Template Should Include:**
- Server port configuration
- Database connection: `[%= context.database.type %]`, `[%= context.database.name %]`
- JPA/Hibernate configuration
- Logging levels

**Example EGL Template:**
```yaml
spring:
  datasource:
    url: jdbc:[%= context.database.type.toLowerCase() %]://localhost:5432/[%= context.database.name %]
    username: [%= context.database.username %]
    password: [%= context.database.password %]
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: [%= context.debug ? "true" : "false" %]
```

## Step 4.6: Create Entity Template

❌ **NOT STARTED** - `Entity.egl` to be designed

**Template Should Include:**
- Package declaration: `package com.[%= context.groupId %].[%= context.projectName %].entity;`
- JPA annotations: @Entity, @Table
- Primary key handling with @Id, @GeneratedValue
- Field declarations with types mapped from DataType enum
- Relationship annotations: @ManyToOne, @OneToMany, @JoinColumn
- Lombok annotations: @Data, @NoArgsConstructor

**Example EGL Template Snippet:**
```java
package com.[%= context.groupId %].[%= context.projectName %].entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "[%= entity.tableName %]")
@Data
@NoArgsConstructor
public class [%= entity.className %] {
    
    [% for (field in entity.fields) { %]
    [% if (field.isPrimaryKey) { %]
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    [% } %]
    @Column(name = "[%= field.columnName %]", nullable = [%= field.nullable %])
    private [%= field.javaType %] [%= field.fieldName %];
    
    [% } %]
    
    [% for (relation in entity.relations) { %]
    @[%= relation.jpaAnnotation %]
    [% if (relation.isOwner) { %]
    @JoinColumn(name = "[%= relation.joinColumn %]")
    [% } else { %]
    (mappedBy = "[%= relation.mappedBy %]")
    [% } %]
    private [%= relation.targetType %] [%= relation.fieldName %];
    
    [% } %]
}
```

**MDE Principle**: The entity template defines the *concrete syntax* for representing persistent domain objects, derived from the *abstract syntax* in our metamodel. EGL's EOL expressions provide rich model navigation and can call helper operations for complex transformations (e.g., `entity.fields.select(f | f.isPrimaryKey)`).

## Step 4.7: Create Repository Template

❌ **NOT STARTED** - `Repository.egl` to be designed

**Template Should Include:**
- Interface extending `JpaRepository<[%= EntityName %], [%= IdType %]>`
- Package: `com.[%= groupId %].[%= projectName %].repository`
- Custom query method placeholders

## Step 4.8: Create Service Template

❌ **NOT STARTED** - `Service.egl` to be designed

**Template Should Include:**
- @Service annotation
- Constructor injection of repository
- CRUD methods: create, findById, findAll, update, delete
- Business logic placeholders

## Step 4.9: Create Controller Template

❌ **NOT STARTED** - `Controller.egl` to be designed

**Template Should Include:**
- @RestController and @RequestMapping
- Constructor injection of service
- HTTP method handlers: @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
- Proper response entities and status codes

## Step 4.10: Create Docker Compose Template

❌ **NOT STARTED** - `docker-compose.egl` to be designed

**Template Should Include:**
- Database service definition (PostgreSQL/MySQL based on `[%= databaseType %]`)
- Environment variables
- Port mapping
- Volume configuration

## Step 4.11: Create Application Class Template

❌ **NOT STARTED** - Application class template to be designed

**Template Should Include:**
- @SpringBootApplication annotation
- main() method with SpringApplication.run()
- Package: `com.[%= groupId %].[%= projectName %]`

## Step 4.12: Create README Template

❌ **NOT STARTED** - Generated project README template to be designed

**Template Should Include:**
- Project description
- Build instructions (Maven)
- Run instructions (Docker + Spring Boot)
- API endpoint documentation (generated from routes)
- Configuration options

---

# 🔄 PHASE 5: Code Generation - Transformations (Days 15-18)

**Status: ❌ NOT STARTED (~0%)**

**MDE Context**: This phase implements the complete *transformation pipeline* using the Eclipse Epsilon stack. In MDE terminology, this consists of:
1. **M2M Transformation (ETL)**: Transform PIM (BackendConfig) to PSM (Context objects)
2. **M2T Transformation (EGL)**: Transform PSM (Context) to Code (Java source files)

**Epsilon Transformation Chain:**
```
YAML file → [Flexmi/T2M] → BackendConfig model (PIM) 
         → [ETL/M2M] → Context models (PSM) 
         → [EGL/M2T] → Java source code
```

This leverages the **Epsilon family's** integrated approach where all languages share:
- **EOL** (Epsilon Object Language) as the common expression language
- Native Ecore metamodel support
- OCL-like query capabilities
- Consistent model navigation syntax

## Step 5.1: Create Generator Package Structure

❌ **NOT STARTED** - Packages to be created:

**Planned Packages:**
- `com.mde.generator` - Main generator orchestration
- `com.mde.generator.context` - Context model classes (PSM)
- `com.mde.generator.etl` - ETL transformation modules (M2M)
- `com.mde.generator.egl` - EGL template coordination (M2T)
- `com.mde.generator.writer` - File I/O utilities

**MDE Note**: This package structure reflects the *Epsilon transformation pipeline*:
1. **ETL Module** (M2M): Declarative rules transforming BackendConfig → Context objects
2. **EGL Templates** (M2T): Templates generating Java code from Context objects
3. **Generator Coordinator**: Orchestrates ETL execution followed by EGL execution

## Step 5.2: Design Generator Architecture

❌ **NOT STARTED** - Main generator class to be designed

**Epsilon-Based Transformation Pipeline:**

1. **Input**: BackendConfig model instance (M1 layer, PIM - conforms to MDE.ecore)

2. **ETL Transformation (M2M)**: 
   - Execute ETL module (`BackendConfigToContext.etl`)
   - ETL rules declaratively transform BackendConfig → Context objects
   - Creates ProjectContext, EntityContext, FieldContext, RelationContext (PSM)

3. **EGL Code Generation (M2T)**:
   - For each Context object, execute appropriate EGL template
   - Templates produce Java source code strings
   - EOL expressions in templates query Context model elements

4. **File Writing**:
   - Write generated code to filesystem
   - Create directory structure

5. **Output**: Complete Spring Boot project (target technical space)

**Key Epsilon Components:**

- **ETL Module**: Declarative transformation rules
  ```etl
  rule BackendConfigToProjectContext 
    transform bc : BackendConfig!BackendConfig
    to pc : Context!ProjectContext {
      pc.groupId = bc.project.groupId;
      pc.artifactId = bc.project.name;
      // ... more mappings
  }
  ```

- **EGL Templates**: Model-driven text generation
  ```java
  [% var context = ProjectContext.all.first(); %]
  package com.[%= context.groupId %].[%= context.artifactId %];
  // ... generated code
  ```

**MDE Principle**: This implements a classic *two-stage generative approach* where:
- Stage 1 (M2M/ETL): Platform-independent → Platform-specific model transformation
- Stage 2 (M2T/EGL): Platform-specific model → Code text generation

The metamodel remains the single source of truth throughout the pipeline.

## Step 5.3: Implement ETL Transformation Module

❌ **NOT STARTED** - ETL module to be created

**ETL (Epsilon Transformation Language) Module:**

Create `BackendConfigToContext.etl` with declarative transformation rules:

**Transformation Rules Needed:**

1. **BackendConfig → ProjectContext**
   ```etl
   rule BackendConfigToProjectContext 
     transform bc : Source!BackendConfig
     to pc : Target!ProjectContext {
       
       pc.groupId = bc.project.groupId;
       pc.artifactId = bc.project.name;
       pc.version = bc.project.version;
       pc.javaVersion = bc.project.language.mapToJavaVersion();
       pc.framework = bc.project.framework.name();
   }
   ```

2. **Table → EntityContext**
   ```etl
   rule TableToEntityContext 
     transform t : Source!Table
     to ec : Target!EntityContext {
       
       ec.tableName = t.name;
       ec.className = t.name.toEntityName(); // snake_case → PascalCase
       ec.packageName = bc.project.groupId + "." + bc.project.name;
       ec.fields = t.columns.equivalent(); // Triggers Column rules
       ec.relations = t.columns.select(c | c.relation.isDefined()).equivalent();
   }
   ```

3. **Column → FieldContext**
   ```etl
   rule ColumnToFieldContext 
     transform c : Source!Column
     to fc : Target!FieldContext {
       
       fc.columnName = c.name;
       fc.fieldName = c.name.toCamelCase(); // user_id → userId
       fc.javaType = c.type.mapToJavaType(); // DataType enum → Java type
       fc.nullable = c.nullable;
       fc.isPrimaryKey = c.primaryKey;
       fc.annotations = c.getJpaAnnotations();
   }
   ```

4. **Relation → RelationContext**
   ```etl
   rule RelationToRelationContext 
     transform r : Source!Relation
     to rc : Target!RelationContext {
       
       rc.relationType = r.relationType.name();
       rc.targetEntity = r.targetTable.equivalent(); // Gets EntityContext
       rc.joinColumn = r.determineJoinColumn();
       rc.mappedBy = r.determineMappedBy();
       rc.cascadeTypes = r.cascadeTypes.collect(ct | ct.name());
   }
   ```

**ETL Helper Operations:**
```etl
operation String toEntityName() : String {
  // Convert snake_case to PascalCase: blog_posts → BlogPost
  return self.split('_').collect(s | s.firstToUpperCase()).concat('');
}

operation String toCamelCase() : String {
  // Convert snake_case to camelCase: user_id → userId
  var parts = self.split('_');
  return parts.first() + parts.subList(1, parts.size()).collect(s | s.firstToUpperCase()).concat('');
}

operation DataType mapToJavaType() : String {
  var mapping = Map{
    "STRING" = "String",
    "INTEGER" = "Integer",
    "LONG" = "Long",
    "UUID" = "UUID",
    "BOOLEAN" = "Boolean",
    "DATE" = "LocalDate",
    "TIMESTAMP" = "LocalDateTime",
    "TEXT" = "String",
    "DOUBLE" = "Double",
    "FLOAT" = "Float"
  };
  return mapping.get(self.name());
}
```

**MDE Concept**: ETL rules are *declarative M2M transformations*. Each rule specifies:
- **Source pattern**: What model elements to match (e.g., `Source!Table`)
- **Target pattern**: What model elements to create (e.g., `Target!EntityContext`)
- **Bindings**: How to populate target attributes from source attributes

ETL automatically:
- Matches all instances of source patterns
- Creates corresponding target instances
- Tracks transformations via trace links
- Resolves cross-references using `equivalent()` operation

This is pure M2M transformation - no string manipulation or code generation yet. That happens in the EGL phase.

## Step 5.4: Implement Directory Structure Generator

❌ **NOT STARTED** - Directory generator to be created

**Target Output Structure:**
```
output/
├── src/main/java/com/{groupId}/{projectName}/
│   ├── {ProjectName}Application.java
│   ├── entity/
│   │   ├── User.java
│   │   ├── Post.java
│   │   └── ...
│   ├── repository/
│   │   ├── UserRepository.java
│   │   └── ...
│   ├── service/
│   │   ├── UserService.java
│   │   └── ...
│   └── controller/
│       ├── UserController.java
│       └── ...
├── src/main/resources/
│   └── application.yml
├── docker-compose.yml
├── pom.xml
└── README.md
```

**MDE Note**: This structure reflects standard Java/Spring Boot conventions - the *target platform conventions* that our generator must respect.

## Step 5.5: Implement EGL Template Processing Engine

❌ **NOT STARTED** - EGL coordinator to be created

**EGL Template Processor Should:**

1. **Initialize EGL Engine**:
   ```java
   EglTemplateFactory factory = new EglTemplateFactoryModuleAdapter();
   EglTemplate template = factory.load(templateUri);
   ```

2. **Prepare Model Context**:
   ```java
   IModel contextModel = loadContextModel(); // Context objects from ETL
   template.getContext().getModelRepository().addModel(contextModel);
   ```

3. **Execute Template**:
   ```java
   String generatedCode = template.process();
   ```

4. **Handle Multiple Templates**:
   - Iterate through Context model elements
   - For each EntityContext → process Entity.egl
   - For each EntityContext → process Repository.egl
   - For each EntityContext → process Service.egl
   - For each EntityContext → process Controller.egl
   - Process project-level templates once (pom.egl, application.egl)

**EGL Template Execution Flow:**
```
Context Model → EGL Engine → Template Processing → Java Code String
     ↓
  EOL Expressions query model
     ↓
  Template generates text with model values
```

**Example EGL Coordinator Code:**
```java
public class EglCodeGenerator {
    
    public void generateCode(IModel contextModel, Path outputDir) {
        EglTemplateFactory factory = new EglTemplateFactoryModuleAdapter();
        
        // Get all entities from context model
        Collection<EntityContext> entities = getAllEntities(contextModel);
        
        // Generate entity files
        for (EntityContext entity : entities) {
            EglTemplate entityTemplate = factory.load("templates/entity/Entity.egl");
            entityTemplate.populate("entity", entity);
            
            String code = entityTemplate.process();
            writeToFile(outputDir, entity.getPackagePath() + "/" + entity.getClassName() + ".java", code);
        }
        
        // Generate repositories, services, controllers similarly...
        
        // Generate project files
        EglTemplate pomTemplate = factory.load("templates/project/pom.egl");
        ProjectContext project = getProject(contextModel);
        pomTemplate.populate("context", project);
        writeToFile(outputDir, "pom.xml", pomTemplate.process());
    }
}
```

**MDE Principle**: EGL performs *pattern-based M2T transformation* where:
- Templates define static code structure (the pattern)
- EOL expressions inject dynamic content from models (the data)
- The combination produces platform-specific code

Unlike generic template engines, EGL:
- Understands EMF/Ecore models natively
- Provides rich EOL query language (extends OCL)
- Supports protected regions for partial generation
- Integrates with Epsilon's model management tools

## Step 5.6: Implement File Writers

❌ **NOT STARTED** - File writing utilities to be created

**Writers Should Handle:**
- Writing strings to files with UTF-8 encoding
- Creating directories recursively
- File conflict resolution (overwrite, skip, prompt)
- Setting appropriate file permissions (execute for scripts)
- Atomic writes to prevent partial file corruption

## Step 5.7: Implement Package Name Handling

❌ **NOT STARTED** - Package utilities to be created

**Utilities Needed:**
- Convert groupId + projectName to package path (com.example.blog → com/example/blog)
- Validate against Java reserved keywords
- Ensure valid Java identifiers
- Create corresponding directory structure

**MDE Note**: This implements the *naming conventions* transformation from conceptual model names to Java technical space constraints.

## Step 5.8: Implement Class Name Generation

❌ **NOT STARTED** - Naming transformation utilities to be created

**Naming Transformations:**
- Table name → Entity class name: `blog_posts` → `BlogPost` (snake_case → PascalCase)
- Entity → Repository: `User` → `UserRepository`
- Entity → Service: `User` → `UserService`
- Entity → Controller: `User` → `UserController`
- Column name → Field name: `user_id` → `userId` (snake_case → camelCase)

**MDE Principle**: Systematic naming transformations ensure generated code follows Java conventions while maintaining traceability back to model elements.

## Step 5.9: Implement Type Mapping

❌ **NOT STARTED** - Type mapper to be created

**DataType → Java Type Mappings:**
- STRING → java.lang.String
- INTEGER → java.lang.Integer
- LONG → java.lang.Long
- BOOLEAN → java.lang.Boolean
- DATE → java.time.LocalDate
- TIMESTAMP → java.time.LocalDateTime
- UUID → java.util.UUID
- TEXT → java.lang.String (with @Lob)
- DOUBLE → java.lang.Double
- FLOAT → java.lang.Float

**Additional Mappings:**
- Nullable columns → wrapper types (Integer)
- Non-nullable columns → can use primitives (int) or wrappers
- DataType → JPA @Column type attributes

**MDE Context**: This type mapping implements the *type system transformation* from our metamodel's abstract type system to Java's concrete type system.

## Step 5.10: Implement Relationship Mapping

❌ **NOT STARTED** - Relationship handler to be created

**Relationship Transformations:**
- ONE_TO_ONE → @OneToOne + @JoinColumn
- ONE_TO_MANY → @OneToMany(mappedBy="...")
- MANY_TO_ONE → @ManyToOne + @JoinColumn
- MANY_TO_MANY → @ManyToMany + @JoinTable

**Bidirectional Handling:**
- Determine owning side (where foreign key exists)
- Generate @JoinColumn on owning side
- Generate mappedBy attribute on inverse side

**Cascade Handling:**
- Map CascadeType enum values to JPA cascade array

## Step 5.11: Implement ZIP Archive Creation

❌ **NOT STARTED** - ZIP utility to be created

**ZIP Creation Should:**
- Collect all generated files recursively
- Create proper ZIP archive structure preserving paths
- Compress files efficiently
- Return path to generated ZIP file
- Clean up temporary files

## Step 5.12: Add Generation Logging

❌ **NOT STARTED** - Logging infrastructure to be added

**Logging Should Track:**
- Generation start/completion
- Each file being created with full path
- Warnings for potential issues (naming conflicts, etc.)
- Generation statistics (number of entities, files, lines of code)
- Performance metrics (time taken per phase)

---

# 🖥️ PHASE 6: CLI Interface (Days 19-21)

**Status: ⚠️ PARTIALLY STARTED (~5%)**

**MDE Context**: The CLI provides the *user interface* to our model-driven toolchain, allowing developers to invoke transformations and validate models from the command line.

## Step 6.1: Design CLI Commands

❌ **NOT STARTED** - Command structure to be defined

**Planned Command Structure:**
```bash
mde-backend-gen generate <yaml-file> [options]
mde-backend-gen validate <yaml-file>
mde-backend-gen version
mde-backend-gen help
```

**MDE Note**: CLI commands represent *transformation invocations* - they trigger the M2T transformation pipeline with user-specified models.

## Step 6.2: Implement Main CLI Class

⚠️ **DEPENDENCY ADDED** - Picocli dependency present in pom.xml, but not yet used

**To Be Created:**
- Main command class with @Command annotation
- Subcommands: generate, validate, version, help
- Global options: --verbose, --output-dir, --config

## Step 6.3: Implement Generate Command

❌ **NOT STARTED** - Generate subcommand to be created

**Command Should:**
- Accept YAML file path as required argument
- Accept options: --output-dir, --no-zip, --overwrite, --clean
- Use FlexmiModelLoader to parse YAML into BackendConfig
- Execute ETL transformation to create Context model
- Execute EGL templates to generate code
- Create ZIP archive unless --no-zip specified
- Print success message with output location
- Return exit code 0 on success, non-zero on failure

**MDE Principle**: This command orchestrates the complete *PIM to Code* transformation chain.

## Step 6.4: Implement Validate Command

❌ **NOT STARTED** - Validate subcommand to be created

**Command Should:**
- Accept YAML file path as required argument
- Parse YAML using FlexmiModelLoader
- Run EMF validation (structural, type, multiplicity)
- Run custom validation rules (business logic constraints)
- Print validation report (errors, warnings, info)
- Return exit code 0 if valid, non-zero if invalid

**MDE Note**: Validation ensures model instances *conform to* the metamodel and satisfy domain-specific well-formedness rules.

## Step 6.5: Implement Error Handling

❌ **NOT STARTED** - CLI error handling to be implemented

**Error Handling Should Cover:**
- File not found → clear error message
- Invalid YAML syntax → show parse errors with line numbers
- Validation errors → formatted error report
- IO errors → explain permission/disk space issues
- Unexpected exceptions → log stack trace, suggest reporting bug

## Step 6.6: Implement Help and Version

❌ **NOT STARTED** - Help/version commands to be created

**Help Command Should Display:**
- Usage information for all commands
- Option descriptions
- Example invocations
- Link to documentation

**Version Command Should Display:**
- Tool version
- EMF version
- Java version
- Dependency versions

## Step 6.7: Add Color Output

❌ **NOT STARTED** - ANSI color output to be added

**Color Scheme:**
- Success messages: Green
- Error messages: Red
- Warning messages: Yellow
- Info messages: Cyan
- Progress indicators: Blue

**Note**: Should detect terminal capabilities and disable colors on non-supporting terminals.

## Step 6.8: Implement Verbose Mode

❌ **NOT STARTED** - Verbose logging to be added

**Verbose Mode Should Show:**
- Detailed parsing steps
- ETL transformation execution
- EGL template processing per file
- File write operations
- Timing information
- Memory usage

---

# ✅ PHASE 7: Validation (Days 22-24)

**Status: ⚠️ PARTIALLY IMPLEMENTED (~30%)**

**MDE Context**: Validation ensures model instances are *well-formed* (syntactically correct per metamodel) and *meaningful* (semantically correct per domain rules). This is crucial in MDSE where models drive code generation.

## Step 7.1: Implement EMF Built-in Validation

✅ **PARTIALLY IMPLEMENTED** - EMF validation active during parsing

**Current Validation:**
- Structural validation via Flexmi (YAML structure matches metamodel) ✅
- Type validation (attributes match declared EDataTypes) ✅
- Multiplicity validation (required features present) ✅
- Enum validation (only valid literals accepted) ✅

**To Be Enhanced:**
- Explicit EMF Diagnostician invocation ⚠️
- Validation error aggregation and reporting ⚠️
- Integration with CLI validate command ⚠️

**MDE Principle**: EMF validation leverages the metamodel as a *schema* - models must conform to metamodel constraints analogous to XML documents conforming to XSD schemas.

## Step 7.2: Implement Custom Validation Rules

❌ **NOT STARTED** - Custom validators to be created

**Custom Business Rules Needed:**

1. **Primary Key Validation**
   - Each Table must have at least one Column with primaryKey=true
   - Error: "Table '{name}' has no primary key"

2. **Unique Table Names**
   - No duplicate table names within a Database
   - Error: "Duplicate table name '{name}'"

3. **Unique Column Names**
   - No duplicate column names within a Table
   - Warning: "Duplicate column name '{name}' in table '{tableName}'"

4. **Reserved Keyword Check**
   - Table/column names should avoid Java/SQL reserved words
   - Warning: "'{name}' is a Java reserved keyword"

5. **Naming Convention Validation**
   - Table names should be valid identifiers (letters, numbers, underscore)
   - Column names should follow snake_case convention
   - Warning: "'{name}' doesn't follow naming conventions"

**MDE Note**: Custom validation rules encode *domain-specific well-formedness constraints* that go beyond what the metamodel structure can express.

## Step 7.3: Implement Cross-Reference Validation

❌ **NOT STARTED** - Relationship validation to be created

**Cross-Reference Checks:**

1. **Foreign Key Target Existence**
   - Relation.targetTable must reference existing Table.name
   - Relation.targetColumn must exist in target Table
   - Error: "Target table '{name}' not found"

2. **Type Compatibility**
   - Source column type should match target column type for relationships
   - Warning: "Type mismatch in relation: {sourceType} → {targetType}"

3. **Circular Dependency Detection**
   - Detect cycles in relationship graph
   - Error: "Circular dependency detected: {table1} → {table2} → {table1}"

4. **Orphaned Relations**
   - Relations should have valid cascade types
   - Warning: "Relation without cascade type may cause runtime issues"

**MDE Principle**: Cross-reference validation ensures model *consistency* - all inter-element references are valid and semantically meaningful.

## Step 7.4: Implement API Route Validation

❌ **NOT STARTED** - API validation to be created

**Route Validation Rules:**

1. **Entity Reference Validation**
   - Route.entity must match an existing Table.name
   - Error: "Route references non-existent entity '{name}'"

2. **HTTP Method Validation**
   - Route must have at least one HttpMethod
   - Error: "Route has no HTTP methods defined"

3. **Duplicate Route Detection**
   - No duplicate combinations of entity + methods
   - Warning: "Duplicate route definition for entity '{name}'"

## Step 7.5: Create Validation Error Messages

❌ **NOT STARTED** - Error message formatting to be enhanced

**Error Message Template:**
```
[SEVERITY] Location: {path}
Problem: {description}
Suggestion: {howToFix}
Example: {correctUsage}
```

**Severity Levels:**
- ERROR: Must be fixed before generation
- WARNING: Should be reviewed, generation proceeds
- INFO: Best practice suggestions

**MDE Note**: Error messages should reference *metamodel concepts* (EClass names, EAttribute names) to maintain traceability between errors and model elements.

## Step 7.6: Implement Validation Reporter

❌ **NOT STARTED** - Reporter to be created

**Reporter Should:**
- Collect all validation issues (errors, warnings, info)
- Group by severity level
- Format for CLI output (human-readable)
- Provide JSON output option for tool integration
- Generate validation report files
- Track validation statistics

## Step 7.7: Create Validation Plugins

❌ **NOT STARTED** - Plugin architecture to be designed

**Plugin System Would Allow:**
- Custom validation rules without modifying core
- Domain-specific validators
- Organization-specific conventions
- Third-party validator contributions

---

# 🧪 PHASE 8: Testing (Days 25-27)

**Status: ⚠️ STARTED (~15%)**

**MDE Context**: Testing in MDSE involves validating both the *metamodel* (M2 layer), *models* (M1 layer), and *generated code* (M0 layer). Each layer requires different testing strategies.

## Step 8.1: Create Test Resources

⚠️ **PARTIALLY COMPLETE** - Some examples exist

**Current Test Resources:**
- `examples/minimal-example.yaml` ✅
- `examples/blog-example.yaml` ✅

**Still Needed:**
- Complex example with all relationship types ⚠️
- Invalid YAML examples (for negative testing) ❌
- Edge case examples (empty lists, all optional fields, etc.) ❌
- Large-scale example (50+ tables) ❌

## Step 8.2: Unit Test Parser

✅ **PARTIALLY COMPLETE** - Basic parser tests exist

**Existing Tests in FlexmiModelLoaderTest:**
- testLoadMinimalExample() ✅
- testLoadBlogExample() ✅
- testMissingFile() ✅

**Additional Tests Needed:**
- Invalid enum value (should report line number) ⚠️
- Missing required fields ⚠️
- Type mismatches ⚠️
- Malformed YAML syntax ⚠️
- Empty YAML file ⚠️
- Invalid cross-references ⚠️

**MDE Testing Principle**: Parser tests validate the *T2M transformation* - ensuring YAML text is correctly transformed into model instances that conform to the metamodel.

## Step 8.3: Unit Test Validators

❌ **NOT STARTED** - Validator tests to be created

**Test Categories:**
- Primary key validation (pass and fail cases)
- Unique name validation
- Cross-reference validation
- Reserved keyword detection
- Each custom validation rule

**For Each Rule:**
- Test case that should pass ✓
- Test case that should fail ✗
- Edge cases (boundary conditions)

## Step 8.4: Unit Test ETL Transformations

❌ **NOT STARTED** - ETL transformation tests to be created

**ETL Tests Should Verify:**
- Type conversions (DataType → Java type)
- Name transformations (snake_case → camelCase, PascalCase)
- Relationship mappings (RelationType → JPA annotations)
- Helper operations work correctly
- Trace links are created properly

**MDE Principle**: ETL tests validate the *M2M transformation* from PIM (BackendConfig) to PSM (Context objects).

## Step 8.5: Integration Test Generator

❌ **NOT STARTED** - End-to-end generator tests to be created

**Integration Test Should:**
1. Start with valid YAML file
2. Parse to BackendConfig model (Flexmi)
3. Transform to Context model (ETL)
4. Validate models
5. Generate code (EGL)
6. Verify all expected files created
7. Verify file contents match expectations
8. Verify generated project structure is correct

**MDE Note**: Integration tests validate the complete *PIM → PSM → Code* transformation chain.

## Step 8.6: Test Generated Projects

❌ **NOT STARTED** - Generated code tests to be created

**Generated Project Tests:**
1. Maven build succeeds (`mvn clean compile`)
2. No compilation errors
3. Spring Boot application starts successfully
4. Database schema creation works
5. API endpoints are accessible
6. Basic CRUD operations work via REST API

**MDE Principle**: Testing generated code validates the *M0 layer* - the running system must behave correctly as an instance of the generated application model.

## Step 8.7: Test CLI Interface

❌ **NOT STARTED** - CLI tests to be created

**CLI Test Cases:**
- Help command displays usage
- Version command shows version info
- Generate command with valid input succeeds
- Generate command with invalid input shows errors
- Validate command reports errors correctly
- Exit codes are appropriate (0 for success, non-zero for errors)

## Step 8.8: Create End-to-End Tests

❌ **NOT STARTED** - Full workflow tests to be created

**Complete Workflow Test:**
1. Create test YAML configuration
2. Run CLI generate command
3. Extract generated ZIP
4. Execute `mvn clean package`
5. Start Docker database container
6. Run Spring Boot application
7. Execute HTTP requests to API
8. Verify CRUD operations return expected results
9. Verify data persistence in database
10. Shutdown and cleanup

**MDE Testing Insight**: E2E tests validate the entire *model-driven software development lifecycle* from model to running system.

---

# 📦 PHASE 9: Example Projects & Documentation (Days 28-30)

**Status: ⚠️ PARTIALLY STARTED (~20%)**

## Step 9.1: Create Example YAML Files

⚠️ **PARTIALLY COMPLETE** - 2 of 4 planned examples exist

**Existing Examples:**
1. ✅ **minimal-example.yaml** - Simplest configuration (1 table)
2. ✅ **blog-example.yaml** - Users, Posts, Comments (3 tables with relationships)

**Still Needed:**
3. ❌ **E-commerce example** - Products, Categories, Orders, OrderItems (many-to-many relationships)
4. ❌ **Social network example** - Users, Posts, Comments, Likes, Friendships (complex relationships)

**MDE Note**: Examples demonstrate different *model patterns* and serve as both documentation and test cases. They are concrete instances (M1) of our metamodel (M2).

## Step 9.2: Generate Example Projects

❌ **NOT STARTED** - Cannot generate until generator is implemented

**When Generator Ready:**
- Generate code for each example ⚠️
- Verify all examples compile ⚠️
- Include generated projects in distribution ⚠️
- Document differences between examples ⚠️

## Step 9.3: Write User Documentation

❌ **NOT STARTED** - User docs to be created

**User Documentation Should Cover:**

1. **Installation Guide**
   - Prerequisites (Java 17, Maven)
   - Download and installation
   - Verification steps

2. **Quick Start Tutorial**
   - Creating first YAML file
   - Running generator
   - Building generated project
   - Testing the API

3. **YAML Schema Reference**
   - Complete metamodel documentation
   - All EClasses and their attributes
   - All EEnums and their literals
   - Multiplicity and required fields

4. **Configuration Guide**
   - Supported data types (DataType enum)
   - Relationship types (RelationType enum)
   - Cascade options (CascadeType enum)
   - Framework options (Framework enum)

5. **CLI Reference**
   - All commands and options
   - Examples of common workflows
   - Troubleshooting guide

**MDE Principle**: Documentation should explain the *modeling concepts* (metamodel) rather than implementation details, making it accessible to domain experts.

## Step 9.4: Write Developer Documentation

❌ **NOT STARTED** - Developer docs to be created

**Developer Documentation Should Cover:**

1. **Architecture Overview**
   - Four-layer metamodeling stack explanation
   - Package structure and responsibilities
   - Epsilon transformation pipeline description

2. **Metamodel Guide**
   - Ecore metamodel walkthrough
   - EClass inheritance hierarchy
   - Relationship between concepts
   - Constraints and well-formedness rules

3. **Extension Points**
   - How to add new EGL templates
   - How to extend ETL transformations
   - How to add new database types (extend DatabaseType enum)
   - How to add new frameworks (extend Framework enum)
   - How to add custom validators
   - How to add new data types (extend DataType enum)

4. **Contributing Guidelines**
   - Code style conventions
   - Pull request process
   - Testing requirements
   - Documentation standards

**MDE Context**: Developer documentation explains the *metamodel-driven architecture* enabling contributions that respect the MDE principles.

## Step 9.5: Create Tutorial

❌ **NOT STARTED** - Step-by-step tutorial to be created

**Tutorial Steps:**
1. Install the tool
2. Create a simple YAML file (blog with users and posts)
3. Run the generator
4. Explore generated code structure
5. Build with Maven
6. Start database with Docker
7. Run Spring Boot application
8. Test CRUD operations via curl/Postman
9. Modify YAML to add new entity
10. Regenerate and see changes

**MDE Teaching**: Tutorial demonstrates the *model-driven development workflow* - edit model, regenerate, test - highlighting productivity benefits.

## Step 9.6: Create Video/Screencast (Optional)

❌ **NOT STARTED** - Optional multimedia content

**Screencast Could Show:**
- Live demonstration of creating YAML configuration
- Running generator and exploring output
- Building and running generated project
- Making changes and regenerating
- Testing API endpoints

## Step 9.7: Write Academic Report

❌ **NOT STARTED** - Academic documentation to be created

**Academic Report Should Document:**

1. **MDE Principles Applied**
   - Four-layer metamodeling stack usage
   - Separation of abstract and concrete syntax
   - Model-to-model and model-to-text transformations
   - Metamodel-driven validation

2. **Design Decisions**
   - Why Flexmi over manual parser (metamodel-driven parsing)
   - Why Eclipse Epsilon stack (integrated MDE toolchain)
   - Why ETL for M2M transformations (declarative, trace-based)
   - Why EGL for M2T generation (metamodel-aware templates)
   - Why Ecore/EMF (mature metamodeling framework)
   - Rationale for metamodel structure

3. **Transformation Strategy**
   - PIM design (BackendConfig metamodel)
   - PSM design (Context metamodel)
   - M2M approach (ETL rules with declarative semantics)
   - M2T approach (EGL template-based code generation)
   - Traceability maintenance via ETL trace links

4. **Comparison with Alternatives**
   - Manual coding vs. model-driven approach
   - DSL textual syntax (Xtext) vs. YAML + Flexmi
   - Transformation tools: Epsilon (ETL/EGL) vs. ATL/Acceleo vs. QVT
   - Template engines: EGL vs. Acceleo vs. Xtend vs. generic engines
   - Other backend generators (JHipster, etc.)

5. **Evaluation**
   - Productivity gains measurement
   - Code quality metrics
   - Maintainability assessment
   - Extensibility evaluation

**MDE Academic Context**: Report demonstrates understanding of MDSE principles, metamodeling, and transformation techniques.

---

# 🚀 PHASE 10: Packaging & Distribution (Days 31-33)

**Status: ❌ NOT STARTED (~0%)**

## Step 10.1: Configure Maven Shade Plugin

❌ **NOT STARTED** - Maven Shade plugin to be configured

**Plugin Configuration Needed:**
- Create fat JAR with all dependencies
- Set main class: CLI entry point
- Minimize JAR size by shading unused classes
- Relocate dependencies to avoid version conflicts
- Include/exclude specific dependencies

**MDE Note**: The packaged JAR is the *tool distribution* - it encapsulates our entire MDSE toolchain for end-user consumption.

## Step 10.2: Create Executable Script

❌ **NOT STARTED** - Shell/batch scripts to be created

**Scripts Needed:**

**Unix/Linux** (`mde-backend-gen`):
```bash
#!/bin/bash
java -jar mde-backend-gen.jar "$@"
```

**Windows** (`mde-backend-gen.bat`):
```batch
@echo off
java -jar mde-backend-gen.jar %*
```

**Both Should:**
- Check Java version (require Java 17+)
- Set appropriate memory options
- Pass all arguments to JAR
- Return appropriate exit code

## Step 10.3: Create Installation Package

❌ **NOT STARTED** - Distribution package to be created

**Distribution Should Include:**
- Executable JAR (`mde-backend-gen.jar`)
- Wrapper scripts (Unix and Windows)
- README with installation instructions
- LICENSE file
- Example YAML files (minimal, blog, e-commerce, social)
- PDF documentation
- CHANGELOG

## Step 10.4: Test on Different Platforms

❌ **NOT STARTED** - Cross-platform testing to be performed

**Test Platforms:**
- Linux: Ubuntu 22.04, Fedora 38
- macOS: macOS 13 (Ventura), macOS 14 (Sonoma)
- Windows: Windows 10, Windows 11
- Java versions: 17, 21

**Verify:**
- Installation succeeds
- CLI commands work
- Generated projects build
- Generated projects run

## Step 10.5: Create GitHub Repository

❌ **NOT STARTED** - Repository to be set up

**Repository Structure:**
```
mde-backend-generator/
├── src/                    # Source code
├── model/                  # Ecore metamodel
├── examples/               # Example YAML files
├── templates/              # EGL templates
├── docs/                   # Documentation
├── .github/
│   └── workflows/          # CI/CD pipelines
├── pom.xml
├── README.md
├── LICENSE
└── CONTRIBUTING.md
```

## Step 10.6: Set Up CI/CD

❌ **NOT STARTED** - GitHub Actions workflow to be created

**CI/CD Pipeline Should:**
1. Run on push to main branch
2. Run on pull requests
3. Execute all unit tests
4. Execute integration tests
5. Build executable JAR
6. Run end-to-end tests
7. Create release artifacts on tag
8. Publish to Maven Central (optional)
9. Update documentation site

## Step 10.7: Write Release Notes

❌ **NOT STARTED** - Release documentation to be created

**Release Notes Should Include:**
- Version number
- Release date
- New features added
- Bug fixes
- Known limitations
- Breaking changes from previous version
- Migration guide (if applicable)
- Future roadmap

---

# 🔮 PHASE 11: Future Extensions (Beyond MVP)

**Status: 📋 PLANNED**

**MDE Context**: Extensions demonstrate the *extensibility* of metamodel-driven approaches - new features can be added by extending the metamodel and updating transformations, without redesigning the entire system.

## Step 11.1: Plan Phase 2 Features

📋 **FUTURE CONSIDERATIONS:**

**Priority Extensions:**
1. **MySQL Support** - Add MYSQL to DatabaseType enum, update templates
2. **MongoDB Support** - Add MONGODB to DatabaseType enum, create NoSQL templates
3. **Authentication Scaffolding** - Add Security EClass to metamodel (JWT, OAuth2 configs)
4. **OpenAPI Documentation** - Generate Swagger/OpenAPI specs from API configuration
5. **GraphQL Support** - Add GraphQL to Api options, create GraphQL templates
6. **Pagination Support** - Add Pagination EClass with page size, sort options
7. **Search/Filtering** - Add QuerySpec EClass defining search capabilities
8. **Audit Fields** - Add AuditableEntity with createdAt, updatedAt, createdBy, updatedBy

**MDE Principle**: Each extension involves three steps:
1. Extend metamodel (add new EClasses/EAttributes/EEnums)
2. Update ETL rules (transform new concepts)
3. Update EGL templates (generate code for new concepts)
4. Maintain backward compatibility (existing models still valid)

## Step 11.2: Plan Framework Extensions

📋 **FRAMEWORK SUPPORT:**

**Additional Frameworks:**
- Quarkus framework support (extend Framework enum)
- Micronaut framework support (extend Framework enum)
- Kotlin language support (extend Language enum, adjust templates)
- Gradle build tool (alternative to Maven, add BuildTool enum)

**MDE Note**: Framework extensions require new template sets but reuse the same metamodel, demonstrating *separation of concerns* between domain model (PIM) and platform (PSM).

## Step 11.3: Plan Advanced Features

📋 **ADVANCED CAPABILITIES:**

**Potential Features:**
- Custom query methods (add QueryMethod EClass)
- DTO generation (add DTO EClass separate from Entity)
- MapStruct mapper generation (add Mapper EClass)
- Integration test generation (extend testing templates)
- Performance optimizations (add Index EClass, caching annotations)
- Caching configuration (add CacheConfig EClass)
- Message queue integration (add MessageQueue EClass for Kafka/RabbitMQ)
- Event sourcing patterns (add Event and EventStore EClasses)

**MDE Principle**: Advanced features extend the *domain model* (metamodel) with richer concepts, automatically gaining validation, parsing, and tooling support.

## Step 11.4: Plan Tooling Enhancements

📋 **TOOLING IMPROVEMENTS:**

**Tool Ecosystem:**
- VS Code extension for YAML editing with autocomplete
- Syntax highlighting for YAML DSL
- IDE auto-completion based on metamodel
- Visual metamodel editor (Eclipse Sirius/GMF based)
- Web-based configuration UI (form-based model creation)
- Migration tool for schema evolution (model transformation)
- Diff tool for YAML configurations
- Model validator IDE plugin

**MDE Ecosystem**: Tools leverage the *metamodel* as specification - autocomplete reads metamodel structure, validation uses metamodel constraints, editors use metamodel for UI generation.

---

# 📊 Quality Checklist

**Current Project Status: ~40% Complete**

## Functionality
- [x] Parses valid YAML correctly (via Flexmi)
- [ ] Generates compilable Spring Boot projects
- [ ] Generated projects run successfully
- [ ] All CRUD operations work
- [ ] Relationships are properly implemented
- [ ] Docker setup works
- [ ] CLI is user-friendly

## Code Quality
- [x] Code follows Java conventions (EMF-generated code)
- [x] Proper error handling in parser
- [ ] Comprehensive logging
- [ ] No hardcoded values
- [ ] Configurable options
- [x] Clean separation of concerns (metamodel, parser, generator)

## Testing
- [x] Unit tests for parser (3 tests)
- [ ] Unit tests for all components
- [ ] Integration tests for workflows
- [ ] Test coverage > 80%
- [x] Some tests passing (parser tests)
- [ ] Edge cases covered

## Documentation
- [ ] User guide complete
- [ ] API documentation
- [x] Code comments (EMF-generated)
- [ ] Academic report
- [x] Examples working (2 YAML files)

## Academic Requirements (MDE)
- [x] Demonstrates MDE principles (metamodeling, conformsTo)
- [x] Shows meta-modeling understanding (Ecore metamodel)
- [x] Documents design decisions (Flexmi, Epsilon stack)
- [ ] Compares approaches
- [ ] Discusses trade-offs

---

# 🎓 Key Learning Outcomes

**By completing this project, you will have learned:**

## MDE Fundamentals
1. **Model-Driven Engineering**: Practical application of MDE principles
   - Four-layer metamodeling architecture (M0-M3)
   - conformsTo relationships between layers
   - Models as first-class artifacts

2. **Meta-Modeling**: Using Eclipse EMF and Ecore
   - Defining domain-specific metamodels
   - EClasses, EAttributes, EReferences, EEnums
   - Reflexive metamodeling (Ecore describes itself)

3. **DSL Design**: Creating domain-specific modeling languages
   - Abstract syntax (metamodel) vs. concrete syntax (YAML)
   - Metamodel as language definition
   - Technical spaces (modelware, grammarware)

## Transformations
4. **Model Transformations**: Multi-stage transformation pipelines using Epsilon
   - Text-to-Model (T2M): YAML → BackendConfig model (via **Flexmi**)
   - Model-to-Model (M2M): BackendConfig → Context objects using **ETL** (PIM → PSM)
   - Model-to-Text (M2T): Context → Java code using **EGL**

5. **ETL (Epsilon Transformation Language)**: Declarative M2M transformations
   - Rule-based transformation specification
   - Automatic trace link management
   - OCL-based model queries (via EOL)
   - Lazy vs. eager rule execution

6. **EGL (Epsilon Generation Language)**: Model-aware code generation
   - Template-based M2T transformations
   - EOL expressions for model navigation
   - Protected regions for partial generation
   - Integration with Epsilon model management

7. **Parser Implementation**: Metamodel-driven parsing
   - Flexmi's metamodel-based YAML parsing
   - Automatic validation during parsing
   - Type-safe model instance creation

## Validation & Quality
8. **Validation Frameworks**: Model and data validation
   - EMF's built-in validation (structural, type, multiplicity)
   - Custom domain-specific validation rules
   - Well-formedness constraints

9. **Software Architecture**: Layered design patterns
   - Metamodel layer (M2)
   - Model layer (M1)
   - Code layer (M0)
   - Transformation layer

## Platform Technologies
10. **Java Enterprise**: Spring Boot, JPA, REST APIs
    - Understanding target platform requirements
    - Platform-specific model (PSM) design
    - Mapping domain concepts to implementation technologies

11. **Tool Development**: CLI design and implementation
    - Command-line interface patterns
    - User experience in model-driven tools
    - Tool integration and automation

## Advanced MDE Concepts
12. **Technical Spaces**: Modelware vs. Grammarware
    - Model representations (Ecore, XMI)
    - Grammar representations (EBNF, YAML)
    - Bridges between technical spaces

13. **Model Management**: Handling models as software artifacts
    - Model persistence and serialization
    - Cross-reference resolution
    - Model validation and verification

14. **Generative Programming**: Automation through models
    - Productivity gains from generation
    - Maintaining generated vs. manual code
    - Protected regions and regeneration strategies

---

# 📚 MDE Concepts Demonstrated

**This project exemplifies key MDSE principles:**

## Metamodeling
- **Four-Layer Stack**: M0 (runtime data) ← M1 (YAML models) ← M2 (MDE.ecore) ← M3 (Ecore)
- **conformsTo Relationship**: Each layer conforms to the layer above
- **Reflexive Metamodel**: Ecore describes itself, enabling tool generation

## Model Transformations
- **Exogenous Transformations**: Between different metamodels (YAML → Java)
- **Transformation Chain**: T2M (Flexmi) → M2M (ETL) → M2T (EGL)
- **Eclipse Epsilon Stack**: Integrated family of transformation languages
  - **Flexmi**: Metamodel-driven YAML/XML parsing
  - **ETL**: Declarative M2M with automatic trace links
  - **EGL**: Template-based M2T with EOL queries
  - **EOL**: Common expression language (extends OCL)
- **Trace-Based Transformation**: ETL maintains source-to-target links
- **Pattern-Based Generation**: EGL templates define output structure

## Domain-Specific Languages
- **Abstract Syntax**: Defined by MDE.ecore metamodel
- **Concrete Syntax**: YAML notation for user-facing DSL
- **Language Suite**: Multiple notations possible (future: visual editor)

## Platform-Independent/Specific Models
- **PIM**: BackendConfig model (platform-agnostic domain model)
- **PSM**: Context model (Spring Boot specific)
- **Code**: Java source files (JVM bytecode platform)

## Separation of Concerns
- **Domain vs. Platform**: Business logic vs. technical implementation
- **Model vs. Code**: High-level specification vs. low-level implementation
- **Static vs. Dynamic**: Template structure vs. model-specific data

---

# 🔄 Current Implementation Status Summary

## ✅ Completed Phases (40%)
1. **Project Setup** - Maven, Epsilon dependencies, directory structure
2. **Metamodel Definition** - Complete Ecore metamodel with 8 EClasses, 7 EEnums
3. **Model Code Generation** - All EMF-generated Java interfaces and implementations
4. **YAML Parsing** - Flexmi-based metamodel-driven parsing
5. **Basic Testing** - Parser unit tests with example files

## ⚠️ Partially Complete (10%)
1. **Examples** - 2 of 4 planned YAML examples
2. **CLI Dependencies** - Picocli added but not implemented
3. **Templates Directory** - Created but empty
4. **Validation** - EMF validation working, custom rules pending

## ❌ Not Started (50%)
1. **Context Metamodel** - PSM layer metamodel not created
2. **ETL Transformations** - No M2M rules from BackendConfig to Context
3. **EGL Templates** - No M2T code generation templates created
4. **Code Generator** - No transformation engine implementation
5. **CLI Commands** - No command implementation
6. **Custom Validation** - No business rule validators
7. **Documentation** - No user/developer documentation
8. **Packaging** - No executable JAR configuration
9. **CI/CD** - No automated testing/deployment

## 🎯 Next Priority Steps

**To Achieve Minimal Viable Product (MVP):**

1. **Create Context Metamodel** (Phase 4)
   - Define Context.ecore (PSM layer)
   - Generate Context model code with EMF
   - ProjectContext, EntityContext, FieldContext, RelationContext

2. **Create ETL Module** (Phase 5)
   - Write BackendConfigToContext.etl
   - Define transformation rules (Table → EntityContext, etc.)
   - Implement helper operations (naming transformations, type mappings)

3. **Create EGL Templates** (Phase 4)
   - Entity.egl, Repository.egl, Service.egl, Controller.egl
   - pom.egl, application.egl
   - Docker Compose template

4. **Implement Generator** (Phase 5)
   - ETL execution engine
   - EGL template processor
   - File writing utilities
   - Integration coordinator

5. **Implement CLI** (Phase 6)
   - Generate command with full pipeline
   - Basic error handling and output
   - Help and version commands

6. **Testing** (Phase 8)
   - Integration tests for Flexmi → ETL → EGL pipeline
   - Test generated projects compile and run

**Estimated Time to MVP: 3-4 additional weeks**

---

# 🔧 Eclipse Epsilon Technology Stack

**This project uses the Eclipse Epsilon family of MDE languages for all model transformations:**

## **Tool Selection:**

| Transformation Type | Technology | Purpose |
|---------------------|------------|---------|
| **M3 Metamodel** | Ecore (EMF) | Meta-metamodel (reflexive) |
| **M2 Metamodel** | Ecore editors | Define BackendConfig and Context metamodels |
| **T2M Parsing** | **Flexmi** (Epsilon) | YAML → BackendConfig model |
| **M2M Transform** | **ETL** (Epsilon) | BackendConfig → Context model |
| **M2T Generation** | **EGL** (Epsilon) | Context model → Java code |
| **Query Language** | **EOL** (Epsilon) | OCL-extended model queries |

## **Why Eclipse Epsilon Stack?**

1. **Integrated Ecosystem**: Flexmi, ETL, and EGL are all part of the Epsilon family
   - Shared EOL (Epsilon Object Language) for queries
   - Consistent syntax and concepts across all tools
   - Single dependency management

2. **MDE-Specific**: All Epsilon tools are designed for model-driven engineering
   - Metamodel-aware transformations
   - OCL-based querying (via EOL)
   - Built-in traceability support
   - Protected regions for partial generation

3. **Practical Benefits**:
   - Already using Flexmi successfully for parsing
   - Easier learning curve (one language family)
   - Better tool integration
   - Active Eclipse community
   - Mature and well-documented

4. **Academic Recognition**: The Eclipse Epsilon project is recognized in MDE literature as a comprehensive model management platform, providing alternatives to other transformation approaches like ATL/Acceleo.

## **Epsilon Language Relationships:**

```
┌─────────────────────────────────────┐
│   Eclipse Epsilon Platform          │
│                                      │
│  ┌────────────────────────────┐    │
│  │  EOL (Epsilon Object Lang)  │    │
│  │  - OCL-extended queries     │    │
│  │  - Model navigation         │    │
│  └────────────────────────────┘    │
│           ▲        ▲        ▲       │
│           │        │        │       │
│  ┌────────┴──┐ ┌──┴─────┐ ┌┴────┐ │
│  │  Flexmi   │ │  ETL   │ │ EGL │ │
│  │  (T2M)    │ │ (M2M)  │ │(M2T)│ │
│  └───────────┘ └────────┘ └─────┘ │
└─────────────────────────────────────┘
```

---

**This README documents the Model-Driven Engineering Backend Generator project using the Eclipse Epsilon stack for a complete, integrated transformation pipeline from YAML models to working Spring Boot applications.**
