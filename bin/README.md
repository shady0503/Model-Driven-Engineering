# MDE Backend Generator - Scripts

All executable and installation scripts for the MDE Backend Generator.

## Launcher Scripts

- `mde-gen.bat` - Windows CMD launcher
- `mde-gen.ps1` - PowerShell launcher (cross-platform)
- `mde-gen.sh` - Bash launcher (Linux/Mac)

These scripts find and run the JAR from `../target/mde-gen.jar`.

## Installation Scripts

- `install.ps1` - Install to custom location
- `setup-path.ps1` - Add bin/ to system PATH
- `uninstall-path.ps1` - Remove bin/ from system PATH
- `create-distribution.ps1` - Create distributable ZIP package

## Usage

**Quick Start (from project root):**
```powershell
# Build the project first
.\mvnw.cmd clean package

# Run from root (delegates to bin/ scripts)
.\mde-gen.ps1 generate examples\healthcare-system.yaml -o C:\output

# Or run directly from bin/
.\bin\mde-gen.ps1 generate examples\healthcare-system.yaml -o C:\output
```

**Add to PATH:**
```powershell
.\bin\setup-path.ps1
```

After adding to PATH, you can run `mde-gen` from anywhere:
```powershell
mde-gen generate examples\healthcare-system.yaml -o C:\output
```

## Example Files

Example YAML models are in the root `examples/` directory:
- `healthcare-system.yaml` - Medical clinic (6 entities)
- `social-media-platform.yaml` - Social network (9 entities)  
- `financial-trading-platform.yaml` - Trading platform (8 entities)
- `e-commerce-platform.yaml` - E-commerce (13 entities)

## Documentation

- [docs/INSTALL.md](../docs/INSTALL.md) - Installation guide
- [docs/QUICK_START.md](../docs/QUICK_START.md) - Getting started tutorial
- [readme.md](../readme.md) - Main documentation
