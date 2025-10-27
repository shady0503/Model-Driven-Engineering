# MDE Generator - Create Distribution Package
# This script creates a portable ZIP file that can be distributed to other computers

$ErrorActionPreference = "Stop"

Write-Host "==================================================" -ForegroundColor Cyan
Write-Host "    MDE Generator - Distribution Builder" -ForegroundColor Cyan
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host ""

# Get script directory
$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path

# Check if JAR exists
$JarFile = Join-Path $ScriptDir "target\mde-gen.jar"
if (-not (Test-Path $JarFile)) {
    Write-Host "ERROR: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Please build the project first: .\mvnw.cmd clean package" -ForegroundColor Yellow
    exit 1
}

# Get version from pom.xml (simple extraction)
$PomFile = Join-Path $ScriptDir "pom.xml"
$Version = "1.0.0"
if (Test-Path $PomFile) {
    $PomContent = Get-Content $PomFile -Raw
    if ($PomContent -match '<version>([^<]+)</version>') {
        $Version = $Matches[1]
    }
}

# Create distribution directory
$DistDir = Join-Path $ScriptDir "dist"
$PackageName = "mde-gen-$Version"
$PackageDir = Join-Path $DistDir $PackageName

Write-Host "Creating distribution package: $PackageName" -ForegroundColor Cyan
Write-Host ""

# Clean and create directory
if (Test-Path $PackageDir) {
    Remove-Item -Recurse -Force $PackageDir
}
New-Item -ItemType Directory -Path $PackageDir -Force | Out-Null

# Create subdirectories
$BinDir = Join-Path $PackageDir "bin"
$ExamplesDir = Join-Path $PackageDir "examples"
$DocsDir = Join-Path $PackageDir "docs"

New-Item -ItemType Directory -Path $BinDir -Force | Out-Null
New-Item -ItemType Directory -Path $ExamplesDir -Force | Out-Null
New-Item -ItemType Directory -Path $DocsDir -Force | Out-Null

Write-Host "Copying files..." -ForegroundColor Yellow

# Copy JAR
Copy-Item $JarFile -Destination $PackageDir
Write-Host "  [OK] mde-gen.jar" -ForegroundColor Green

# Copy examples
$SourceExamplesDir = Join-Path $ScriptDir "examples"
if (Test-Path $SourceExamplesDir) {
    Get-ChildItem -Path $SourceExamplesDir -Filter "*.yaml" | ForEach-Object {
        Copy-Item $_.FullName -Destination $ExamplesDir
        Write-Host "  [OK] examples\$($_.Name)" -ForegroundColor Green
    }
}

# Copy documentation
$DocFiles = @("README.md", "INSTALL.md", "QUICK_START.md")
foreach ($DocFile in $DocFiles) {
    $SourceDoc = Join-Path $ScriptDir $DocFile
    if (Test-Path $SourceDoc) {
        Copy-Item $SourceDoc -Destination $DocsDir
        Write-Host "  [OK] docs\$DocFile" -ForegroundColor Green
    }
}

# Copy docs directory if it exists
$SourceDocsDir = Join-Path $ScriptDir "docs"
if (Test-Path $SourceDocsDir) {
    Get-ChildItem -Path $SourceDocsDir -Filter "*.md" | ForEach-Object {
        Copy-Item $_.FullName -Destination $DocsDir
    }
}

# Create launcher scripts
Write-Host ""
Write-Host "Creating launcher scripts..." -ForegroundColor Yellow

# Windows batch file
$BatchContent = @'
@echo off
REM MDE Generator Launcher for Windows

set SCRIPT_DIR=%~dp0
set JAR_FILE=%SCRIPT_DIR%..\mde-gen.jar

if not exist "%JAR_FILE%" (
    echo ERROR: mde-gen.jar not found!
    echo Expected location: %JAR_FILE%
    exit /b 1
)

java -jar "%JAR_FILE%" %*
'@
Set-Content -Path (Join-Path $BinDir "mde-gen.bat") -Value $BatchContent -Encoding ASCII
Write-Host "  [OK] bin\mde-gen.bat" -ForegroundColor Green

# PowerShell script
$PowerShellContent = @'
# MDE Generator Launcher for PowerShell

$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$JarFile = Join-Path (Split-Path -Parent $ScriptDir) "mde-gen.jar"

if (-not (Test-Path $JarFile)) {
    Write-Host "ERROR: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Expected location: $JarFile" -ForegroundColor Yellow
    exit 1
}

& java -jar $JarFile $args
exit $LASTEXITCODE
'@
Set-Content -Path (Join-Path $BinDir "mde-gen.ps1") -Value $PowerShellContent -Encoding UTF8
Write-Host "  [OK] bin\mde-gen.ps1" -ForegroundColor Green

# Linux/Mac bash script
$BashContent = @'
#!/bin/bash
# MDE Generator Launcher for Linux/Mac

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
JAR_FILE="$SCRIPT_DIR/../mde-gen.jar"

if [ ! -f "$JAR_FILE" ]; then
    echo "ERROR: mde-gen.jar not found!"
    echo "Expected location: $JAR_FILE"
    exit 1
fi

java -jar "$JAR_FILE" "$@"
exit $?
'@
Set-Content -Path (Join-Path $BinDir "mde-gen.sh") -Value $BashContent -Encoding UTF8
Write-Host "  [OK] bin\mde-gen.sh" -ForegroundColor Green

# Create installation guide
$InstallGuide = @"
# MDE Generator - Portable Installation

## Quick Installation (Windows)

### Option 1: Automated Installation (Recommended)

1. **Extract this ZIP file** to any location (e.g., ``C:\Tools\mde-gen``)

2. **Run PowerShell as Administrator** (for system-wide) or regular PowerShell (for current user)

3. **Navigate to the extracted folder:**
   ``````powershell
   cd C:\Tools\mde-gen-$Version
   ``````

4. **Run the installer:**
   ``````powershell
   .\install-portable.ps1
   ``````

5. **Restart your terminal**

6. **Test it:**
   ``````powershell
   mde-gen --help
   mde-gen generate `$env:MDE_EXAMPLES\healthcare-system.yaml
   ``````

### Option 2: Manual Installation

1. **Extract this ZIP** to ``C:\Tools\mde-gen-$Version``

2. **Add to PATH manually:**
   - Open System Properties → Environment Variables
   - Add ``C:\Tools\mde-gen-$Version\bin`` to your PATH
   - Create ``MDE_EXAMPLES`` variable = ``C:\Tools\mde-gen-$Version\examples``

3. **Restart terminal and test:**
   ``````powershell
   mde-gen --help
   ``````

### Option 3: Use Without Installation

``````powershell
# Navigate to the extracted folder
cd C:\Tools\mde-gen-$Version

# Run directly
.\bin\mde-gen.bat --help
.\bin\mde-gen.bat generate examples\healthcare-system.yaml
``````

---

## Quick Installation (Linux/Mac)

1. **Extract the ZIP:**
   ``````bash
   unzip mde-gen-$Version.zip
   cd mde-gen-$Version
   ``````

2. **Make scripts executable:**
   ``````bash
   chmod +x bin/mde-gen.sh
   ``````

3. **Add to PATH (add to ~/.bashrc or ~/.zshrc):**
   ``````bash
   export PATH="`$PATH:/path/to/mde-gen-$Version/bin"
   export MDE_EXAMPLES="/path/to/mde-gen-$Version/examples"
   ``````

4. **Reload shell and test:**
   ``````bash
   source ~/.bashrc
   mde-gen.sh --help
   ``````

---

## What's Included

``````
mde-gen-$Version/
├── mde-gen.jar              # Main application (~40MB)
├── bin/
│   ├── mde-gen.bat          # Windows launcher
│   ├── mde-gen.ps1          # PowerShell launcher
│   └── mde-gen.sh           # Linux/Mac launcher
├── examples/
│   ├── healthcare-system.yaml
│   ├── social-media-platform.yaml
│   └── financial-trading-platform.yaml
├── docs/
│   ├── README.md
│   ├── CLI_DESIGN.md
│   └── QUICK_START.md
└── INSTALL.md               # This file
``````

---

## Requirements

- **Java 17 or higher** (verify with ``java -version``)
- Windows 10+, Linux, or macOS

---

## Usage Examples

``````powershell
# Get help
mde-gen --help

# Generate from examples
mde-gen generate `$env:MDE_EXAMPLES\healthcare-system.yaml
mde-gen generate `$env:MDE_EXAMPLES\social-media-platform.yaml -o C:\Projects\my-api

# Validate models
mde-gen validate `$env:MDE_EXAMPLES\healthcare-system.yaml
mde-gen validate my-custom-model.yaml --strict

# Verbose mode
mde-gen -v generate `$env:MDE_EXAMPLES\healthcare-system.yaml
``````

---

## Uninstallation

1. Remove the installation directory
2. Remove from PATH environment variable
3. Remove MDE_EXAMPLES environment variable

---

For more information, see docs/README.md
"@
Set-Content -Path (Join-Path $PackageDir "INSTALL.md") -Value $InstallGuide -Encoding UTF8
Write-Host "  [OK] INSTALL.md" -ForegroundColor Green

# Create portable installer script
$PortableInstaller = @'
# MDE Generator - Portable Installer
# Installs mde-gen from the current directory to system PATH

param(
    [string]$InstallPath,
    [switch]$System
)

$ErrorActionPreference = "Stop"

# Get current directory (where this package is extracted)
$PackageDir = Split-Path -Parent $MyInvocation.MyCommand.Path

# Check if JAR exists
$JarFile = Join-Path $PackageDir "mde-gen.jar"
if (-not (Test-Path $JarFile)) {
    Write-Host "ERROR: mde-gen.jar not found in current directory!" -ForegroundColor Red
    exit 1
}

# Determine installation location
if (-not $InstallPath) {
    if ($System) {
        $InstallPath = "$env:ProgramFiles\mde-gen"
    } else {
        $InstallPath = "$env:LOCALAPPDATA\Programs\mde-gen"
    }
}

# Determine scope
$Scope = if ($System) { "Machine" } else { "User" }

Write-Host "Installing MDE Generator..." -ForegroundColor Cyan
Write-Host "Source:      $PackageDir" -ForegroundColor Gray
Write-Host "Destination: $InstallPath" -ForegroundColor Gray
Write-Host "Scope:       $Scope" -ForegroundColor Gray
Write-Host ""

# Create installation directory
if (-not (Test-Path $InstallPath)) {
    New-Item -ItemType Directory -Path $InstallPath -Force | Out-Null
}

# Copy all files
Write-Host "Copying files..." -ForegroundColor Yellow
Copy-Item -Path "$PackageDir\*" -Destination $InstallPath -Recurse -Force
Write-Host "[OK] Files copied" -ForegroundColor Green

# Add bin directory to PATH
$BinDir = Join-Path $InstallPath "bin"
$CurrentPath = [Environment]::GetEnvironmentVariable("Path", $Scope)

if ($CurrentPath -notlike "*$BinDir*") {
    Write-Host "Adding to PATH..." -ForegroundColor Yellow
    $NewPath = "$CurrentPath;$BinDir"
    [Environment]::SetEnvironmentVariable("Path", $NewPath, $Scope)
    Write-Host "[OK] Added to PATH" -ForegroundColor Green
}

# Set MDE_EXAMPLES
$ExamplesDir = Join-Path $InstallPath "examples"
[Environment]::SetEnvironmentVariable("MDE_EXAMPLES", $ExamplesDir, $Scope)
Write-Host "[OK] MDE_EXAMPLES set to: $ExamplesDir" -ForegroundColor Green

Write-Host ""
Write-Host "Installation complete!" -ForegroundColor Green
Write-Host "Restart your terminal and run: mde-gen --help" -ForegroundColor Cyan
'@
Set-Content -Path (Join-Path $PackageDir "install-portable.ps1") -Value $PortableInstaller -Encoding UTF8
Write-Host "  [OK] install-portable.ps1" -ForegroundColor Green

Write-Host ""
Write-Host "Creating ZIP archive..." -ForegroundColor Yellow

# Create ZIP file
$ZipFile = Join-Path $DistDir "$PackageName.zip"
if (Test-Path $ZipFile) {
    Remove-Item $ZipFile -Force
}

Compress-Archive -Path $PackageDir -DestinationPath $ZipFile -CompressionLevel Optimal
Write-Host "[OK] Created: $ZipFile" -ForegroundColor Green

# Get file size
$FileSize = (Get-Item $ZipFile).Length / 1MB
Write-Host ""
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host "    Distribution Package Created!" -ForegroundColor Green
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Package: $ZipFile" -ForegroundColor Cyan
Write-Host "Size:    $([math]::Round($FileSize, 2)) MB" -ForegroundColor Cyan
Write-Host ""
Write-Host "This ZIP can be distributed to other computers." -ForegroundColor Yellow
Write-Host "Recipients just need to:" -ForegroundColor Yellow
Write-Host "  1. Extract the ZIP" -ForegroundColor White
Write-Host "  2. Run install-portable.ps1" -ForegroundColor White
Write-Host "  3. Restart terminal" -ForegroundColor White
Write-Host "  4. Use 'mde-gen' command" -ForegroundColor White
