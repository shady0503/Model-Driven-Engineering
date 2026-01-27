# CodeForge Makefile for Windows

REPO_ROOT := $(CURDIR)
BIN_DIR := $(USERPROFILE)\.codeforge\bin
EXAMPLES_DIR := $(USERPROFILE)\.codeforge\examples
JAR_NAME := forge.jar
TARGET_JAR := $(REPO_ROOT)\target\$(JAR_NAME)
WRAPPER := $(REPO_ROOT)\scripts\forge.cmd
EXAMPLES_SRC := $(REPO_ROOT)\examples

.PHONY: all build install clean help

all: build install


build:
	@echo [1/2] Building CodeForge project...
	@cmd /c "mvnw.cmd clean package -DskipTests"
	@echo [2/2] Build complete.

install: build
	@echo [1/3] Creating installation directories...
	@powershell -Command "New-Item -ItemType Directory -Force -Path '$(BIN_DIR)', '$(EXAMPLES_DIR)' | Out-Null"
	
	@echo [2/3] Installing JAR, wrapper and examples...
	@powershell -Command " \
		$$jar = Get-ChildItem -Path '$(REPO_ROOT)\target' -Filter 'forge*.jar' | Sort-Object Length -Descending | Select-Object -First 1; \
		if ($$jar) { \
			Copy-Item -Path $$jar.FullName -Destination '$(BIN_DIR)\$(JAR_NAME)' -Force; \
		} else { \
			Write-Error 'Could not find forge jar in target directory'; exit 1; \
		}; \
		Copy-Item -Path '$(WRAPPER)' -Destination '$(BIN_DIR)\forge.cmd' -Force; \
		if (Test-Path '$(EXAMPLES_SRC)') { \
			Copy-Item -Path '$(EXAMPLES_SRC)\*' -Destination '$(EXAMPLES_DIR)' -Recurse -Force; \
		}"
	
	@echo [3/3] Updating User PATH permanently...
	@powershell -ExecutionPolicy Bypass -Command "\
		$$binPath = '$(BIN_DIR)'; \
		$$oldPath = [Environment]::GetEnvironmentVariable('Path', 'User'); \
		if ($$oldPath -notlike '*'+$$binPath+'*') { \
			[Environment]::SetEnvironmentVariable('Path', $$oldPath + ';' + $$binPath, 'User'); \
			Write-Host 'PATH updated. Please restart your terminal.'; \
		} else { \
			Write-Host 'PATH already contains CodeForge bin directory.'; \
		}"
	
	@echo.
	@echo [SUCCESS] CodeForge installed! Open a NEW terminal and type 'forge --help'.

clean:
	@echo Cleaning project...
	@cmd /c "mvnw.cmd clean"
	@powershell -Command "if (Test-Path '$(BIN_DIR)') { Remove-Item -Path '$(BIN_DIR)' -Recurse -Force }"
	@powershell -Command "if (Test-Path '$(EXAMPLES_DIR)') { Remove-Item -Path '$(EXAMPLES_DIR)' -Recurse -Force }"

help:
	@echo CodeForge Build System
	@echo.
	@echo Targets:
	@echo   build    - Compile the project and generate the JAR
	@echo   install  - Build and install the CLI globally (requires PATH update)
	@echo   clean    - Remove build artifacts and local installation
	@echo   help     - Show this help message
