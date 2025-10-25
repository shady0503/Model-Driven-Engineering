package com.mde.generator;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Command-line launcher for the MDE Code Generator
 * 
 * Usage:
 *   java -cp target/classes com.mde.generator.Main <input-yaml> <output-directory>
 * 
 * Examples:
 *   java -cp target/classes com.mde.generator.Main examples/blog-example.yaml output/blog
 */
public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: Main <input-yaml> <output-directory>");
            System.err.println("");
            System.err.println("Examples:");
            System.err.println("  Main examples/blog-example.yaml output/blog-project");
            System.err.println("  Main examples/minimal-example.yaml output/minimal-project");
            System.exit(1);
        }
        
        Path inputYaml = Paths.get(args[0]);
        Path outputDir = Paths.get(args[1]);
        
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);
    }
}
