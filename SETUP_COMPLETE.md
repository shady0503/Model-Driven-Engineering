# ✅ Installation Complete

## What Was Done

The automated setup script (`setup-path.ps1`) has configured your system to use `mde-gen` as a global command.

### Changes Made:

1. **Created `bin` directory** at `C:\Users\achra\Desktop\MDE\bin`
2. **Copied executable scripts:**
   - `mde-gen.bat` (for Windows CMD)
   - `mde-gen.ps1` (for PowerShell)
3. **Added to PATH:** `C:\Users\achra\Desktop\MDE\bin` is now in your User PATH environment variable

### Directory Structure:

```
C:\Users\achra\Desktop\MDE\
├── bin/                    ← NEW: In your PATH
│   ├── mde-gen.bat        ← Windows CMD executable
│   ├── mde-gen.ps1        ← PowerShell executable
│   └── README.md          ← Usage guide
├── target/
│   └── mde-gen.jar        ← The actual application (~40MB)
├── setup-path.ps1         ← Installation script (already run)
├── uninstall-path.ps1     ← Removal script
└── ... (rest of project)
```

---

## ⚠️ IMPORTANT: Restart Your Terminal

**The `mde-gen` command will only work after you restart your terminal.**

### Windows PowerShell/CMD:
1. Close all PowerShell/CMD windows
2. Open a new PowerShell/CMD window
3. Type `mde-gen --help` from **any directory**

---

## Quick Test

After restarting your terminal:

```powershell
# Test from any directory
cd C:\
mde-gen --help

# Generate a project
mde-gen generate C:\Users\achra\Desktop\MDE\examples\healthcare-system.yaml

# Validate a model
mde-gen validate C:\Users\achra\Desktop\MDE\examples\blog-example.yaml
```

---

## How It Works

When you type `mde-gen`:

1. Windows searches your PATH for `mde-gen.bat` or `mde-gen.ps1`
2. Finds it in `C:\Users\achra\Desktop\MDE\bin`
3. The script runs: `java -jar C:\Users\achra\Desktop\MDE\target\mde-gen.jar <your-args>`
4. Your command executes!

---

## Common Commands

```powershell
# Help
mde-gen --help
mde-gen generate --help
mde-gen validate --help

# Generate
mde-gen generate path/to/model.yaml
mde-gen gen path/to/model.yaml -o ./output-dir
mde-gen g path/to/model.yaml --clean --no-zip

# Validate  
mde-gen validate path/to/model.yaml
mde-gen val path/to/model.yaml --strict
mde-gen v path/to/model.yaml --format json

# Options
mde-gen -v generate path/to/model.yaml    # Verbose mode
mde-gen --no-color validate model.yaml     # No colors
```

---

## Uninstall

If you want to remove `mde-gen` from PATH:

```powershell
C:\Users\achra\Desktop\MDE\uninstall-path.ps1
```

This removes the bin directory from PATH but keeps all files intact.

---

## Rebuilding the JAR

When you make changes to the code and rebuild:

```powershell
cd C:\Users\achra\Desktop\MDE
.\mvnw.cmd clean package
```

The `mde-gen` command automatically uses the new JAR. **No need to run setup again.**

---

## Troubleshooting

### "mde-gen is not recognized"

**You forgot to restart your terminal.** Close and reopen PowerShell/CMD.

### Still not working after restart?

Check if PATH was set correctly:
```powershell
$env:Path -split ';' | Select-String "MDE"
```

Should show: `C:\Users\achra\Desktop\MDE\bin`

### "JAR file not found"

Rebuild the project:
```powershell
cd C:\Users\achra\Desktop\MDE
.\mvnw.cmd clean package
```

---

## Next Steps

1. **Restart your terminal** (if you haven't already)
2. **Test the command:** `mde-gen --help`
3. **Generate your first project:** `mde-gen generate examples/healthcare-system.yaml`
4. **Read the docs:**
   - [INSTALL.md](INSTALL.md) - Detailed installation guide
   - [CLI_DESIGN.md](docs/CLI_DESIGN.md) - Complete command reference
   - [QUICK_START.md](QUICK_START.md) - Getting started tutorial

---

**Installation successful! Enjoy using `mde-gen`!** 🎉
