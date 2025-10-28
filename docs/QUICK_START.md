# Quick Start: Use `mde-gen` Command Directly

## You're Ready! 🎉

The executable JAR is already built at `target/mde-gen.jar`

## Quick Test (From Project Directory)

```powershell
# Test it works
.\mde-gen.ps1 --help

# Generate a project
.\mde-gen.ps1 generate examples/healthcare-system.yaml

# Validate YAML
.\mde-gen.ps1 validate examples/social-media-platform.yaml
```

## Install Globally (Use `mde-gen` from anywhere)

### Option 1: Quick PATH Setup (Recommended)

Run this PowerShell script to add MDE-Gen to your PATH:

```powershell
# 1. Create permanent location
$installDir = "C:\Tools\mde-gen"
New-Item -ItemType Directory -Path $installDir -Force

# 2. Copy files
Copy-Item "target\mde-gen.jar" -Destination $installDir
Copy-Item "mde-gen.ps1" -Destination $installDir
Copy-Item "mde-gen.bat" -Destination $installDir

# 3. Add to PATH (User level - no admin needed)
$currentPath = [Environment]::GetEnvironmentVariable("Path", "User")
if ($currentPath -notlike "*$installDir*") {
    $newPath = $currentPath + ";$installDir"
    [Environment]::SetEnvironmentVariable("Path", $newPath, "User")
    Write-Host "✓ Added $installDir to PATH" -ForegroundColor Green
    Write-Host "✓ Restart your terminal, then use: mde-gen --help" -ForegroundColor Green
} else {
    Write-Host "✓ Already in PATH" -ForegroundColor Yellow
}
```

**After running the above:**
1. Close and reopen your PowerShell/CMD
2. You can now run `mde-gen` from any directory!

```powershell
# From anywhere
mde-gen --help
mde-gen generate C:\Projects\my-model.yaml
mde-gen validate C:\Projects\my-model.yaml
```

### Option 2: PowerShell Alias (Current Session Only)

Quick temporary setup for current PowerShell session:

```powershell
# Add alias for current session
function mde-gen { & "C:\Users\achra\Desktop\MDE\mde-gen.ps1" @args }

# Now use it
mde-gen --help
```

To make it permanent, add to your PowerShell profile:

```powershell
# Edit profile
notepad $PROFILE

# Add this line:
function mde-gen { & "C:\Users\achra\Desktop\MDE\mde-gen.ps1" @args }

# Save and reload
. $PROFILE
```

### Option 3: Manual PATH Setup (GUI)

1. Copy `target\mde-gen.jar`, `mde-gen.ps1`, and `mde-gen.bat` to `C:\Tools\mde-gen\`
2. Press `Win + X` → System → Advanced system settings
3. Click "Environment Variables"
4. Under "User variables", select "Path" → "Edit"
5. Click "New" → Add `C:\Tools\mde-gen`
6. Click OK on all dialogs
7. Restart terminal

## Usage Examples

Once installed globally:

```powershell
# Show help
mde-gen --help

# Generate healthcare API
mde-gen generate examples/healthcare-system.yaml

# Custom output location
mde-gen generate examples/healthcare-system.yaml -o C:\Projects\HealthcareAPI

# Validate before generating
mde-gen validate examples/social-media-platform.yaml

# Verbose mode
mde-gen -v generate examples/financial-trading-platform.yaml

# Clean and overwrite
mde-gen generate examples/healthcare-system.yaml --clean --overwrite
```

## Updating After Code Changes

When you modify the code:

```powershell
# 1. Rebuild JAR
.\mvnw.cmd clean package -DskipTests

# 2. Copy to installation (if you installed globally)
Copy-Item "target\mde-gen.jar" -Destination "C:\Tools\mde-gen\" -Force

# 3. Test
mde-gen --help
```

## Troubleshooting

### "java: command not found"
Install Java 17+: https://adoptium.net/

### "The term 'mde-gen' is not recognized"
- Make sure you restarted terminal after adding to PATH
- Check PATH: `$env:Path -split ';' | Select-String mde-gen`
- Use full path: `C:\Tools\mde-gen\mde-gen.bat --help`

### PowerShell script won't run
```powershell
# Allow scripts (run as admin)
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

## Distribution

Share with teammates:

```powershell
# Create distribution package
New-Item -ItemType Directory -Path "dist" -Force
Copy-Item "target\mde-gen.jar" -Destination "dist\"
Copy-Item "mde-gen.bat" -Destination "dist\"
Copy-Item "mde-gen.ps1" -Destination "dist\"
Copy-Item "README.md" -Destination "dist\"
Copy-Item -Recurse "examples" -Destination "dist\"

# Create ZIP
Compress-Archive -Path "dist\*" -DestinationPath "mde-gen-v1.0.zip" -Force
```

Share `mde-gen-v1.0.zip` - recipients can extract and run!

---

**You're all set! Start generating Spring Boot projects with `mde-gen` 🚀**
