#!/bin/bash
# MDE Backend Generator CLI Launcher (Linux/Mac Bash)
# This script allows you to run: mde-gen <command> [options]

# Get the directory where this script is located
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Set the JAR file path
JAR_FILE="$SCRIPT_DIR/target/mde-gen.jar"

# Check if JAR exists
if [ ! -f "$JAR_FILE" ]; then
    echo "Error: mde-gen.jar not found!"
    echo "Please run: ./mvnw clean package"
    echo "Then the JAR will be at: target/mde-gen.jar"
    exit 1
fi

# Run the JAR with all arguments passed to this script
java -jar "$JAR_FILE" "$@"

# Pass through the exit code
exit $?
