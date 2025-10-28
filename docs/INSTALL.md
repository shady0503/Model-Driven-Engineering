# MDE Generator - Quick Installation

Get `mde-gen` working globally in 3 simple steps.

## Automated Installation (Recommended)

### Step 1: Build the JAR

```powershell
.\mvnw.cmd clean package
```

### Step 2: Run Setup Script

**For Current User (Recommended):**
```powershell
.\setup-path.ps1
```

**For All Users (System-wide):**
```powershell
# Run PowerShell as Administrator first
.\setup-path.ps1 -System
```

### Step 3: Restart Terminal

Close and reopen your PowerShell/CMD terminal.

### Step 4: Verify

```powershell
mde-gen --help
mde-gen generate examples/healthcare-system.yaml
```

✅ **Done!** You can now use `mde-gen` from any directory.

---

## What the Setup Script Does

The `setup-path.ps1` script automatically:

1. Creates a `bin` directory in your MDE folder
2. Copies executable scripts (`mde-gen.bat` and `mde-gen.ps1`) to the bin directory
3. Adds the `C:\Users\achra\Desktop\MDE\bin` directory to your PATH environment variable
4. Configures the scripts to reference the JAR file in the `target` directory

After setup, the directory structure looks like:

```
MDE/
├── bin/
│   ├── mde-gen.bat      (executable for CMD)
│   └── mde-gen.ps1      (executable for PowerShell)
├── target/
│   └── mde-gen.jar      (the actual application)
├── setup-path.ps1       (installation script)
└── uninstall-path.ps1   (removal script)
```

When you run `mde-gen`, Windows finds the script in `bin/` (because it's in PATH), and the script runs `java -jar ../target/mde-gen.jar`.

---

## Manual Installation (Alternative)

If you prefer not to modify your PATH:

### Use with Full Path

```powershell
# From the MDE directory
.\mde-gen.ps1 validate examples/blog-example.yaml
```

### Create PowerShell Alias

Add to your PowerShell profile (`$PROFILE`):

```powershell
function mde-gen { 
    & "C:\Users\achra\Desktop\MDE\mde-gen.ps1" $args 
}
```

Then restart PowerShell and use:
```powershell
mde-gen --help
```

---

## Uninstallation

To remove `mde-gen` from your PATH:

```powershell
.\uninstall-path.ps1

# Or for system-wide removal:
.\uninstall-path.ps1 -System
```

This removes the `bin` directory from PATH but keeps all files intact.

---

## Troubleshooting

### "mde-gen is not recognized as a command"

**Solution:** Restart your terminal after running `setup-path.ps1`. PATH changes only take effect in new terminal sessions.

### "Cannot run scripts" error

**Solution:** Enable PowerShell script execution:
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

### "Access denied" when using -System flag

**Solution:** Run PowerShell as Administrator:
1. Right-click PowerShell
2. Select "Run as Administrator"
3. Run `.\setup-path.ps1 -System` again

### Setup script completes but mde-gen still doesn't work

**Solution:** Check your PATH:
```powershell
# See if bin directory is in PATH
$env:Path -split ';' | Select-String "MDE"

# Manually verify
Test-Path "C:\Users\achra\Desktop\MDE\bin\mde-gen.bat"
```

---

## Advanced: Distribution to Other Machines

To package MDE Generator for distribution:

1. **Create a distribution folder:**
   ```powershell
   mkdir mde-gen-dist
   copy target\mde-gen.jar mde-gen-dist\
   copy mde-gen.bat mde-gen-dist\
   copy mde-gen.ps1 mde-gen-dist\
   copy setup-path.ps1 mde-gen-dist\
   copy uninstall-path.ps1 mde-gen-dist\
   ```

2. **Zip the folder:**
   ```powershell
   Compress-Archive -Path mde-gen-dist -DestinationPath mde-gen-v1.0.zip
   ```

3. **On target machine:**
   ```powershell
   # Extract and run setup
   Expand-Archive mde-gen-v1.0.zip -DestinationPath C:\Tools\mde-gen
   cd C:\Tools\mde-gen
   .\setup-path.ps1
   ```

---

## Next Steps

Once installed, see:
- **[CLI Design](docs/CLI_DESIGN.md)** - Complete command reference
- **[Quick Start](QUICK_START.md)** - Examples and tutorials
- **[Unicode Fix](docs/UNICODE_FIX.md)** - Symbol display configuration

Happy generating! 🚀
