package com.mde.cli;

/**
 * Standard exit codes for the CLI application.
 */
public class ExitCode {
    /** Success - command completed successfully */
    public static final int SUCCESS = 0;
    
    /** File error - input file not found or not readable */
    public static final int FILE_ERROR = 1;
    
    /** Input error - invalid input or auto-detection failed */
    public static final int INPUT_ERROR = 1;
    
    /** Validation error - model validation failed */
    public static final int VALIDATION_ERROR = 2;
    
    /** Generation error - code generation failed */
    public static final int GENERATION_ERROR = 3;
    
    /** I/O error - file system error (permissions, disk space) */
    public static final int IO_ERROR = 4;
    
    /** Configuration error - invalid configuration or options */
    public static final int CONFIG_ERROR = 5;
    
    /** Usage error - invalid command-line arguments */
    public static final int USAGE_ERROR = 64;
    
    /** Internal error - unexpected internal error */
    public static final int INTERNAL_ERROR = 70;
    
    private ExitCode() {
        // Utility class, prevent instantiation
    }
}
