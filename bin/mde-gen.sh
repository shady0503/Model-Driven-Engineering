#!/bin/bash
# MDE Backend Generator CLI Launcher (Linux/Mac Bash)
# This script is designed to be added to PATH for global access

# Get the directory where this script is located (bin/)
BIN_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Set the project root (parent of bin/)
PROJECT_ROOT="$(dirname "$BIN_DIR")"

# Set the JAR file path
JAR_FILE="$PROJECT_ROOT/target/mde-gen.jar"

# Check if JAR exists
if [ ! -f "$JAR_FILE" ]; then
    echo "Error: mde-gen.jar not found!"
    echo "Please run from project root: ./mvnw clean package"
    echo "Then the JAR will be at: target/mde-gen.jar"
    exit 1
fi

# Run the JAR with all arguments passed to this script
java -jar "$JAR_FILE" "$@"

# Pass through the exit code
exit $?
