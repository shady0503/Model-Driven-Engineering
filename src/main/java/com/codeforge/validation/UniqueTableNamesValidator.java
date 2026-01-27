package com.codeforge.validation;

import Forge.BackendConfig;
import Forge.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Validates that all table names within a database are unique.
 * Duplicate table names would cause conflicts in code generation.
 */
public class UniqueTableNamesValidator implements ModelValidator {
    
    private static final String NAME = "UniqueTableNamesValidator";
    private static final String DESCRIPTION = "Ensures all table names are unique within the database";
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        if (config.getDatabase() == null || config.getDatabase().getTables() == null) {
            return results;
        }
        
        Set<String> seenNames = new HashSet<>();
        Set<String> duplicateNames = new HashSet<>();
        
        // First pass: identify duplicates
        for (Table table : config.getDatabase().getTables()) {
            if (table == null || table.getName() == null) {
                continue;
            }
            
            String tableName = table.getName();
            
            if (seenNames.contains(tableName)) {
                duplicateNames.add(tableName);
            } else {
                seenNames.add(tableName);
            }
        }
        
        // Second pass: create error for each duplicate
        for (String duplicateName : duplicateNames) {
            String message = String.format(
                "Duplicate table name '%s'. Each table must have a unique name.",
                duplicateName
            );
            
            results.add(ValidationResult.error(
                message,
                "Database",
                NAME
            ));
        }
        
        return results;
    }
    
    @Override
    public String getName() {
        return NAME;
    }
    
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
