<#
Runs the Spring Boot backend with environment variables loaded from .env.

Usage:
  .\run-backend.ps1

Notes:
- This script reads the .env file (ignoring blank lines and comments) and sets those variables for the current process.
- It then runs the Maven wrapper from the backend folder.
#>

$envFile = Join-Path $PSScriptRoot '.env'
if (-not (Test-Path $envFile)) {
    Write-Error "Could not find .env file at $envFile"
    exit 1
}

Get-Content $envFile | ForEach-Object {
    $line = $_.Trim()
    if (-not $line -or $line.StartsWith('#')) { return }

    $parts = $line -split '=', 2
    if ($parts.Length -ne 2) { return }

    $key = $parts[0].Trim()
    $value = $parts[1].Trim()
    if (-not $key) { return }

    # Export to current process environment
    Set-Item -Path "Env:$key" -Value $value
}

# Run the backend using the Maven wrapper
Push-Location (Join-Path $PSScriptRoot 'backend')
try {
    $mvnw = if ($IsWindows) { ".\\mvnw.cmd" } else { ".\\mvnw" }
    & $mvnw spring-boot:run
} finally {
    Pop-Location
}
