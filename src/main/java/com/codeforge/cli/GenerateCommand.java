package com.codeforge.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;
import com.codeforge.generator.ForgeGenerator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

/**
 * CLI command to generate a Spring Boot project from a YAML model file.
 */
@Command(name = "generate", aliases = { "gen",
        "g" }, description = "Generate a Spring Boot project from a YAML model file", mixinStandardHelpOptions = true, headerHeading = "%n", synopsisHeading = "%nUsage: ", descriptionHeading = "%nDescription:%n", parameterListHeading = "%nParameters:%n", optionListHeading = "%nOptions:%n", footerHeading = "%n", footer = {
                "Examples:",
                "  Forge-gen generate examples/healthcare-system.yaml",
                "  Forge-gen generate examples/blog.yaml -o ./my-blog-api",
                "  Forge-gen generate examples/trading.yaml -o ./output --clean --overwrite",
                "  Forge-gen -v generate examples/social-media.yaml"
        })
public class GenerateCommand implements Callable<Integer> {

    @ParentCommand
    private ForgeCli parent;

    @Parameters(index = "0", description = "Path to the YAML model file (e.g., examples/healthcare-system.yaml)", paramLabel = "<yaml-file>")
    private File yamlFile;

    @Option(names = { "-o",
            "--output-dir" }, description = "Directory where the project will be generated (default: ./generated-project)", paramLabel = "<directory>")
    private File outputDir = new File("./generated-project");

    @Option(names = { "--overwrite" }, description = "Overwrite existing files without prompting")
    private boolean overwrite;

    @Option(names = { "--clean" }, description = "Clean output directory before generation")
    private boolean clean;

    @Option(names = { "--no-zip" }, description = "Don't create ZIP archive of generated project")
    private boolean noZip;

    @Option(names = { "--skip-validation" }, description = "Skip validation before generation (not recommended)")
    private boolean skipValidation;

    @Override
    public Integer call() throws Exception {
        ColorOutput out = new ColorOutput(parent.isNoColor());
        boolean verbose = parent.isVerbose();

        // Set verbose system property for exception handler
        if (verbose) {
            System.setProperty("Forge.verbose", "true");
        }

        // Print header
        out.banner("MODEL-DRIVEN BACKEND CODE GENERATOR", true);
        out.info("Eclipse Epsilon Transformation Pipeline");
        System.out.println();

        // Auto-detect YAML file if directory is provided
        if (yamlFile.isDirectory()) {
            File detectedYaml = detectYamlFileInDirectory(yamlFile);
            if (detectedYaml != null) {
                if (verbose) {
                    out.info("[VERBOSE] Auto-detected YAML file: " + detectedYaml.getName());
                }
                yamlFile = detectedYaml;
            } else {
                out.error("No YAML file found in directory: " + yamlFile.getAbsolutePath());
                out.info("Expected files like: config.yaml, model.yaml, or *.yaml");
                return ExitCode.INPUT_ERROR;
            }
        }

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
        out.info("Output Project: " + outputDir.toPath().toAbsolutePath().normalize().toFile().getAbsolutePath());
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
            // Only warn if directory contains generated project files (not just YAML)
            if (containsGeneratedProjectFiles(outputDir)) {
                // If input and output are in the same directory, this is likely a regeneration
                // Don't warn - just proceed with overwrite
                File inputDir = yamlFile.getParentFile();
                if (inputDir != null && inputDir.getAbsolutePath().equals(outputDir.getAbsolutePath())) {
                    if (verbose) {
                        out.info("[VERBOSE] Regenerating in same directory - auto-enabling overwrite");
                    }
                    overwrite = true; // Auto-enable overwrite for same-directory regeneration
                } else {
                    out.warning("⚠ Output directory already exists: " + outputDir.getAbsolutePath());
                    out.warning("  Use --clean to remove existing files or --overwrite to replace them");
                    return ExitCode.CONFIG_ERROR;
                }
            }
            // If directory only contains YAML or other non-project files, proceed without
            // warning
            if (verbose) {
                out.info("[VERBOSE] Output directory exists but contains no generated project files");
            }
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
            if (verbose) {
                out.info("[VERBOSE] Initializing code generator...");
            }

            ForgeGenerator generator = createGenerator();

            // Generate project
            Path inputPath = yamlFile.toPath();
            Path outputPath = outputDir.toPath();

            if (verbose) {
                out.info("[VERBOSE] Starting generation pipeline...");
            }

            generator.generateProject(inputPath, outputPath);

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
        if (bytes < 1024)
            return bytes + " B";
        if (bytes < 1024 * 1024)
            return String.format("%.1f KB", bytes / 1024.0);
        return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
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

    /**
     * Auto-detect YAML file in a directory.
     * Looks for common names first, then falls back to any .yaml file.
     */
    private File detectYamlFileInDirectory(File directory) {
        if (!directory.isDirectory()) {
            return null;
        }

        // Priority list of common YAML file names
        String[] commonNames = {
                "model.yaml", "config.yaml", "backend.yaml",
                "model.yml", "config.yml", "backend.yml"
        };

        // Check common names first
        for (String name : commonNames) {
            File candidate = new File(directory, name);
            if (candidate.exists() && candidate.isFile()) {
                return candidate;
            }
        }

        // Fall back to first .yaml or .yml file found
        File[] yamlFiles = directory
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".yaml") || name.toLowerCase().endsWith(".yml"));

        if (yamlFiles != null && yamlFiles.length > 0) {
            return yamlFiles[0];
        }

        return null;
    }

    /**
     * Check if directory contains generated project files.
     * Returns true if it contains typical Spring Boot project structure.
     */
    private boolean containsGeneratedProjectFiles(File directory) {
        if (!directory.isDirectory()) {
            return false;
        }

        // Check for typical generated project indicators
        String[] projectIndicators = {
                "pom.xml", // Maven project file
                "src", // Source directory
                "docker-compose.yml", // Docker file
                "README.md" // Generated README
        };

        int matchCount = 0;
        for (String indicator : projectIndicators) {
            File file = new File(directory, indicator);
            if (file.exists()) {
                matchCount++;
            }
        }

        // If 2 or more indicators exist, consider it a generated project
        return matchCount >= 2;
    }

    protected ForgeGenerator createGenerator() {
        return new ForgeGenerator();
    }
}
