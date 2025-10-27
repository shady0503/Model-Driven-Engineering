package com.mde.generator;

import com.mde.cli.MdeGenCli;

/**
 * Command-line launcher for the MDE Code Generator
 * 
 * This is a simple wrapper that delegates to the new Picocli-based CLI.
 * 
 * Usage:
 *   java -cp target/classes com.mde.generator.Main generate <input-yaml> [OPTIONS]
 *   java -cp target/classes com.mde.generator.Main validate <input-yaml> [OPTIONS]
 *   java -cp target/classes com.mde.generator.Main --help
 * 
 * Examples:
 *   java -cp target/classes com.mde.generator.Main generate examples/blog-example.yaml -o output/blog
 *   java -cp target/classes com.mde.generator.Main validate examples/healthcare-system.yaml
 */
public class Main {
    public static void main(String[] args) {
        // Delegate to the new Picocli CLI
        MdeGenCli.main(args);
    }
}
