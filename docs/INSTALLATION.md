# MDE-Gen CLI Installation Guide

This guide shows you how to set up `mde-gen` as a standalone command on your system.

## Quick Start

### 1. Build the Executable JAR

First, build the project to create the executable JAR file:

```bash
# Windows (PowerShell/CMD)
.\mvnw.cmd clean package

# Linux/Mac
./mvnw clean package
```

This will create `target/mde-gen.jar` - a self-contained executable JAR with all dependencies.

### 2. Test It Works

```bash
# Windows (PowerShell)
.\mde-gen.ps1 --help

# Windows (CMD)
mde-gen.bat --help

# Linux/Mac
./mde-gen.sh --help
```

You should see the MDE-Gen help output with colored banners.

---

## Installation Options

### Option 1: Add to PATH (Recommended for Windows)

**For Windows PowerShell/CMD:**

1. **Copy the scripts to a permanent location:**
   ```powershell
   # Create a tools directory (if it doesn't exist)
   mkdir C:\Tools\mde-gen -Force
   
   # Copy the JAR and script
   copy target\mde-gen.jar C:\Tools\mde-gen\
   copy mde-gen.bat C:\Tools\mde-gen\
   copy mde-gen.ps1 C:\Tools\mde-gen\
   ```

2. **Add to your PATH:**
   
   **Option A - Using PowerShell (Current User):**
   ```powershell
   # Get current PATH
   $path = [Environment]::GetEnvironmentVariable("Path", "User")
   
   # Add MDE-Gen directory
   $newPath = $path + ";C:\Tools\mde-gen"
   
   # Set new PATH
   [Environment]::SetEnvironmentVariable("Path", $newPath, "User")
   ```
   
   **Option B - Using System Settings (GUI):**
   - Press `Win + X` and select "System"
   - Click "Advanced system settings"
   - Click "Environment Variables"
   - Under "User variables", select "Path" and click "Edit"
   - Click "New" and add: `C:\Tools\mde-gen`
   - Click "OK" on all dialogs

3. **Restart your terminal** (close and reopen PowerShell/CMD)

4. **Test it:**
   ```bash
   mde-gen --help
   ```

### Option 2: Create an Alias (PowerShell)

Add to your PowerShell profile (`$PROFILE`):

```powershell
# Edit profile
notepad $PROFILE

# Add this line:
function mde-gen { & "C:\Users\achra\Desktop\MDE\mde-gen.ps1" @args }

# Or if you moved it to C:\Tools:
function mde-gen { & "C:\Tools\mde-gen\mde-gen.ps1" @args }

# Reload profile
. $PROFILE
```

### Option 3: Linux/Mac - Symlink to /usr/local/bin

```bash
# Make the script executable
chmod +x mde-gen.sh

# Create symlink (you may need sudo)
sudo ln -s /path/to/MDE/mde-gen.sh /usr/local/bin/mde-gen

# Test it
mde-gen --help
```

### Option 4: Standalone JAR (No Scripts)

You can also run the JAR directly:

```bash
java -jar target/mde-gen.jar --help
java -jar target/mde-gen.jar generate examples/healthcare-system.yaml
```

---

## Usage Examples

Once installed, you can use `mde-gen` from anywhere:

```bash
# Show help
mde-gen --help

# Generate a project
mde-gen generate examples/healthcare-system.yaml

# Generate with custom output
mde-gen generate examples/healthcare-system.yaml -o C:\Projects\HealthcareAPI

# Validate a YAML file
mde-gen validate examples/social-media-platform.yaml

# Verbose mode
mde-gen -v generate examples/financial-trading-platform.yaml

# Clean and overwrite
mde-gen generate examples/healthcare-system.yaml --clean --overwrite
```

---

## Project Structure After Build

```
MDE/
├── target/
│   └── mde-gen.jar              # Executable JAR (30-40 MB with all dependencies)
├── mde-gen.bat                  # Windows batch launcher
├── mde-gen.ps1                  # PowerShell launcher
├── mde-gen.sh                   # Linux/Mac bash launcher
├── examples/
│   ├── healthcare-system.yaml
│   ├── social-media-platform.yaml
│   └── financial-trading-platform.yaml
└── ...
```

---

## Troubleshooting

### "java: command not found"

Make sure Java 17+ is installed and in your PATH:

```bash
# Check Java version
java -version

# Should show: openjdk version "17.x.x" or higher
```

**Install Java if needed:**
- Windows: Download from https://adoptium.net/
- Linux: `sudo apt install openjdk-17-jdk`
- Mac: `brew install openjdk@17`

### "mde-gen.jar not found"

You need to build the project first:

```bash
.\mvnw.cmd clean package
```

### "The term 'mde-gen' is not recognized" (Windows)

1. Make sure you added the directory to PATH correctly
2. Restart your terminal after modifying PATH
3. Or use the full path: `C:\Tools\mde-gen\mde-gen.bat --help`

### PowerShell Execution Policy Error

If you get "cannot be loaded because running scripts is disabled":

```powershell
# Check current policy
Get-ExecutionPolicy

# Set policy to allow local scripts (run as Administrator)
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

### Colors Not Showing

If you don't see colors in the output:

```bash
# Disable colors explicitly
mde-gen --no-color generate examples/healthcare.yaml

# Or set environment variable
set NO_COLOR=1
```

---

## Distribution

If you want to share the tool with others:

1. **Package the JAR:**
   ```bash
   .\mvnw.cmd clean package
   ```

2. **Create a distribution ZIP:**
   ```bash
   # Create dist folder
   mkdir dist
   
   # Copy files
   copy target\mde-gen.jar dist\
   copy mde-gen.bat dist\
   copy mde-gen.ps1 dist\
   copy mde-gen.sh dist\
   copy README.md dist\
   copy -r examples dist\
   
   # Zip it (PowerShell)
   Compress-Archive -Path dist\* -DestinationPath mde-gen-distribution.zip
   ```

3. **Share the ZIP** - Recipients can extract and run `mde-gen.bat` or `mde-gen.ps1`

---

## Updating

When you make changes to the code:

1. **Rebuild the JAR:**
   ```bash
   .\mvnw.cmd clean package
   ```

2. **Copy to installation directory (if you moved it):**
   ```bash
   copy target\mde-gen.jar C:\Tools\mde-gen\
   ```

3. **Test the update:**
   ```bash
   mde-gen --version  # (when version command is implemented)
   ```

---

## Advanced: Native Executable (Optional)

For even faster startup, you can create a native executable using GraalVM:

```bash
# Install GraalVM native-image
# Then build native executable
mvn -Pnative native:compile

# This creates a standalone .exe (Windows) or binary (Linux/Mac)
# No JVM required to run!
```

*(This requires additional GraalVM setup and configuration)*

---

## Uninstallation

### If installed via PATH:
1. Remove `C:\Tools\mde-gen` from your PATH environment variable
2. Delete the `C:\Tools\mde-gen` folder

### If using alias:
1. Remove the function from your PowerShell profile (`$PROFILE`)
2. Reload: `. $PROFILE`

### If using symlink (Linux/Mac):
```bash
sudo rm /usr/local/bin/mde-gen
```

---

## Next Steps

- See [CLI_DESIGN.md](CLI_DESIGN.md) for complete command reference
- See [CLI_IMPLEMENTATION_SUMMARY.md](CLI_IMPLEMENTATION_SUMMARY.md) for implementation details
- Check [README.md](../README.md) for project overview

---

**Happy Generating! 🚀**
