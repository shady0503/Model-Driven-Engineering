#!/usr/bin/env pwsh
# MDE Backend Generator CLI Launcher (PowerShell)
# This script is designed to be added to PATH for global access

# Get the directory where this script is located (bin/)
$BinDir = Split-Path -Parent $MyInvocation.MyCommand.Path

# Set the project root (parent of bin/)
$ProjectRoot = Split-Path -Parent $BinDir

# Set the JAR file path
$JarFile = Join-Path $ProjectRoot "target\mde-gen.jar"

# Check if JAR exists
if (-not (Test-Path $JarFile)) {
    Write-Host "Error: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Please run from project root: .\mvnw.cmd clean package"
    Write-Host "Then the JAR will be at: target\mde-gen.jar"
    exit 1
}

# Run the JAR with all arguments passed to this script
& java -jar $JarFile $args

# Pass through the exit code
exit $LASTEXITCODE
