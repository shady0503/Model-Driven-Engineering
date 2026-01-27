package com.codeforge.cli;

/**
 * Utility class for colored console output using ANSI escape codes.
 */
public class ColorOutput {
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";
    
    private final boolean noColor;
    
    public ColorOutput(boolean noColor) {
        this.noColor = noColor || System.getenv("NO_COLOR") != null;
    }
    
    /**
     * Print success message in green.
     */
    public void success(String message) {
        if (noColor) {
            System.out.println(message);
        } else {
            System.out.println(GREEN + message + RESET);
        }
    }
    
    /**
     * Print error message in red.
     */
    public void error(String message) {
        if (noColor) {
            System.err.println(message);
        } else {
            System.err.println(RED + BOLD + message + RESET);
        }
    }
    
    /**
     * Print warning message in yellow.
     */
    public void warning(String message) {
        if (noColor) {
            System.out.println(message);
        } else {
            System.out.println(YELLOW + message + RESET);
        }
    }
    
    /**
     * Print info message in cyan.
     */
    public void info(String message) {
        if (noColor) {
            System.out.println(message);
        } else {
            System.out.println(CYAN + message + RESET);
        }
    }
    
    /**
     * Print progress/phase message in blue.
     */
    public void progress(String message) {
        if (noColor) {
            System.out.println(message);
        } else {
            System.out.println(BLUE + message + RESET);
        }
    }
    
    /**
     * Print normal message without color.
     */
    public void print(String message) {
        System.out.println(message);
    }
    
    /**
     * Print banner with box drawing characters.
     */
    public void banner(String message, boolean isSuccess) {
        String color = noColor ? "" : (isSuccess ? GREEN : RED);
        String reset = noColor ? "" : RESET;
        
        System.out.println(color + "╔════════════════════════════════════════════════════════╗" + reset);
        System.out.println(color + "║ " + centerText(message, 54) + " ║" + reset);
        System.out.println(color + "╚════════════════════════════════════════════════════════╝" + reset);
    }
    
    /**
     * Print section header.
     */
    public void section(String title) {
        String color = noColor ? "" : BLUE;
        String reset = noColor ? "" : RESET;
        
        System.out.println();
        System.out.println(color + "┌─────────────────────────────────────────────────────┐" + reset);
        System.out.println(color + "│ " + title + " ".repeat(Math.max(0, 51 - title.length())) + "│" + reset);
        System.out.println(color + "└─────────────────────────────────────────────────────┘" + reset);
    }
    
    /**
     * Center text within a given width.
     */
    private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }
}
