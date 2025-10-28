@echo off
REM MDE Backend Generator CLI Launcher (Windows Batch)
REM This script is designed to be added to PATH for global access

REM Get the directory where this script is located (bin/)
set BIN_DIR=%~dp0

REM Set the project root (parent of bin/)
for %%I in ("%BIN_DIR%..") do set PROJECT_ROOT=%%~fI

REM Set the JAR file path
set JAR_FILE=%PROJECT_ROOT%\target\mde-gen.jar

REM Check if JAR exists
if not exist "%JAR_FILE%" (
    echo Error: mde-gen.jar not found!
    echo Please run from project root: mvnw.cmd clean package
    echo Then the JAR will be at: target\mde-gen.jar
    exit /b 1
)

REM Run the JAR with all arguments passed to this script
java -jar "%JAR_FILE%" %*
