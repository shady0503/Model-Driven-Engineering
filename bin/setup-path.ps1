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

# Determine the bin directory (where this script is located)
$BinDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$MdeRoot = Split-Path -Parent $BinDir
$JarFile = Join-Path $MdeRoot "target\mde-gen.jar"

# Verify JAR file exists
if (-not (Test-Path $JarFile)) {
    Write-Host "ERROR: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Please run from project root: .\mvnw.cmd clean package" -ForegroundColor Yellow
    Write-Host "Expected location: $JarFile" -ForegroundColor Yellow
    exit 1
}

Write-Host "+ JAR file found: $JarFile" -ForegroundColor Green
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

# Set MDE_EXAMPLES environment variable to root examples directory
$ExamplesDir = Join-Path $MdeRoot "examples"
Write-Host "Setting up MDE_EXAMPLES environment variable..." -ForegroundColor Cyan
[Environment]::SetEnvironmentVariable("MDE_EXAMPLES", $ExamplesDir, $Scope)
Write-Host "[OK] MDE_EXAMPLES = $ExamplesDir" -ForegroundColor Green
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
