@echo off
set JAR_FILE=%~dp0..\target\mde-gen.jar
if not exist "%JAR_FILE%" (
    echo Error: mde-gen.jar not found!
    echo Please run: mvnw.cmd clean package
    exit /b 1
)
java -jar "%JAR_FILE%" %*
