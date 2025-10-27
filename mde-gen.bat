@echo off
REM MDE Backend Generator CLI Launcher (Windows Batch)
REM This script allows you to run: mde-gen <command> [options]

REM Get the directory where this script is located
set SCRIPT_DIR=%~dp0

REM Set the JAR file path
set JAR_FILE=%SCRIPT_DIR%target\mde-gen.jar

REM Check if JAR exists
if not exist "%JAR_FILE%" (
    echo Error: mde-gen.jar not found!
    echo Please run: mvnw.cmd clean package
    echo Then the JAR will be at: target\mde-gen.jar
    exit /b 1
)

REM Run the JAR with all arguments passed to this script
java -jar "%JAR_FILE%" %*
