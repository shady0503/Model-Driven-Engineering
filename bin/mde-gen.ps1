$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$JarFile = Join-Path $ScriptDir "..\target\mde-gen.jar"
if (-not (Test-Path $JarFile)) {
    Write-Host "Error: mde-gen.jar not found!" -ForegroundColor Red
    Write-Host "Please run: .\mvnw.cmd clean package" -ForegroundColor Yellow
    exit 1
}
& java -jar $JarFile $args
exit $LASTEXITCODE
