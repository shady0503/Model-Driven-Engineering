# MDE Generator - PATH Setup Script
# This script adds the MDE\bin directory to your PATH environment variable

param(
    [switch]$User,
    [switch]$System
)

$ErrorActionPreference = "Stop"

Write-Host "==================================================" -ForegroundColor Cyan
Write-Host "    MDE Generator - PATH Setup" -ForegroundColor Cyan
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host ""

# Determine the MDE installation directory
$MdeRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$BinDir = Join-Path $MdeRoot "bin"

# Create bin directory if it doesn't exist
if (-not (Test-Path $BinDir)) {
    Write-Host "Creating bin directory..." -ForegroundColor Yellow
    New-Item -ItemType Directory -Path $BinDir -Force | Out-Null
}

# Create examples directory in bin
$ExamplesDir = Join-Path $BinDir "examples"
if (-not (Test-Path $ExamplesDir)) {
    Write-Host "Creating examples directory..." -ForegroundColor Yellow
    New-Item -ItemType Directory -Path $ExamplesDir -Force | Out-Null
}

# Copy example YAML files
Write-Host "Copying example files..." -ForegroundColor Cyan
$SourceExamplesDir = Join-Path $MdeRoot "examples"
if (Test-Path $SourceExamplesDir) {
    Get-ChildItem -Path $SourceExamplesDir -Filter "*.yaml" | ForEach-Object {
        Copy-Item $_.FullName -Destination $ExamplesDir -Force
        Write-Host "  Copied: $($_.Name)" -ForegroundColor Green
    }
}

# Copy executable scripts to bin directory
Write-Host "Copying executable scripts to bin..." -ForegroundColor Cyan

$JarFile = Join-Path $MdeRoot "target\mde-gen.jar"
if (-not (Test-Path $JarFile)) {
    Write-Host "ERROR: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Please run: .\mvnw.cmd clean package" -ForegroundColor Yellow
    exit 1
}

# Create mde-gen.bat in bin directory
$BatchContent = @"
@echo off
set JAR_FILE=%~dp0..\target\mde-gen.jar
if not exist "%JAR_FILE%" (
    echo Error: mde-gen.jar not found!
    echo Please run: mvnw.cmd clean package
    exit /b 1
)
java -jar "%JAR_FILE%" %*
"@

$BatchFile = Join-Path $BinDir "mde-gen.bat"
Set-Content -Path $BatchFile -Value $BatchContent -Encoding ASCII
Write-Host "  Created: $BatchFile" -ForegroundColor Green

# Create mde-gen.ps1 in bin directory
$PowerShellContent = @'
$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$JarFile = Join-Path $ScriptDir "..\target\mde-gen.jar"
if (-not (Test-Path $JarFile)) {
    Write-Host "Error: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Please run: .\mvnw.cmd clean package" -ForegroundColor Yellow
    exit 1
}
& java -jar $JarFile $args
exit $LASTEXITCODE
'@

$PowerShellFile = Join-Path $BinDir "mde-gen.ps1"
Set-Content -Path $PowerShellFile -Value $PowerShellContent -Encoding UTF8
Write-Host "  Created: $PowerShellFile" -ForegroundColor Green

Write-Host ""

# Determine scope
$Scope = "User"
if ($System) {
    $Scope = "Machine"
    Write-Host "Installing for: All Users (System-wide)" -ForegroundColor Yellow
    Write-Host "NOTE: This requires Administrator privileges" -ForegroundColor Yellow
} else {
    Write-Host "Installing for: Current User" -ForegroundColor Cyan
}

Write-Host ""

# Get current PATH
$CurrentPath = [Environment]::GetEnvironmentVariable("Path", $Scope)

# Always set MDE_EXAMPLES environment variable
Write-Host "Setting up MDE_EXAMPLES environment variable..." -ForegroundColor Cyan
[Environment]::SetEnvironmentVariable("MDE_EXAMPLES", "$BinDir\examples", $Scope)
Write-Host "[OK] MDE_EXAMPLES = $BinDir\examples" -ForegroundColor Green
Write-Host ""

# Check if already in PATH
if ($CurrentPath -like "*$BinDir*") {
    Write-Host "[OK] Directory already in PATH: $BinDir" -ForegroundColor Green
} else {
    Write-Host "Adding to PATH: $BinDir" -ForegroundColor Cyan
    
    try {
        # Add to PATH
        $NewPath = "$CurrentPath;$BinDir"
        [Environment]::SetEnvironmentVariable("Path", $NewPath, $Scope)
        
        Write-Host "[OK] Successfully added to PATH!" -ForegroundColor Green
        Write-Host ""
        Write-Host "IMPORTANT: You need to restart your terminal for changes to take effect." -ForegroundColor Yellow
        Write-Host ""
        Write-Host "After restarting, you can use 'mde-gen' from anywhere:" -ForegroundColor Cyan
        Write-Host "  mde-gen --help" -ForegroundColor White
        Write-Host "  mde-gen generate `$env:MDE_EXAMPLES\healthcare-system.yaml" -ForegroundColor White
        Write-Host "  mde-gen validate `$env:MDE_EXAMPLES\social-media-platform.yaml" -ForegroundColor White
        Write-Host ""
        Write-Host "Quick access to examples: `$env:MDE_EXAMPLES" -ForegroundColor Cyan
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

Write-Host ""
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host "    Setup Complete!" -ForegroundColor Green
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Next Steps:" -ForegroundColor Cyan
Write-Host "  1. Close and reopen your terminal" -ForegroundColor White
Write-Host "  2. Run: mde-gen --help" -ForegroundColor White
Write-Host ""
Write-Host "To uninstall, run: .\uninstall-path.ps1" -ForegroundColor Gray
