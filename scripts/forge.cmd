@echo off
set "BASE_DIR=%USERPROFILE%\.codeforge"
set "JAR_PATH=%BASE_DIR%\bin\forge.jar"
set "EXAMPLES_DIR=%BASE_DIR%\examples"

if not exist "%JAR_PATH%" (
    echo [ERROR] CodeForge JAR not found at %JAR_PATH%
    echo Run 'make install' to set up the CLI correctly.
    exit /b 1
)

rem If first arg is generate/validate and second arg starts with examples/
set "CMD=%~1"
set "FILE=%~2"

if /i "%CMD%"=="generate" goto check_example
if /i "%CMD%"=="gen" goto check_example
if /i "%CMD%"=="validate" goto check_example
if /i "%CMD%"=="val" goto check_example
goto execute

:check_example
if "%FILE%"=="" goto execute
if not exist "%FILE%" (
    if exist "%EXAMPLES_DIR%\%FILE%" (
        set "FILE=%EXAMPLES_DIR%\%FILE%"
    ) else (
        rem Try adding .yaml extension
        if exist "%EXAMPLES_DIR%\%FILE%.yaml" (
            set "FILE=%EXAMPLES_DIR%\%FILE%.yaml"
        )
    )
)

rem Build the rest of the arguments
set "ARGS=%CMD% "%FILE%""
shift
shift
:args_loop
if "%~1"=="" goto run
set ARGS=%ARGS% %1
shift
goto args_loop

:run
java -jar "%JAR_PATH%" %ARGS%
exit /b %ERRORLEVEL%

:execute
java -jar "%JAR_PATH%" %*
exit /b %ERRORLEVEL%
