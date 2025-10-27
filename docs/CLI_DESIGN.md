# MDE Backend Generator - CLI Design Specification

## Overview

Command-line interface for the Model-Driven Backend Code Generator using Picocli framework.

---

## Command Structure

```
mde-gen [GLOBAL-OPTIONS] COMMAND [COMMAND-OPTIONS] [ARGUMENTS]
```

### Global Options (Apply to all commands)

| Option | Short | Type | Default | Description |
|--------|-------|------|---------|-------------|
| `--verbose` | `-v` | boolean | false | Enable detailed logging output |
| `--help` | `-h` | boolean | - | Show help message and exit |
| `--version` | `-V` | boolean | - | Show version information and exit |

---

## Commands

### 1. `generate` - Generate Spring Boot Project

Generate a complete Spring Boot project from a YAML model file.

**Syntax:**
```bash
mde-gen generate <yaml-file> [OPTIONS]
```

**Arguments:**
- `<yaml-file>` (required): Path to the YAML model file

**Options:**

| Option | Short | Type | Default | Description |
|--------|-------|------|---------|-------------|
| `--output-dir` | `-o` | path | `./generated-project` | Directory where project will be generated |
| `--overwrite` | | boolean | false | Overwrite existing files without prompting |
| `--clean` | | boolean | false | Clean output directory before generation |
| `--no-zip` | | boolean | false | Don't create ZIP archive of generated project |
| `--skip-validation` | | boolean | false | Skip validation before generation |

**Examples:**
```bash
# Basic generation
mde-gen generate examples/healthcare-system.yaml

# Generate with custom output directory
mde-gen generate examples/blog.yaml -o ../my-blog-api

# Generate with overwrite and clean
mde-gen generate examples/trading.yaml -o ./output --overwrite --clean

# Verbose generation
mde-gen -v generate examples/social-media.yaml
```

**Exit Codes:**
- `0` - Success
- `1` - YAML file not found
- `2` - Validation failed
- `3` - Generation failed
- `4` - IO error (permissions, disk space)

**Output:**
```
╔════════════════════════════════════════════════════════╗
║     MODEL-DRIVEN BACKEND CODE GENERATOR               ║
║     Eclipse Epsilon Transformation Pipeline           ║
╚════════════════════════════════════════════════════════╝

Input YAML:     examples/healthcare-system.yaml
Output Project: generated-project/healthcare-api

┌─────────────────────────────────────────────────────┐
│ PHASE 1: Parsing & Validation                      │
└─────────────────────────────────────────────────────┘
✓ YAML parsed successfully
✓ Validation passed
  Project: HealthcareAPI
  Tables:  6

┌─────────────────────────────────────────────────────┐
│ PHASE 2: Model Transformation (M2M)                │
└─────────────────────────────────────────────────────┘
✓ ETL transformation complete
  Entities: 6
  Fields:   56
  Relations: 9

┌─────────────────────────────────────────────────────┐
│ PHASE 3: Code Generation (M2T)                     │
└─────────────────────────────────────────────────────┘
✓ Generated 6 entities
✓ Generated 6 repositories
✓ Generated 6 services
✓ Generated 6 controllers
✓ Generated configuration files
✓ Generated Docker Compose
✓ Generated README.md

╔════════════════════════════════════════════════════════╗
║            ✓ GENERATION SUCCESSFUL!                   ║
╚════════════════════════════════════════════════════════╝

Generated project: ./generated-project/healthcare-api

Next steps:
  cd generated-project/healthcare-api
  mvn clean install
  docker-compose up -d
  mvn spring-boot:run
```

---

### 2. `validate` - Validate YAML Model

Validate a YAML model file without generating code.

**Syntax:**
```bash
mde-gen validate <yaml-file> [OPTIONS]
```

**Arguments:**
- `<yaml-file>` (required): Path to the YAML model file

**Options:**

| Option | Short | Type | Default | Description |
|--------|-------|------|---------|-------------|
| `--format` | `-f` | string | `text` | Output format: `text`, `json`, `xml` |
| `--strict` | | boolean | false | Treat warnings as errors |
| `--rules` | | string | `all` | Validation rules: `all`, `structural`, `business` |

**Examples:**
```bash
# Basic validation
mde-gen validate examples/healthcare-system.yaml

# Strict validation (warnings = errors)
mde-gen validate examples/blog.yaml --strict

# JSON output for CI/CD
mde-gen validate examples/trading.yaml --format json

# Only structural validation
mde-gen validate examples/social.yaml --rules structural
```

**Exit Codes:**
- `0` - Valid (no errors)
- `1` - File not found
- `2` - Validation errors found
- `3` - Validation warnings found (with `--strict`)

**Output (text format):**
```
╔════════════════════════════════════════════════════════╗
║     YAML MODEL VALIDATION                             ║
╚════════════════════════════════════════════════════════╝

File: examples/healthcare-system.yaml

✓ STRUCTURAL VALIDATION PASSED
  - Root element: BackendConfig ✓
  - Project configuration: valid ✓
  - Database configuration: valid ✓
  - 6 tables defined ✓

✓ BUSINESS RULES VALIDATION PASSED
  - All tables have primary keys ✓
  - No duplicate table names ✓
  - All foreign keys reference existing tables ✓
  - No circular dependencies ✓

╔════════════════════════════════════════════════════════╗
║            ✓ VALIDATION SUCCESSFUL                    ║
╚════════════════════════════════════════════════════════╝

Summary:
  Errors:   0
  Warnings: 0
  Info:     0
```

**Output (with errors):**
```
╔════════════════════════════════════════════════════════╗
║     YAML MODEL VALIDATION                             ║
╚════════════════════════════════════════════════════════╝

File: examples/invalid-example.yaml

✗ STRUCTURAL VALIDATION FAILED

Errors:
  [Line 15] Invalid enum value 'MYSQL' for database type
            Expected: POSTGRESQL
            
  [Line 23] Missing required attribute 'primary' for column 'id'
  
  [Line 45] Invalid data type 'VARCHAR'
            Expected one of: STRING, INTEGER, LONG, BOOLEAN, DATE, 
                            DATETIME, TEXT, UUID, DECIMAL

Warnings:
  [Line 30] Table 'users' missing primary key
  
  [Line 52] Column name 'class' is a Java reserved keyword

╔════════════════════════════════════════════════════════╗
║            ✗ VALIDATION FAILED                        ║
╚════════════════════════════════════════════════════════╝

Summary:
  Errors:   3
  Warnings: 2
  Info:     0
```

**JSON Output Format:**
```json
{
  "file": "examples/healthcare-system.yaml",
  "valid": true,
  "summary": {
    "errors": 0,
    "warnings": 0,
    "info": 0
  },
  "issues": []
}
```

---

### 3. `version` - Show Version Information

Display version information for the tool and its dependencies.

**Syntax:**
```bash
mde-gen version [OPTIONS]
```

**Options:**

| Option | Short | Type | Default | Description |
|--------|-------|------|---------|-------------|
| `--short` | `-s` | boolean | false | Show only version number |
| `--format` | `-f` | string | `text` | Output format: `text`, `json` |

**Examples:**
```bash
# Full version info
mde-gen version

# Short version
mde-gen version --short

# JSON format
mde-gen version --format json
```

**Output (text format):**
```
MDE Backend Generator v1.0.0

Build Information:
  Build Date:     2025-10-25
  Git Commit:     96bd7e5
  Java Version:   17.0.8

Dependencies:
  Eclipse EMF:    2.35.0
  Epsilon Flexmi: 2.5.0
  Epsilon ETL:    2.5.0
  Epsilon EGL:    2.5.0
  Spring Boot:    3.2.0
  Picocli:        4.7.5

System Information:
  OS:             Windows 11
  Architecture:   amd64
  Java Home:      C:\Program Files\Java\jdk-17
```

**Output (short format):**
```
1.0.0
```

**Output (JSON format):**
```json
{
  "version": "1.0.0",
  "build": {
    "date": "2025-10-25",
    "commit": "96bd7e5"
  },
  "java": {
    "version": "17.0.8",
    "home": "C:\\Program Files\\Java\\jdk-17"
  },
  "dependencies": {
    "emf": "2.35.0",
    "epsilon-flexmi": "2.5.0",
    "epsilon-etl": "2.5.0",
    "epsilon-egl": "2.5.0",
    "spring-boot": "3.2.0",
    "picocli": "4.7.5"
  }
}
```

---

### 4. `help` - Show Help Information

Display help information about commands and options.

**Syntax:**
```bash
mde-gen help [COMMAND]
```

**Arguments:**
- `[COMMAND]` (optional): Specific command to get help for

**Examples:**
```bash
# General help
mde-gen help

# Help for generate command
mde-gen help generate

# Help for validate command
mde-gen help validate
```

**Output:**
```
MDE Backend Generator - Model-Driven Spring Boot Code Generation

Usage: mde-gen [GLOBAL-OPTIONS] COMMAND [COMMAND-OPTIONS] [ARGUMENTS]

Commands:
  generate    Generate a Spring Boot project from YAML model
  validate    Validate a YAML model file
  version     Show version information
  help        Show help information

Global Options:
  -v, --verbose    Enable detailed logging output
  -h, --help       Show this help message
  -V, --version    Show version information

Examples:
  mde-gen generate examples/blog.yaml -o ./my-api
  mde-gen validate examples/healthcare.yaml --strict
  mde-gen version --short

For more information about a specific command:
  mde-gen help <command>

Documentation: https://github.com/shady0503/Model-Driven-Engineering
```

---

## Error Handling

### Error Message Format

All error messages follow this structure:

```
[ERROR] <Short description>

Details:
  <Detailed explanation>
  
Suggestion:
  <How to fix>
  
Example:
  <Correct usage example>
```

### Common Errors

**1. File Not Found**
```
[ERROR] YAML file not found

Details:
  File 'examples/missing.yaml' does not exist or is not readable.
  
Suggestion:
  - Verify the file path is correct
  - Check file permissions
  - Use absolute path if relative path fails
  
Example:
  mde-gen generate examples/healthcare-system.yaml
```

**2. Invalid YAML Syntax**
```
[ERROR] Invalid YAML syntax

Details:
  Line 45: Unexpected token ']'
  
Suggestion:
  - Check YAML indentation (use spaces, not tabs)
  - Validate YAML syntax using online validator
  - Review YAML documentation
```

**3. Validation Failed**
```
[ERROR] Model validation failed

Details:
  3 errors found in YAML model (see above)
  
Suggestion:
  - Run: mde-gen validate examples/your-file.yaml
  - Fix validation errors
  - Re-run generate command
```

**4. Permission Denied**
```
[ERROR] Cannot write to output directory

Details:
  Permission denied: ./generated-project/
  
Suggestion:
  - Check directory permissions
  - Run with appropriate user privileges
  - Choose a different output directory: --output-dir ~/my-project
```

---

## Color Scheme

### ANSI Color Codes

| Element | Color | ANSI Code | Usage |
|---------|-------|-----------|-------|
| Success | Green | `\u001B[32m` | ✓ messages, success banners |
| Error | Red | `\u001B[31m` | ✗ messages, error banners |
| Warning | Yellow | `\u001B[33m` | ⚠ warnings, deprecations |
| Info | Cyan | `\u001B[36m` | ℹ info messages, headers |
| Progress | Blue | `\u001B[34m` | Phase headers, progress bars |
| Reset | - | `\u001B[0m` | Reset to default |

### Auto-Detection

- Detect if terminal supports ANSI colors
- Disable colors if:
  - `NO_COLOR` environment variable is set
  - Output is redirected to file
  - Terminal doesn't support ANSI
  - `--no-color` flag is used

---

## Verbose Mode

When `--verbose` or `-v` flag is used:

### Generate Command
```
[VERBOSE] Loading YAML file: examples/healthcare-system.yaml
[VERBOSE] File size: 8.5 KB
[VERBOSE] Initializing EMF resource set
[VERBOSE] Registering Flexmi factory
[VERBOSE] Parsing YAML to BackendConfig model... (125ms)
[VERBOSE] Found 6 tables in database configuration
[VERBOSE] 
[VERBOSE] Starting ETL transformation...
[VERBOSE] Executing rule: BackendConfigToProjectContext
[VERBOSE] Executing rule: TableToEntityContext (6 instances)
[VERBOSE] Executing rule: ColumnToFieldContext (56 instances)
[VERBOSE] Executing rule: RelationToRelationContext (9 instances)
[VERBOSE] ETL transformation complete (342ms)
[VERBOSE] 
[VERBOSE] Starting EGL code generation...
[VERBOSE] Generating: pom.xml (1.2 KB)
[VERBOSE] Generating: Application.java (0.8 KB)
[VERBOSE] Generating: Patients.java (2.1 KB)
[VERBOSE] Generating: PatientsRepository.java (0.5 KB)
...
[VERBOSE] Total generation time: 1.8 seconds
[VERBOSE] Total files generated: 32
[VERBOSE] Total lines of code: 2,845
[VERBOSE] Peak memory usage: 128 MB
```

### Validate Command
```
[VERBOSE] Loading YAML file: examples/healthcare-system.yaml
[VERBOSE] Parsing YAML... (98ms)
[VERBOSE] Running structural validation...
[VERBOSE]   - Checking root element type
[VERBOSE]   - Validating project configuration
[VERBOSE]   - Validating database configuration
[VERBOSE]   - Validating table definitions (6 tables)
[VERBOSE] Structural validation passed (45ms)
[VERBOSE] 
[VERBOSE] Running business rules validation...
[VERBOSE]   - Checking primary keys (6/6 tables have PK)
[VERBOSE]   - Checking table name uniqueness (no duplicates)
[VERBOSE]   - Checking foreign key references (9 relations)
[VERBOSE]   - Checking circular dependencies (none found)
[VERBOSE] Business rules validation passed (23ms)
[VERBOSE] 
[VERBOSE] Total validation time: 166ms
```

---

## Configuration File Support

### Location Priority
1. `./mde-gen.properties` (current directory)
2. `~/.mde-gen/config.properties` (user home)
3. `/etc/mde-gen/config.properties` (system-wide, Linux/Mac)

### Configuration Format
```properties
# MDE Backend Generator Configuration

# Default output directory
output.dir=./generated-projects

# Enable verbose mode by default
verbose=false

# Color output
color.enabled=true

# Validation strictness
validation.strict=false

# Templates directory (for custom templates)
templates.dir=./custom-templates

# Generated project settings
generated.project.java.version=17
generated.project.spring.boot.version=3.2.0
```

---

## Exit Codes Reference

| Code | Meaning | Description |
|------|---------|-------------|
| 0 | Success | Command completed successfully |
| 1 | File Error | Input file not found or not readable |
| 2 | Validation Error | Model validation failed |
| 3 | Generation Error | Code generation failed |
| 4 | IO Error | File system error (permissions, disk space) |
| 5 | Configuration Error | Invalid configuration or options |
| 64 | Usage Error | Invalid command-line arguments |
| 70 | Internal Error | Unexpected internal error |

---

## Implementation Notes

### Picocli Annotations

```java
@Command(
    name = "mde-gen",
    mixinStandardHelpOptions = true,
    version = "1.0.0",
    description = "Model-Driven Backend Code Generator",
    subcommands = {
        GenerateCommand.class,
        ValidateCommand.class,
        VersionCommand.class,
        HelpCommand.class
    }
)
public class MdeGenCli implements Callable<Integer> {
    
    @Option(names = {"-v", "--verbose"}, description = "Enable verbose output")
    boolean verbose;
    
    @Override
    public Integer call() throws Exception {
        // Show help if no command specified
        CommandLine.usage(this, System.out);
        return 0;
    }
}
```

### Main Method

```java
public static void main(String[] args) {
    int exitCode = new CommandLine(new MdeGenCli())
        .setColorScheme(createColorScheme())
        .setUsageHelpWidth(80)
        .execute(args);
    System.exit(exitCode);
}
```

---

## Testing Scenarios

### Unit Tests
- Test each command with valid inputs
- Test error handling for invalid inputs
- Test option parsing
- Test color output detection
- Test configuration file loading

### Integration Tests
- Test complete generation workflow
- Test validation with various YAML files
- Test error messages and exit codes
- Test verbose mode output
- Test configuration override

### Manual Testing Commands
```bash
# Test basic generation
mde-gen generate examples/healthcare-system.yaml

# Test validation
mde-gen validate examples/healthcare-system.yaml

# Test verbose mode
mde-gen -v generate examples/social-media-platform.yaml

# Test error handling
mde-gen generate non-existent-file.yaml

# Test help
mde-gen help
mde-gen help generate

# Test version
mde-gen version
mde-gen version --short
```

---

## Future Enhancements

1. **Interactive Mode**: Prompt for missing required options
2. **Configuration Wizard**: `mde-gen init` to create initial YAML template
3. **Diff Command**: Compare two YAML models
4. **List Command**: List all entities/tables in a YAML model
5. **Watch Mode**: Auto-regenerate on YAML file changes
6. **Plugin System**: Load custom validators/generators

---

## Documentation Links

- GitHub Repository: https://github.com/shady0503/Model-Driven-Engineering
- User Guide: [To be created]
- API Reference: [To be created]
- Issue Tracker: https://github.com/shady0503/Model-Driven-Engineering/issues
