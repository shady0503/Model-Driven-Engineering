# MDE Generator - Portable Installer
# This script installs mde-gen to a user-specified location (default: C:\Program Files\mde-gen)

param(
    [string]$InstallPath = "$env:ProgramFiles\mde-gen",
    [switch]$User,
    [switch]$System
)

$ErrorActionPreference = "Stop"

Write-Host "==================================================" -ForegroundColor Cyan
Write-Host "    MDE Generator - Portable Installer" -ForegroundColor Cyan
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host ""

# Determine the source directory (where this script is located)
$SourceDir = Split-Path -Parent $MyInvocation.MyCommand.Path

# Check if JAR exists
$SourceJar = Join-Path $SourceDir "target\mde-gen.jar"
if (-not (Test-Path $SourceJar)) {
    Write-Host "ERROR: mde-gen.jar not found in $SourceDir\target\" -ForegroundColor Red
    Write-Host "Please build the project first: .\mvnw.cmd clean package" -ForegroundColor Yellow
    exit 1
}

# Determine scope
$Scope = "User"
if ($System) {
    $Scope = "Machine"
    Write-Host "Installing for: All Users (System-wide)" -ForegroundColor Yellow
    Write-Host "NOTE: This requires Administrator privileges" -ForegroundColor Yellow
} else {
    # For user installation, use a path in user's home directory by default
    if ($InstallPath -eq "$env:ProgramFiles\mde-gen") {
        $InstallPath = "$env:LOCALAPPDATA\Programs\mde-gen"
    }
    Write-Host "Installing for: Current User" -ForegroundColor Cyan
}

Write-Host ""
Write-Host "Installation directory: $InstallPath" -ForegroundColor Cyan
Write-Host ""

# Create installation directory
if (-not (Test-Path $InstallPath)) {
    Write-Host "Creating installation directory..." -ForegroundColor Yellow
    New-Item -ItemType Directory -Path $InstallPath -Force | Out-Null
}

# Create subdirectories
$BinDir = Join-Path $InstallPath "bin"
$ExamplesDir = Join-Path $InstallPath "examples"

New-Item -ItemType Directory -Path $BinDir -Force | Out-Null
New-Item -ItemType Directory -Path $ExamplesDir -Force | Out-Null

Write-Host "Copying files..." -ForegroundColor Cyan

# Copy JAR file
Write-Host "  Copying mde-gen.jar..." -ForegroundColor Gray
Copy-Item $SourceJar -Destination $InstallPath -Force

# Copy example files
$SourceExamplesDir = Join-Path $SourceDir "examples"
if (Test-Path $SourceExamplesDir) {
    Write-Host "  Copying example files..." -ForegroundColor Gray
    Get-ChildItem -Path $SourceExamplesDir -Filter "*.yaml" | ForEach-Object {
        Copy-Item $_.FullName -Destination $ExamplesDir -Force
    }
}

# Create launcher scripts
Write-Host "  Creating launcher scripts..." -ForegroundColor Gray

# Create mde-gen.bat
$BatchContent = @"
@echo off
set INSTALL_DIR=%~dp0..
java -jar "%INSTALL_DIR%\mde-gen.jar" %*
"@
$BatchFile = Join-Path $BinDir "mde-gen.bat"
Set-Content -Path $BatchFile -Value $BatchContent -Encoding ASCII

# Create mde-gen.ps1
$PowerShellContent = @'
$InstallDir = Split-Path -Parent (Split-Path -Parent $MyInvocation.MyCommand.Path)
$JarFile = Join-Path $InstallDir "mde-gen.jar"
& java -jar $JarFile $args
exit $LASTEXITCODE
'@
$PowerShellFile = Join-Path $BinDir "mde-gen.ps1"
Set-Content -Path $PowerShellFile -Value $PowerShellContent -Encoding UTF8

Write-Host "[OK] Files copied successfully!" -ForegroundColor Green
Write-Host ""

# Add to PATH
$CurrentPath = [Environment]::GetEnvironmentVariable("Path", $Scope)

if ($CurrentPath -like "*$BinDir*") {
    Write-Host "[OK] Already in PATH: $BinDir" -ForegroundColor Green
} else {
    Write-Host "Adding to PATH: $BinDir" -ForegroundColor Cyan
    
    try {
        $NewPath = "$CurrentPath;$BinDir"
        [Environment]::SetEnvironmentVariable("Path", $NewPath, $Scope)
        Write-Host "[OK] Successfully added to PATH!" -ForegroundColor Green
    } catch {
        Write-Host "ERROR: Failed to update PATH" -ForegroundColor Red
        Write-Host $_.Exception.Message -ForegroundColor Red
        
        if ($Scope -eq "Machine") {
            Write-Host ""
            Write-Host "TIP: Run PowerShell as Administrator to modify system PATH" -ForegroundColor Yellow
        }
        exit 1
    }
}

# Set MDE_EXAMPLES environment variable
Write-Host "Setting up MDE_EXAMPLES environment variable..." -ForegroundColor Cyan
[Environment]::SetEnvironmentVariable("MDE_EXAMPLES", $ExamplesDir, $Scope)
Write-Host "[OK] MDE_EXAMPLES = $ExamplesDir" -ForegroundColor Green

Write-Host ""
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host "    Installation Complete!" -ForegroundColor Green
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Installation directory: $InstallPath" -ForegroundColor Cyan
Write-Host "Examples location:      `$env:MDE_EXAMPLES" -ForegroundColor Cyan
Write-Host ""
Write-Host "IMPORTANT: Restart your terminal for changes to take effect." -ForegroundColor Yellow
Write-Host ""
Write-Host "After restarting, you can use 'mde-gen' from anywhere:" -ForegroundColor Cyan
Write-Host "  mde-gen --help" -ForegroundColor White
Write-Host "  mde-gen generate `$env:MDE_EXAMPLES\healthcare-system.yaml" -ForegroundColor White
Write-Host "  mde-gen validate `$env:MDE_EXAMPLES\social-media-platform.yaml" -ForegroundColor White
Write-Host ""
Write-Host "To uninstall, run:" -ForegroundColor Gray
Write-Host "  Remove-Item -Recurse -Force '$InstallPath'" -ForegroundColor White
Write-Host "  Then manually remove '$BinDir' from PATH" -ForegroundColor White
