# MDE Generator - PATH Removal Script
# This script removes the MDE\bin directory from your PATH environment variable

param(
    [switch]$System
)

$ErrorActionPreference = "Stop"

Write-Host "==================================================" -ForegroundColor Cyan
Write-Host "    MDE Generator - PATH Removal" -ForegroundColor Cyan
Write-Host "==================================================" -ForegroundColor Cyan
Write-Host ""

# Determine the MDE installation directory
$MdeRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$BinDir = Join-Path $MdeRoot "bin"

# Determine scope
$Scope = "User"
if ($System) {
    $Scope = "Machine"
    Write-Host "Removing from: System PATH (All Users)" -ForegroundColor Yellow
} else {
    Write-Host "Removing from: User PATH (Current User)" -ForegroundColor Cyan
}

Write-Host ""

# Get current PATH
$CurrentPath = [Environment]::GetEnvironmentVariable("Path", $Scope)

# Check if in PATH
if ($CurrentPath -like "*$BinDir*") {
    Write-Host "Removing from PATH: $BinDir" -ForegroundColor Yellow
    
    try {
        # Remove from PATH (handle both ;C:\path and C:\path; cases)
        $NewPath = $CurrentPath -replace [regex]::Escape(";$BinDir"), "" -replace [regex]::Escape("$BinDir;"), ""
        $NewPath = $NewPath -replace [regex]::Escape($BinDir), ""
        
        [Environment]::SetEnvironmentVariable("Path", $NewPath, $Scope)
        
        Write-Host "[OK] Successfully removed from PATH!" -ForegroundColor Green
        Write-Host ""
        Write-Host "NOTE: Restart your terminal for changes to take effect." -ForegroundColor Yellow
    } catch {
        Write-Host "ERROR: Failed to update PATH" -ForegroundColor Red
        Write-Host $_.Exception.Message -ForegroundColor Red
        exit 1
    }
} else {
    Write-Host "Directory not found in PATH: $BinDir" -ForegroundColor Gray
    Write-Host "Nothing to remove." -ForegroundColor Gray
}

Write-Host ""

# Remove MDE_EXAMPLES environment variable
Write-Host "Removing MDE_EXAMPLES environment variable..." -ForegroundColor Yellow
[Environment]::SetEnvironmentVariable("MDE_EXAMPLES", $null, $Scope)
Write-Host "[OK] MDE_EXAMPLES removed" -ForegroundColor Green

Write-Host ""
Write-Host "Uninstall complete." -ForegroundColor Green
