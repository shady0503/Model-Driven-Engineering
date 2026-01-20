package com.mde.validation;

import ModelDrivenEngineering.BackendConfig;

import java.util.List;

/**
 * Base interface for all model validators.
 * Each validator checks specific business rules on the BackendConfig model.
 */
public interface ModelValidator {
    
    /**
     * Validates the given BackendConfig model
     * 
     * @param config The BackendConfig to validate
     * @return List of validation results (empty if no issues found)
     */
    List<ValidationResult> validate(BackendConfig config);
    
    /**
     * Returns the name of this validator
     * 
     * @return The validator name
     */
    String getName();
    
    /**
     * Returns a description of what this validator checks
     * 
     * @return The validator description
     */
    String getDescription();
}
