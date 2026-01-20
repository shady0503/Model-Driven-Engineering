# MDE Codebase Documentation

This document provides a comprehensive overview of every file in the Model-Driven Engineering (MDE) project.

## Root Directory

| File | Description |
|------|-------------|
| `Dockerfile` | Configuration for containerizing the MDE backend application. |
| `docker-compose.yml` | Setup for running the backend and database services together. |
| `mvnw`, `mvnw.cmd` | Maven wrapper scripts for consistent builds across environments. |
| `pom.xml` | Main Maven project configuration, defining dependencies (EMF, Epsilon, Picocli, etc.). |
| `readme.md` | Modernized project overview and quick start guide. |
| `Phase4.md` | Detailed guide and development log for the code generation phase. |
| `build_output.txt` | Captured output from previous build processes. |
| `rewrite_authors.py` | Utility script to modify author information in the Git history. |
| `plugin.xml`, `plugin.properties`, `build.properties` | Eclipse plugin configuration files for Epsilon integration. |
| `.gitignore` | Defines files and directories to be ignored by Git. |
| `.project`, `.classpath` | Eclipse-specific project configuration files. |

## 🏗 Backend (`src/main/java/com/mde`)

The backend is built with Spring Boot and leverages the Eclipse Epsilon stack for model transformations.

### Core Application
- `MdeWebApplication.java`: Main entry point for the Spring Boot application.

### CLI (`cli`)
- `MdeGenCli.java`: Main CLI entry point using Picocli.
- `GenerateCommand.java`: Implements the `generate` command for project generation.
- `ValidateCommand.java`: Implements the `validate` command for model verification.
- `ProjectGenerationController.java`: Central controller orchestrating the loading, validation, and generation workflow.
- `CliExceptionHandler.java`: Global exception handler for CLI commands.
- `ColorOutput.java`, `ConsoleSymbols.java`, `ExitCode.java`: Utilities for CLI display and status codes.

### Model Loading (`loader`)
- `FlexmiModelLoader.java`: Main loader for YAML files using Eclipse Flexmi. It transforms YAML text into an EMF model based on the `MDE.ecore` metamodel.
- `FlexmiModelLoaderWithValidation.java`: Extends the loader with immediate EMF diagnostic validation after loading.
- `ModelPackageRegistrar.java`: Registers Ecore packages and Flexmi resource factories globally, ensuring EMF can resolve URIs.
- `LoadException.java`: Custom exception for model loading failures, providing detailed error messages.

### Model Validation (`validation`)
- `ModelValidationEngine.java`: Orchestrates multiple validators against a loaded model.
- `ModelValidator.java`: Interface for individual model validation rules.
- `ValidationResult.java`: Encapsulates the results (errors/warnings) of a validation run.
- **Specific Validators**: `ApiRouteEntityValidator.java`, `ForeignKeyTargetTableValidator.java`, `PrimaryKeyValidator.java`, `UniqueTableNamesValidator.java`, etc. These enforce domain-specific constraints.

### Code Generation (`generator`)
- `CodeGenerator.java`: Main entry point for the generation process.
- `Main.java`: Internal entry point for the generator.
- **Context Model (`generator/Context`)**: Defines the Platform-Specific Model (PSM) used for code generation. Includes interfaces and implementations like `ProjectContext`, `EntityContext`, `FieldContext`, and `RelationContext`.
- **Transformation Engines**:
    - `etl/ETLTransformationEngine.java`: Executes Epsilon Transformation Language (ETL) for M2M (PIM to PSM).
    - `egl/EGLTemplateEngine.java`: Executes Epsilon Generation Language (EGL) for M2T (PSM to Source Code).

## 🎨 Frontend (`mde-studio`)

A React-based web interface for visual model design.

- `src/App.tsx`: Main application component for the visual editor.
- `src/main.tsx`: React entry point.
- `src/nodes/TableNode.tsx`: Custom React Flow node for representing database tables visually in the editor.
- `src/index.css`, `src/App.css`: Styling for the web interface, incorporating Tailwind CSS.

## 🛠 Scripts (`bin`)

Helper scripts for installation, distribution, and running the MDE engine.

| File | Description |
|------|-------------|
| `mde-gen.sh`, `mde-gen.bat` | Platform-specific shell scripts to run the MDE engine from the command line. |
| `install.ps1`, `setup-path.ps1` | PowerShell scripts for environment setup and registering the MDE CLI. |
| `create-distribution.ps1` | Packages the application into a distributable format. |
| `uninstall-path.ps1` | Cleans up MDE-related environment variables and paths. |

## 📐 Models (`model`)

Contains the Ecore metamodels that define the project's structure.

- `MDE.ecore`: The core metamodel (PIM) defining `BackendConfig`, `Project`, `Table`, `Column`, etc.
- `Context.ecore`: The generation-specific metamodel (PSM).
- `*.genmodel`: EMF generator models for producing Java code from Ecore.

## 📄 Resources (`src/main/resources`)

- `etl/BackendConfigToContext.etl`: The M2M transformation logic mapping the user model to the generation context.
- `templates/`: EGL templates for generating various project files (pom.xml, Entities, Repositories, Services, Controllers, etc.).

## 🧪 Examples (`examples`)

Sample YAML configurations demonstrating the platform's capabilities.
- `blog-example.yaml`: A standard blog platform configuration.
- `minimal-example.yaml`: A simple project setup.
- `full-relations-test.yaml`: Deep dive into complex relationships.

## 📦 Generated Output (`output`)

The results of the code generation process are stored here.
- `full-system/`: A comprehensive Spring Boot project generated for testing the entire feature set.
- `many-to-many-test/`: Focused output for validating complex relationship generation.
