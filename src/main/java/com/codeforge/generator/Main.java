package com.codeforge.generator;

import com.codeforge.cli.ForgeCli;

/**
 * Command-line launcher for the Forge Code Generator
 * 
 * This is a simple wrapper that delegates to the new Picocli-based CLI.
 * 
 * Usage:
 * java -cp target/classes com.codeforge.generator.Main generate <input-yaml>
 * [OPTIONS]
 * java -cp target/classes com.codeforge.generator.Main validate <input-yaml>
 * [OPTIONS]
 * java -cp target/classes com.codeforge.generator.Main --help
 * 
 * Examples:
 * java -cp target/classes com.codeforge.generator.Main generate
 * examples/blog-example.yaml -o output/blog
 * java -cp target/classes com.codeforge.generator.Main validate
 * examples/healthcare-system.yaml
 */
public class Main {
    public static void main(String[] args) {
        // Delegate to the new Picocli CLI
        ForgeCli.main(args);
    }
}
