package com.mde.generator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.mde.generator.egl.EGLTemplateEngine;
import com.mde.generator.etl.ETLTransformationEngine;
import com.mde.loader.FlexmiModelLoader;
import com.mde.ModelDrivenEngineering.BackendConfig;

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
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     MODEL-DRIVEN BACKEND CODE GENERATOR               ║");
        System.out.println("║     Eclipse Epsilon Transformation Pipeline           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Input YAML:     " + yamlFile);
        System.out.println("Output Project: " + outputDirectory);
        System.out.println();
        
        // Validate input
        if (!Files.exists(yamlFile)) {
            throw new IllegalArgumentException("Input YAML file not found: " + yamlFile);
        }
        
        // Create output directory
        Files.createDirectories(outputDirectory);
        
        try {
            // PHASE 1: Parse YAML → BackendConfig model (T2M)
            System.out.println("┌─────────────────────────────────────────────────────┐");
            System.out.println("│ PHASE 1: Text-to-Model Transformation (T2M/Flexmi) │");
            System.out.println("└─────────────────────────────────────────────────────┘");
            BackendConfig backendConfig = modelLoader.load(yamlFile);
            System.out.println("✓ YAML parsed successfully");
            System.out.println("  Project: " + backendConfig.getProject().getName());
            System.out.println("  Tables:  " + backendConfig.getDatabase().getTables().size());
            System.out.println();
            
            // PHASE 2: BackendConfig → Context model (M2M)
            System.out.println("┌─────────────────────────────────────────────────────┐");
            System.out.println("│ PHASE 2: Model-to-Model Transformation (M2M/ETL)   │");
            System.out.println("└─────────────────────────────────────────────────────┘");
            Path contextModel = tempDirectory.resolve("context.xmi");
            etlEngine.executeTransformation(backendConfig, contextModel);
            System.out.println();
            
            // PHASE 3: Context model → Java code (M2T)
            System.out.println("┌─────────────────────────────────────────────────────┐");
            System.out.println("│ PHASE 3: Model-to-Text Transformation (M2T/EGL)    │");
            System.out.println("└─────────────────────────────────────────────────────┘");
            EGLTemplateEngine eglEngine = new EGLTemplateEngine(outputDirectory);
            eglEngine.generateProject(contextModel);
            System.out.println();
            
            // Success!
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║            ✓ GENERATION SUCCESSFUL!                   ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("Generated project location:");
            System.out.println("  " + outputDirectory.toAbsolutePath());
            System.out.println();
            System.out.println("Next steps:");
            System.out.println("  1. cd " + outputDirectory.toAbsolutePath());
            System.out.println("  2. mvn clean install");
            System.out.println("  3. docker-compose up -d");
            System.out.println("  4. mvn spring-boot:run");
            System.out.println();
            
            return outputDirectory;
            
        } catch (Exception e) {
            System.err.println("\n❌ Generation failed: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            // Cleanup temp files (optional - keep for debugging)
            // Files.deleteIfExists(tempDirectory);
            System.out.println("Temporary files kept for debugging: " + tempDirectory);
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
