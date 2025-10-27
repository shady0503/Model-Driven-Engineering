package com.mde.cli;

import com.mde.generator.CodeGenerator;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

/**
 * CLI command to generate a Spring Boot project from a YAML model file.
 */
@Command(
    name = "generate",
    aliases = {"gen", "g"},
    description = "Generate a Spring Boot project from a YAML model file",
    mixinStandardHelpOptions = true,
    headerHeading = "%n",
    synopsisHeading = "%nUsage: ",
    descriptionHeading = "%nDescription:%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n",
    footerHeading = "%n",
    footer = {
        "Examples:",
        "  mde-gen generate examples/healthcare-system.yaml",
        "  mde-gen generate examples/blog.yaml -o ./my-blog-api",
        "  mde-gen generate examples/trading.yaml -o ./output --clean --overwrite",
        "  mde-gen -v generate examples/social-media.yaml"
    }
)
public class GenerateCommand implements Callable<Integer> {
    
    @ParentCommand
    private MdeGenCli parent;
    
    @Parameters(
        index = "0",
        description = "Path to the YAML model file (e.g., examples/healthcare-system.yaml)",
        paramLabel = "<yaml-file>"
    )
    private File yamlFile;
    
    @Option(
        names = {"-o", "--output-dir"},
        description = "Directory where the project will be generated (default: ./generated-project)",
        paramLabel = "<directory>"
    )
    private File outputDir = new File("./generated-project");
    
    @Option(
        names = {"--overwrite"},
        description = "Overwrite existing files without prompting"
    )
    private boolean overwrite;
    
    @Option(
        names = {"--clean"},
        description = "Clean output directory before generation"
    )
    private boolean clean;
    
    @Option(
        names = {"--no-zip"},
        description = "Don't create ZIP archive of generated project"
    )
    private boolean noZip;
    
    @Option(
        names = {"--skip-validation"},
        description = "Skip validation before generation (not recommended)"
    )
    private boolean skipValidation;
    
    @Override
    public Integer call() throws Exception {
        ColorOutput out = new ColorOutput(parent.isNoColor());
        boolean verbose = parent.isVerbose();
        
        // Set verbose system property for exception handler
        if (verbose) {
            System.setProperty("mde.verbose", "true");
        }
        
        // Print header
        out.banner("MODEL-DRIVEN BACKEND CODE GENERATOR", true);
        out.info("Eclipse Epsilon Transformation Pipeline");
        System.out.println();
        
        // Validate input file exists
        if (!yamlFile.exists()) {
            throw new java.io.FileNotFoundException("YAML file not found: " + yamlFile.getAbsolutePath());
        }
        
        if (verbose) {
            out.info("[VERBOSE] Loading YAML file: " + yamlFile.getAbsolutePath());
            out.info("[VERBOSE] File size: " + formatFileSize(yamlFile.length()));
        }
        
        // Display configuration
        out.info("Input YAML:     " + yamlFile.getAbsolutePath());
        out.info("Output Project: " + outputDir.getAbsolutePath());
        System.out.println();
        
        // Clean output directory if requested
        if (clean && outputDir.exists()) {
            if (verbose) {
                out.info("[VERBOSE] Cleaning output directory: " + outputDir.getAbsolutePath());
            }
            deleteDirectory(outputDir.toPath());
        }
        
        // Check if output directory exists and prompt if needed
        if (outputDir.exists() && !overwrite && !clean) {
            out.warning("⚠ Output directory already exists: " + outputDir.getAbsolutePath());
            out.warning("  Use --clean to remove existing files or --overwrite to replace them");
            return ExitCode.CONFIG_ERROR;
        }
        
        // Create output directory
        if (!outputDir.exists()) {
            outputDir.mkdirs();
            if (verbose) {
                out.info("[VERBOSE] Created output directory: " + outputDir.getAbsolutePath());
            }
        }
        
        try {
            // Initialize code generator
            long startTime = System.currentTimeMillis();
            
            if (verbose) {
                out.info("[VERBOSE] Initializing code generator...");
            }
            
            CodeGenerator generator = new CodeGenerator();
            
            // Generate project
            Path inputPath = yamlFile.toPath();
            Path outputPath = outputDir.toPath();
            
            if (verbose) {
                out.info("[VERBOSE] Starting generation pipeline...");
            }
            
            generator.generateProject(inputPath, outputPath);
            
            long duration = System.currentTimeMillis() - startTime;
            
            // Success message
            System.out.println();
            out.banner(ConsoleSymbols.success("GENERATION SUCCESSFUL!"), true);
            System.out.println();
            out.success("Generated project: " + outputDir.getAbsolutePath());
            System.out.println();
            
            if (verbose) {
                out.info("[VERBOSE] Total generation time: " + formatDuration(duration));
                out.info("[VERBOSE] Peak memory usage: " + formatMemoryUsage());
            }
            
            // Print next steps
            out.info("Next steps:");
            out.print("  cd " + outputDir.getPath());
            out.print("  mvn clean install");
            out.print("  docker-compose up -d");
            out.print("  mvn spring-boot:run");
            
            return ExitCode.SUCCESS;
            
        } catch (Exception e) {
            out.error(ConsoleSymbols.error("GENERATION FAILED"));
            System.err.println();
            
            if (verbose) {
                out.error("[VERBOSE] Error details:");
                e.printStackTrace(System.err);
            }
            
            throw e; // Let the exception handler deal with it
        }
    }
    
    /**
     * Format file size in human-readable format.
     */
    private String formatFileSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
    }
    
    /**
     * Format duration in human-readable format.
     */
    private String formatDuration(long millis) {
        if (millis < 1000) return millis + "ms";
        return String.format("%.1f seconds", millis / 1000.0);
    }
    
    /**
     * Format memory usage in human-readable format.
     */
    private String formatMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        return String.format("%.1f MB", usedMemory / (1024.0 * 1024.0));
    }
    
    /**
     * Recursively delete a directory.
     */
    private void deleteDirectory(Path path) throws Exception {
        if (Files.exists(path)) {
            Files.walk(path)
                .sorted((a, b) -> -a.compareTo(b)) // Delete files before directories
                .forEach(p -> {
                    try {
                        Files.delete(p);
                    } catch (Exception e) {
                        // Ignore deletion errors
                    }
                });
        }
    }
}
