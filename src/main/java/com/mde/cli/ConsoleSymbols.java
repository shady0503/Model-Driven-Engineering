package com.mde.cli;

import java.nio.charset.Charset;

/**
 * Utility for console symbols that adapts to terminal capabilities.
 * Uses Unicode symbols when supported, falls back to ASCII when not.
 */
public class ConsoleSymbols {
    
    private static final boolean UNICODE_SUPPORTED = detectUnicodeSupport();
    
    // Success symbols
    public static final String CHECK = UNICODE_SUPPORTED ? "✓" : "[OK]";
    public static final String SUCCESS = UNICODE_SUPPORTED ? "✓" : "+";
    
    // Error symbols
    public static final String CROSS = UNICODE_SUPPORTED ? "✗" : "[X]";
    public static final String ERROR = UNICODE_SUPPORTED ? "✗" : "X";
    
    // Warning symbols
    public static final String WARNING = UNICODE_SUPPORTED ? "⚠" : "!";
    
    // Info symbols  
    public static final String INFO = UNICODE_SUPPORTED ? "ℹ" : "i";
    public static final String BULLET = UNICODE_SUPPORTED ? "•" : "-";
    public static final String ARROW = UNICODE_SUPPORTED ? "→" : "->";
    
    /**
     * Detect if the console supports Unicode characters.
     */
    private static boolean detectUnicodeSupport() {
        // Check system property set by --no-unicode flag
        String noUnicode = System.getProperty("mde.no-unicode");
        if ("true".equalsIgnoreCase(noUnicode)) {
            return false;
        }
        
        // Check console encoding
        try {
            Charset consoleCharset = Charset.defaultCharset();
            String charsetName = consoleCharset.name().toLowerCase();
            
            // UTF-8 and UTF-16 support Unicode
            if (charsetName.contains("utf")) {
                return true;
            }
            
            // Windows code pages that DON'T support Unicode checkmarks
            if (charsetName.contains("cp437") || 
                charsetName.contains("cp850") ||
                charsetName.contains("windows-1252")) {
                return false;
            }
            
            // Default to true for modern systems
            return true;
            
        } catch (Exception e) {
            // If we can't detect, assume no Unicode support (safe default)
            return false;
        }
    }
    
    /**
     * Check if Unicode is supported in the current console.
     */
    public static boolean isUnicodeSupported() {
        return UNICODE_SUPPORTED;
    }
    
    /**
     * Get a success message with the appropriate symbol.
     */
    public static String success(String message) {
        return CHECK + " " + message;
    }
    
    /**
     * Get an error message with the appropriate symbol.
     */
    public static String error(String message) {
        return CROSS + " " + message;
    }
    
    /**
     * Get a warning message with the appropriate symbol.
     */
    public static String warning(String message) {
        return WARNING + " " + message;
    }
    
    /**
     * Get an info message with the appropriate symbol.
     */
    public static String info(String message) {
        return INFO + " " + message;
    }
}
