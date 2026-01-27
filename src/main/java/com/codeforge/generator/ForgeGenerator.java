package com.codeforge.generator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.codeforge.cli.ConsoleSymbols;
import com.codeforge.generator.egl.EGLTemplateEngine;
import com.codeforge.generator.evl.EVLValidationEngine;
import com.codeforge.loader.FlexmiModelLoader;
import com.codeforge.validation.ValidationResult;
import Forge.BackendConfig;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CodeForge Generator - Main Orchestrator
 * 
 * Coordinates the code generation pipeline:
 * 1. Parse YAML → Forge model (T2M via Flexmi)
 * 2. Generate Java code from model (M2T via EGL)
 * 3. Write generated files to filesystem
 */
public class ForgeGenerator {

    // ANSI color codes
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";

    private final FlexmiModelLoader modelLoader;

    /**
     * Constructor
     */
    public ForgeGenerator() {
        this.modelLoader = new FlexmiModelLoader();
    }

    /**
     * Generate complete Spring Boot project from YAML configuration
     * 
     * @param yamlFile        Path to input YAML file
     * @param outputDirectory Path where project will be generated
     * @return Path to generated project root
     * @throws Exception if generation fails
     */
    public Path generateProject(Path yamlFile, Path outputDirectory) throws Exception {
        System.out.println("\n" + GREEN + ConsoleSymbols.SUCCESS + " CodeForge Generator" + RESET);
        System.out.println(CYAN + "Input:  " + RESET + yamlFile.getFileName());
        System.out.println(CYAN + "Output: " + RESET + outputDirectory.toAbsolutePath().normalize());
        System.out.println();

        // Validate input
        if (!Files.exists(yamlFile)) {
            throw new IllegalArgumentException("Input YAML file not found: " + yamlFile);
        }

        // Create output directory
        Files.createDirectories(outputDirectory);

        try {
            // PHASE 1: Parse YAML → Forge model (T2M)
            System.out.print(YELLOW + "[1/2]" + RESET + " Parsing YAML... ");
            BackendConfig backendConfig = modelLoader.load(yamlFile);
            System.out.println(GREEN + ConsoleSymbols.SUCCESS + " "
                    + (backendConfig.getProject() != null ? backendConfig.getProject().getName() : "Project") + RESET);

            // PHASE 1.5: Validate model
            System.out.print(YELLOW + "[1.5/2]" + RESET + " Validating model... ");
            EVLValidationEngine validationEngine = new EVLValidationEngine();
            List<ValidationResult> validationResults = validationEngine.validate(backendConfig);

            List<ValidationResult> errors = validationResults.stream()
                    .filter(r -> r.getSeverity() == ValidationResult.Severity.ERROR)
                    .collect(Collectors.toList());

            if (!errors.isEmpty()) {
                System.out.println(ConsoleSymbols.ERROR + " Found " + errors.size() + " errors");
                for (ValidationResult error : errors) {
                    System.err.println("  - " + error.getMessage() + " (" + error.getLocation() + ")");
                }
                throw new Exception("Model validation failed. Generation aborted.");
            }
            System.out.println(GREEN + ConsoleSymbols.SUCCESS + RESET);

            // PHASE 2: Forge model → Java code (M2T)
            System.out.print(YELLOW + "[2/2]" + RESET + " Generating code... ");
            EGLTemplateEngine eglEngine = new EGLTemplateEngine(outputDirectory);
            eglEngine.generateProjectFromForge(backendConfig);
            System.out.println(GREEN + ConsoleSymbols.SUCCESS + RESET);

            System.out
                    .println("\n" + GREEN + BOLD + ConsoleSymbols.SUCCESS + " Project generated successfully!" + RESET);
            System.out.println("\n" + CYAN + "Quick start:" + RESET);
            System.out.println("  cd " + outputDirectory.toAbsolutePath());
            System.out.println("  docker compose up -d --build");

            return outputDirectory;

        } catch (Exception e) {
            System.err.println("\n" + ConsoleSymbols.ERROR + " Generation failed: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Main method for standalone testing
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: BackendGenerator <input.yaml> <output-directory>");
            System.exit(1);
        }

        try {
            Path inputYaml = Paths.get(args[0]);
            Path outputDir = Paths.get(args[1]);

            ForgeGenerator generator = new ForgeGenerator();
            generator.generateProject(inputYaml, outputDir);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
