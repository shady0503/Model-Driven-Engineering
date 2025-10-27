# 🚀 MDE Backend Generator - Ready to Use!

## ✅ Installation Complete

The `mde-gen` command is now in your PATH and can be used from anywhere!

---

## 📦 What's Included

### Executable Command
- **`mde-gen`** - Available globally (after terminal restart)

### Example YAML Files
Example files are included at: `C:\Users\achra\Desktop\MDE\bin\examples\`

- **`healthcare-system.yaml`** - Medical clinic management (6 entities: Doctors, Patients, Appointments, etc.)
- **`social-media-platform.yaml`** - Social networking platform
- **`financial-trading-platform.yaml`** - Trading and portfolio management

---

## 🎯 Quick Start

**⚠️ IMPORTANT:** Restart your terminal first!

### From Any Directory:

```powershell
# Get help
mde-gen --help

# Generate a Spring Boot project from included examples
mde-gen generate C:\Users\achra\Desktop\MDE\bin\examples\healthcare-system.yaml

# Specify output directory
mde-gen generate C:\Users\achra\Desktop\MDE\bin\examples\social-media-platform.yaml -o C:\Projects\my-social-api

# Validate a model
mde-gen validate C:\Users\achra\Desktop\MDE\bin\examples\healthcare-system.yaml
```

### Using Your Own YAML Files:

```powershell
# Just provide the full path to your YAML file
mde-gen generate C:\MyProjects\my-custom-model.yaml
mde-gen validate C:\Documents\my-backend-design.yaml -o ./output
```

---

## 📍 Output Location

By default, generated projects are created in `./generated-project` **relative to your current directory**.

```powershell
# Example 1: You're in C:\Users\achra\Desktop\
cd C:\Users\achra\Desktop
mde-gen generate C:\Users\achra\Desktop\MDE\bin\examples\healthcare-system.yaml
# → Creates: C:\Users\achra\Desktop\generated-project\

# Example 2: Specify custom output
cd C:\Projects
mde-gen generate C:\Users\achra\Desktop\MDE\bin\examples\healthcare-system.yaml -o ./healthcare-api
# → Creates: C:\Projects\healthcare-api\

# Example 3: Absolute output path
mde-gen generate C:\Users\achra\Desktop\MDE\bin\examples\healthcare-system.yaml -o C:\MyApps\clinic-api
# → Creates: C:\MyApps\clinic-api\
```

---

## 🎨 Common Commands

```powershell
# Generate with options
mde-gen generate <yaml-file> -o <output-dir>     # Specify output directory
mde-gen generate <yaml-file> --clean              # Clean before generation
mde-gen generate <yaml-file> --overwrite          # Overwrite without asking
mde-gen generate <yaml-file> --no-zip             # Don't create ZIP archive
mde-gen generate <yaml-file> -v                   # Verbose mode (detailed logging)

# Validate
mde-gen validate <yaml-file>                      # Basic validation
mde-gen validate <yaml-file> --strict             # Warnings become errors
mde-gen validate <yaml-file> --format json        # JSON output (for CI/CD)

# Help
mde-gen --help                                     # General help
mde-gen generate --help                            # Generate command help
mde-gen validate --help                            # Validate command help
```

---

## 🔧 Complete Example Workflow

```powershell
# 1. Start from any directory
cd C:\Projects

# 2. Generate a healthcare API
mde-gen generate C:\Users\achra\Desktop\MDE\bin\examples\healthcare-system.yaml -o ./healthcare-api

# 3. Navigate to generated project
cd healthcare-api

# 4. Build and run
mvn clean install
docker-compose up -d
mvn spring-boot:run

# 5. Test the API
# Visit: http://localhost:8080
# Swagger UI: http://localhost:8080/swagger-ui.html
```

---

## 📂 Directory Structure

After installation, your setup looks like:

```
C:\Users\achra\Desktop\MDE\
├── bin\                           ← In your PATH
│   ├── examples\                  ← Example YAML files
│   │   ├── healthcare-system.yaml
│   │   ├── social-media-platform.yaml
│   │   └── financial-trading-platform.yaml
│   ├── mde-gen.bat               ← Windows CMD executable
│   └── mde-gen.ps1               ← PowerShell executable
└── target\
    └── mde-gen.jar               ← The actual application
```

---

## ⚙️ System Integration

### How It Works:

1. You type: `mde-gen generate C:\...\healthcare-system.yaml`
2. Windows finds `mde-gen.bat` in your PATH (`C:\Users\achra\Desktop\MDE\bin`)
3. The script runs: `java -jar ..\target\mde-gen.jar generate ...`
4. Your Spring Boot project is generated!

### Rebuilding the JAR:

When you update the MDE source code:

```powershell
cd C:\Users\achra\Desktop\MDE
.\mvnw.cmd clean package

# mde-gen automatically uses the new JAR - no reinstall needed!
```

---

## 🆘 Troubleshooting

### "mde-gen is not recognized"

**Solution:** Restart your terminal. PATH changes only take effect in new sessions.

### Still not working?

Check if PATH is set:
```powershell
$env:Path -split ';' | Select-String "MDE"
# Should show: C:\Users\achra\Desktop\MDE\bin
```

### Examples not found?

Verify examples exist:
```powershell
ls C:\Users\achra\Desktop\MDE\bin\examples
# Should show 3 YAML files
```

### JAR not found error?

Rebuild the project:
```powershell
cd C:\Users\achra\Desktop\MDE
.\mvnw.cmd clean package
```

---

## 🗑️ Uninstallation

To remove `mde-gen` from PATH:

```powershell
cd C:\Users\achra\Desktop\MDE
.\uninstall-path.ps1
```

This removes the bin directory from PATH but keeps all files.

---

## 📚 Documentation

- **[INSTALL.md](../INSTALL.md)** - Complete installation guide
- **[CLI_DESIGN.md](../docs/CLI_DESIGN.md)** - Full command reference
- **[QUICK_START.md](../QUICK_START.md)** - Tutorial and examples
- **[UNICODE_FIX.md](../docs/UNICODE_FIX.md)** - Symbol display configuration

---

## 🎉 You're All Set!

Start generating Spring Boot backends from YAML models:

```powershell
mde-gen generate C:\Users\achra\Desktop\MDE\bin\examples\healthcare-system.yaml
```

Happy coding! 🚀
