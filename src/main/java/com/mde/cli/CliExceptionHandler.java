package com.mde.cli;

import picocli.CommandLine;
import picocli.CommandLine.IExecutionExceptionHandler;
import picocli.CommandLine.ParseResult;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Custom exception handler for CLI to provide user-friendly error messages.
 */
public class CliExceptionHandler implements IExecutionExceptionHandler {
    
    @Override
    public int handleExecutionException(Exception ex, CommandLine cmd, ParseResult parseResult) {
        ColorOutput colorOutput = new ColorOutput(!cmd.getColorScheme().ansi().enabled());
        
        // Handle specific exception types with helpful messages
        if (ex instanceof FileNotFoundException || ex instanceof NoSuchFileException) {
            return handleFileNotFound(ex, colorOutput);
        } else if (ex instanceof IOException) {
            return handleIOException(ex, colorOutput);
        } else if (ex instanceof IllegalArgumentException) {
            return handleIllegalArgument(ex, colorOutput);
        } else {
            return handleGenericException(ex, colorOutput);
        }
    }
    
    private int handleFileNotFound(Exception ex, ColorOutput out) {
        out.error("[ERROR] File not found");
        System.err.println();
        System.err.println("Details:");
        System.err.println("  " + ex.getMessage());
        System.err.println();
        System.err.println("Suggestion:");
        System.err.println("  - Verify the file path is correct");
        System.err.println("  - Check file permissions");
        System.err.println("  - Use absolute path if relative path fails");
        System.err.println();
        System.err.println("Example:");
        System.err.println("  mde-gen generate examples/healthcare-system.yaml");
        return ExitCode.FILE_ERROR;
    }
    
    private int handleIOException(Exception ex, ColorOutput out) {
        out.error("[ERROR] I/O Error");
        System.err.println();
        System.err.println("Details:");
        System.err.println("  " + ex.getMessage());
        System.err.println();
        System.err.println("Suggestion:");
        System.err.println("  - Check file/directory permissions");
        System.err.println("  - Ensure sufficient disk space");
        System.err.println("  - Verify output directory is writable");
        return ExitCode.IO_ERROR;
    }
    
    private int handleIllegalArgument(Exception ex, ColorOutput out) {
        out.error("[ERROR] Invalid argument");
        System.err.println();
        System.err.println("Details:");
        System.err.println("  " + ex.getMessage());
        System.err.println();
        System.err.println("Suggestion:");
        System.err.println("  - Check command syntax with: mde-gen help");
        System.err.println("  - Verify input values are valid");
        return ExitCode.USAGE_ERROR;
    }
    
    private int handleGenericException(Exception ex, ColorOutput out) {
        out.error("[ERROR] Unexpected error occurred");
        System.err.println();
        System.err.println("Details:");
        System.err.println("  " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
        System.err.println();
        
        // Print stack trace in verbose mode (check system property set by verbose flag)
        if (Boolean.getBoolean("mde.verbose")) {
            System.err.println("Stack trace:");
            ex.printStackTrace(System.err);
            System.err.println();
        }
        
        System.err.println("Please report this issue at:");
        System.err.println("  https://github.com/shady0503/Model-Driven-Engineering/issues");
        return ExitCode.INTERNAL_ERROR;
    }
}
