#!/usr/bin/env bash
# Runs the Spring Boot backend with environment variables loaded from .env.
# I am tired of trying to make the IntelliJ Maven config setup work, so this is what we're doing now.
# Usage:
#   ./run-backend.sh

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ENV_FILE="$ROOT_DIR/.env"

if [[ ! -f "$ENV_FILE" ]]; then
  echo "Could not find .env file at $ENV_FILE" >&2
  exit 1
fi

while IFS= read -r line; do
  line="${line%%#*}"
  line="${line%%$'\r'}"
  if [[ -z "$line" ]]; then
    continue
  fi
  if [[ "$line" == *=* ]]; then
    key="${line%%=*}"
    value="${line#*=}"
    export "$key=$value"
  fi
done < "$ENV_FILE"

cd "$ROOT_DIR/backend"
./mvnw spring-boot:run
