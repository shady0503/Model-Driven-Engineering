#!/usr/bin/env pwsh
# MDE Backend Generator CLI Launcher (PowerShell)
# This script allows you to run: mde-gen <command> [options]

# Get the directory where this script is located
$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path

# Set the JAR file path
$JarFile = Join-Path $ScriptDir "target\mde-gen.jar"

# Check if JAR exists
if (-not (Test-Path $JarFile)) {
    Write-Host "Error: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Please run: .\mvnw.cmd clean package"
    Write-Host "Then the JAR will be at: target\mde-gen.jar"
    exit 1
}

# Run the JAR with all arguments passed to this script
& java -jar $JarFile $args

# Pass through the exit code
exit $LASTEXITCODE
