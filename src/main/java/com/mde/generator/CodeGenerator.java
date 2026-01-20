package com.mde.generator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.mde.cli.ConsoleSymbols;
import com.mde.generator.egl.EGLTemplateEngine;
import com.mde.generator.etl.ETLTransformationEngine;
import com.mde.loader.FlexmiModelLoader;
import ModelDrivenEngineering.BackendConfig;

/**
 * Code Generator - Main Orchestrator
 * 
 * Coordinates the complete model-driven code generation pipeline:
 * 1. Parse YAML → BackendConfig model (T2M via Flexmi)
 * 2. Transform BackendConfig → Context model (M2M via ETL)
 * 3. Generate Java code from Context model (M2T via EGL)
 * 4. Write generated files to filesystem
 * 
 * This class demonstrates the complete MDE transformation chain.
 */
public class CodeGenerator {

    // ANSI color codes
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    
    private final FlexmiModelLoader modelLoader;
    private final ETLTransformationEngine etlEngine;
    private final Path tempDirectory;
    
    /**
     * Constructor
     */
    public CodeGenerator() {
        this.modelLoader = new FlexmiModelLoader();
        this.etlEngine = new ETLTransformationEngine();
        
        // Create temp directory for intermediate models
        try {
            this.tempDirectory = Files.createTempDirectory("mde-generator-");
        } catch (Exception e) {
            throw new RuntimeException("Failed to create temp directory", e);
        }
    }
    
    /**
     * Generate complete Spring Boot project from YAML configuration
     * 
     * @param yamlFile Path to input YAML file
     * @param outputDirectory Path where project will be generated
     * @return Path to generated project root
     * @throws Exception if generation fails
     */
    public Path generateProject(Path yamlFile, Path outputDirectory) throws Exception {
        System.out.println("\n" + GREEN + ConsoleSymbols.SUCCESS + " MDE Backend Generator" + RESET);
        System.out.println(CYAN + "Input:  " + RESET + yamlFile.getFileName());
        System.out.println(CYAN + "Output: " + RESET + outputDirectory.toAbsolutePath());
        System.out.println();
        
        // Validate input
        if (!Files.exists(yamlFile)) {
            throw new IllegalArgumentException("Input YAML file not found: " + yamlFile);
        }
        
        // Create output directory
        Files.createDirectories(outputDirectory);
        
        try {
            // PHASE 1: Parse YAML → BackendConfig model (T2M)
            System.out.print(YELLOW + "[1/3]" + RESET + " Parsing YAML... ");
            BackendConfig backendConfig = modelLoader.load(yamlFile);
            System.out.println(GREEN + ConsoleSymbols.SUCCESS + " " + backendConfig.getProject().getName() + " (" + backendConfig.getDatabase().getTables().size() + " entities)" + RESET);
            
            // PHASE 2: BackendConfig → Context model (M2M)
            System.out.print(YELLOW + "[2/3]" + RESET + " Transforming model... ");
            Path contextModel = tempDirectory.resolve("context.xmi");
            etlEngine.executeTransformation(backendConfig, contextModel);
            System.out.println(GREEN + ConsoleSymbols.SUCCESS + RESET);
            
            // PHASE 3: Context model → Java code (M2T)
            System.out.print(YELLOW + "[3/3]" + RESET + " Generating code... ");
            EGLTemplateEngine eglEngine = new EGLTemplateEngine(outputDirectory);
            eglEngine.generateProject(contextModel);
            System.out.println(GREEN + ConsoleSymbols.SUCCESS + RESET);
            
            System.out.println("\n" + GREEN + BOLD + ConsoleSymbols.SUCCESS + " Project generated successfully!" + RESET);
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
            System.err.println("Usage: CodeGenerator <input.yaml> <output-directory>");
            System.exit(1);
        }
        
        try {
            Path inputYaml = Paths.get(args[0]);
            Path outputDir = Paths.get(args[1]);
            
            CodeGenerator generator = new CodeGenerator();
            generator.generateProject(inputYaml, outputDir);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
