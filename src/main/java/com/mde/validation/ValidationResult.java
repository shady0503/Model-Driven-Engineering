package com.mde.validation;

import java.util.Objects;

/**
 * Represents the result of a validation check.
 * Contains information about validation errors and warnings.
 */
public class ValidationResult {
    
    /**
     * Severity levels for validation results
     */
    public enum Severity {
        ERROR,   // Critical issues that prevent code generation
        WARNING, // Non-critical issues that should be reviewed
        INFO     // Informational messages
    }
    
    private final Severity severity;
    private final String message;
    private final String location;  // e.g., "Table 'users'", "Column 'users.id'"
    private final String validatorName;
    
    /**
     * Creates a new validation result
     * 
     * @param severity The severity level
     * @param message The validation message
     * @param location The location in the model where the issue occurred
     * @param validatorName The name of the validator that produced this result
     */
    public ValidationResult(Severity severity, String message, String location, String validatorName) {
        this.severity = Objects.requireNonNull(severity, "Severity cannot be null");
        this.message = Objects.requireNonNull(message, "Message cannot be null");
        this.location = location;
        this.validatorName = Objects.requireNonNull(validatorName, "Validator name cannot be null");
    }
    
    /**
     * Creates an ERROR result
     */
    public static ValidationResult error(String message, String location, String validatorName) {
        return new ValidationResult(Severity.ERROR, message, location, validatorName);
    }
    
    /**
     * Creates a WARNING result
     */
    public static ValidationResult warning(String message, String location, String validatorName) {
        return new ValidationResult(Severity.WARNING, message, location, validatorName);
    }
    
    /**
     * Creates an INFO result
     */
    public static ValidationResult info(String message, String location, String validatorName) {
        return new ValidationResult(Severity.INFO, message, location, validatorName);
    }
    
    public Severity getSeverity() {
        return severity;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getValidatorName() {
        return validatorName;
    }
    
    public boolean isError() {
        return severity == Severity.ERROR;
    }
    
    public boolean isWarning() {
        return severity == Severity.WARNING;
    }
    
    public boolean isInfo() {
        return severity == Severity.INFO;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(severity).append("]");
        if (location != null && !location.isEmpty()) {
            sb.append(" ").append(location);
        }
        sb.append(": ").append(message);
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationResult that = (ValidationResult) o;
        return severity == that.severity &&
               Objects.equals(message, that.message) &&
               Objects.equals(location, that.location) &&
               Objects.equals(validatorName, that.validatorName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(severity, message, location, validatorName);
    }
}
