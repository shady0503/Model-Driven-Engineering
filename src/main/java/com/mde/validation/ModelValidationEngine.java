package com.mde.validation;

import ModelDrivenEngineering.BackendConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Main validation engine that orchestrates all validators.
 * Validates a BackendConfig model using all registered validators.
 */
public class ModelValidationEngine {
    
    private final List<ModelValidator> validators;
    
    /**
     * Creates a new validation engine with no validators
     */
    public ModelValidationEngine() {
        this.validators = new ArrayList<>();
    }
    
    /**
     * Creates a new validation engine with the given validators
     * 
     * @param validators List of validators to use
     */
    public ModelValidationEngine(List<ModelValidator> validators) {
        this.validators = new ArrayList<>(Objects.requireNonNull(validators, "Validators cannot be null"));
    }
    
    /**
     * Adds a validator to this engine
     * 
     * @param validator The validator to add
     * @return This engine (for method chaining)
     */
    public ModelValidationEngine addValidator(ModelValidator validator) {
        this.validators.add(Objects.requireNonNull(validator, "Validator cannot be null"));
        return this;
    }
    
    /**
     * Validates the given BackendConfig model using all registered validators
     * 
     * @param config The BackendConfig to validate
     * @return List of all validation results from all validators
     */
    public List<ValidationResult> validate(BackendConfig config) {
        Objects.requireNonNull(config, "BackendConfig cannot be null");
        
        List<ValidationResult> allResults = new ArrayList<>();
        
        for (ModelValidator validator : validators) {
            try {
                List<ValidationResult> results = validator.validate(config);
                if (results != null) {
                    allResults.addAll(results);
                }
            } catch (Exception e) {
                // If a validator throws an exception, create an error result
                allResults.add(ValidationResult.error(
                    "Validator failed with exception: " + e.getMessage(),
                    "Validation Engine",
                    validator.getName()
                ));
            }
        }
        
        return allResults;
    }
    
    /**
     * Validates the model and returns only errors
     * 
     * @param config The BackendConfig to validate
     * @return List of error validation results
     */
    public List<ValidationResult> validateErrors(BackendConfig config) {
        return validate(config).stream()
            .filter(ValidationResult::isError)
            .collect(Collectors.toList());
    }
    
    /**
     * Validates the model and returns only warnings
     * 
     * @param config The BackendConfig to validate
     * @return List of warning validation results
     */
    public List<ValidationResult> validateWarnings(BackendConfig config) {
        return validate(config).stream()
            .filter(ValidationResult::isWarning)
            .collect(Collectors.toList());
    }
    
    /**
     * Checks if the model has any validation errors
     * 
     * @param config The BackendConfig to validate
     * @return true if there are any errors, false otherwise
     */
    public boolean hasErrors(BackendConfig config) {
        return validate(config).stream().anyMatch(ValidationResult::isError);
    }
    
    /**
     * Checks if the model is valid (no errors)
     * 
     * @param config The BackendConfig to validate
     * @return true if valid (no errors), false otherwise
     */
    public boolean isValid(BackendConfig config) {
        return !hasErrors(config);
    }
    
    /**
     * Gets the number of registered validators
     * 
     * @return The validator count
     */
    public int getValidatorCount() {
        return validators.size();
    }
    
    /**
     * Gets all registered validators
     * 
     * @return Unmodifiable list of validators
     */
    public List<ModelValidator> getValidators() {
        return new ArrayList<>(validators);
    }
    
    /**
     * Creates a validation engine with all default validators
     * 
     * @return A fully configured validation engine
     */
    public static ModelValidationEngine createDefault() {
        ModelValidationEngine engine = new ModelValidationEngine();
        
        // Add critical validators
        engine.addValidator(new PrimaryKeyValidator());
        engine.addValidator(new UniqueTableNamesValidator());
        engine.addValidator(new ForeignKeyTargetTableValidator());
        engine.addValidator(new ForeignKeyTargetColumnValidator());
        
        // Add high priority validators
        engine.addValidator(new ForeignKeyTypeCompatibilityValidator());
        engine.addValidator(new UniqueColumnNamesValidator());
        engine.addValidator(new ApiRouteEntityValidator());
        engine.addValidator(new JavaReservedKeywordValidator());
        engine.addValidator(new SqlReservedKeywordValidator());
        
        return engine;
    }
    
    /**
     * Formats validation results as a human-readable string
     * 
     * @param results The validation results to format
     * @return Formatted string
     */
    public static String formatResults(List<ValidationResult> results) {
        if (results.isEmpty()) {
            return "✓ Validation passed - no issues found";
        }
        
        StringBuilder sb = new StringBuilder();
        
        long errorCount = results.stream().filter(ValidationResult::isError).count();
        long warningCount = results.stream().filter(ValidationResult::isWarning).count();
        long infoCount = results.stream().filter(ValidationResult::isInfo).count();
        
        sb.append("Validation completed with ");
        sb.append(errorCount).append(" error(s), ");
        sb.append(warningCount).append(" warning(s), ");
        sb.append(infoCount).append(" info message(s)\n");
        sb.append("\n");
        
        for (ValidationResult result : results) {
            sb.append(result.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
