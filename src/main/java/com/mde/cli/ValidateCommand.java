package com.mde.cli;

import com.mde.loader.FlexmiModelLoaderWithValidation;
import com.mde.loader.LoadException;
import ModelDrivenEngineering.BackendConfig;
import com.mde.validation.ValidationResult;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * CLI command to validate a YAML model file without generating code.
 */
@Command(
    name = "validate",
    aliases = {"val", "v"},
    description = "Validate a YAML model file without generating code",
    mixinStandardHelpOptions = true,
    headerHeading = "%n",
    synopsisHeading = "%nUsage: ",
    descriptionHeading = "%nDescription:%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n",
    footerHeading = "%n",
    footer = {
        "Examples:",
        "  mde-gen validate examples/healthcare-system.yaml",
        "  mde-gen validate examples/blog.yaml --strict",
        "  mde-gen validate examples/trading.yaml --format json"
    }
)
public class ValidateCommand implements Callable<Integer> {
    
    @ParentCommand
    private MdeGenCli parent;
    
    @Parameters(
        index = "0",
        description = "Path to the YAML model file",
        paramLabel = "<yaml-file>"
    )
    private File yamlFile;
    
    @Option(
        names = {"-f", "--format"},
        description = "Output format: text, json (default: text)",
        paramLabel = "<format>"
    )
    private String format = "text";
    
    @Option(
        names = {"--strict"},
        description = "Treat warnings as errors"
    )
    private boolean strict;
    
    @Override
    public Integer call() throws Exception {
        ColorOutput out = new ColorOutput(parent.isNoColor());
        boolean verbose = parent.isVerbose();
        
        // Print header
        out.banner("YAML MODEL VALIDATION", true);
        System.out.println();
        out.info("File: " + yamlFile.getAbsolutePath());
        System.out.println();
        
        // Validate file exists
        if (!yamlFile.exists()) {
            throw new java.io.FileNotFoundException("YAML file not found: " + yamlFile.getAbsolutePath());
        }
        
        if (verbose) {
            out.info("[VERBOSE] Loading YAML file: " + yamlFile.getAbsolutePath());
            out.info("[VERBOSE] File size: " + formatFileSize(yamlFile.length()));
        }
        
        try {
            long startTime = System.currentTimeMillis();
            
            // Load and validate model
            if (verbose) {
                out.info("[VERBOSE] Parsing YAML...");
            }
            
            FlexmiModelLoaderWithValidation loader = new FlexmiModelLoaderWithValidation();
            Path yamlPath = yamlFile.toPath();
            BackendConfig config = loader.load(yamlPath);
            
            if (verbose) {
                long parseTime = System.currentTimeMillis() - startTime;
                out.info("[VERBOSE] Parsing complete (" + parseTime + "ms)");
            }
            
            // Validate the model
            if (verbose) {
                out.info("[VERBOSE] Running validation...");
            }
            
            List<ValidationResult> validationResults = loader.validate(config);
            
            int errorCount = 0;
            int warningCount = 0;
            int infoCount = 0;
            
            // Count issues by severity
            for (ValidationResult result : validationResults) {
                switch (result.getSeverity()) {
                    case ERROR:
                        errorCount++;
                        break;
                    case WARNING:
                        warningCount++;
                        break;
                    case INFO:
                        infoCount++;
                        break;
                }
            }
            
            if (format.equalsIgnoreCase("json")) {
                printJsonOutput(yamlFile, errorCount, warningCount, infoCount, validationResults);
            } else {
                printTextOutput(out, verbose, config, errorCount, warningCount, infoCount, validationResults);
            }
            
            // Determine exit code
            if (errorCount > 0) {
                return ExitCode.VALIDATION_ERROR;
            } else if (strict && warningCount > 0) {
                return ExitCode.VALIDATION_ERROR;
            } else {
                return ExitCode.SUCCESS;
            }
        } catch (LoadException e) {
            // Handle parse/load errors specifically
            out.error(ConsoleSymbols.error("PARSING FAILED"));
            System.err.println();
            System.err.println("Details:");
            System.err.println("  " + e.getMessage());
            return ExitCode.VALIDATION_ERROR;
            
        } catch (Exception e) {
            out.error("✗ VALIDATION FAILED");
            System.err.println();
            
            if (verbose) {
                out.error("[VERBOSE] Error details:");
                e.printStackTrace(System.err);
            }
            
            throw e;
        }
    }
    
    private void printTextOutput(ColorOutput out, boolean verbose, BackendConfig config, 
                                  int errorCount, int warningCount, int infoCount, 
                                  List<ValidationResult> validationResults) {
        if (verbose) {
            out.info("[VERBOSE] Running structural validation...");
        }
        
        out.section("VALIDATION RESULTS");
        
        if (errorCount == 0 && warningCount == 0) {
            out.success(ConsoleSymbols.success("VALIDATION PASSED"));
            System.out.println("  - Root element: BackendConfig " + ConsoleSymbols.SUCCESS);
            System.out.println("  - Project configuration: valid " + ConsoleSymbols.SUCCESS);
            System.out.println("  - Database configuration: valid " + ConsoleSymbols.SUCCESS);
            
            if (config != null && config.getDatabase() != null) {
                int tableCount = config.getDatabase().getTables().size();
                System.out.println("  - " + tableCount + " tables defined " + ConsoleSymbols.SUCCESS);
            }
        } else {
            
            if (errorCount > 0) {
                out.error(ConsoleSymbols.error("VALIDATION FAILED"));
                System.out.println();
                out.error("Errors:");
                for (ValidationResult result : validationResults) {
                    if (result.getSeverity() == ValidationResult.Severity.ERROR) {
                        String location = result.getLocation() != null ? result.getLocation() : "Unknown";
                        System.err.println("  [" + location + "] " + result.getMessage());
                    }
                }
            }            if (warningCount > 0) {
                System.out.println();
                out.warning("Warnings:");
                for (ValidationResult result : validationResults) {
                    if (result.getSeverity() == ValidationResult.Severity.WARNING) {
                        String location = result.getLocation() != null ? result.getLocation() : "Unknown";
                        System.out.println("  [" + location + "] " + result.getMessage());
                    }
                }
            }
            
            if (infoCount > 0 && verbose) {
                System.out.println();
                out.info("Info:");
                for (ValidationResult result : validationResults) {
                    if (result.getSeverity() == ValidationResult.Severity.INFO) {
                        String location = result.getLocation() != null ? result.getLocation() : "Unknown";
                        System.out.println("  [" + location + "] " + result.getMessage());
                    }
                }
            }
        }
        
        // Print summary
        System.out.println();
        if (errorCount == 0 && warningCount == 0) {
            out.banner(ConsoleSymbols.success("VALIDATION SUCCESSFUL"), true);
        } else {
            out.banner(ConsoleSymbols.error("VALIDATION FAILED"), false);
        }
        System.out.println();
        
        out.info("Summary:");
        System.out.println("  Errors:   " + errorCount);
        System.out.println("  Warnings: " + warningCount);
        System.out.println("  Info:     " + infoCount);
    }
    
    private void printJsonOutput(File file, int errorCount, int warningCount, 
                                  int infoCount, List<ValidationResult> validationResults) {
        System.out.println("{");
        System.out.println("  \"file\": \"" + file.getAbsolutePath().replace("\\", "\\\\") + "\",");
        System.out.println("  \"valid\": " + (errorCount == 0) + ",");
        System.out.println("  \"summary\": {");
        System.out.println("    \"errors\": " + errorCount + ",");
        System.out.println("    \"warnings\": " + warningCount + ",");
        System.out.println("    \"info\": " + infoCount);
        System.out.println("  },");
        System.out.println("  \"issues\": [");
        
        if (!validationResults.isEmpty()) {
            for (int i = 0; i < validationResults.size(); i++) {
                ValidationResult result = validationResults.get(i);
                String severity = result.getSeverity().toString();
                String message = result.getMessage().replace("\"", "\\\"");
                String location = result.getLocation() != null ? result.getLocation().replace("\"", "\\\"") : "Unknown";
                
                System.out.print("    {");
                System.out.print("\"severity\": \"" + severity + "\", ");
                System.out.print("\"location\": \"" + location + "\", ");
                System.out.print("\"message\": \"" + message + "\"");
                System.out.print("}");
                
                if (i < validationResults.size() - 1) {
                    System.out.println(",");
                } else {
                    System.out.println();
                }
            }
        }
        
        System.out.println("  ]");
        System.out.println("}");
    }
    
    private String formatFileSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
    }
}
