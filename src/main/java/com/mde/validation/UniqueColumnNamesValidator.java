package com.mde.validation;

import ModelDrivenEngineering.BackendConfig;
import ModelDrivenEngineering.Column;
import ModelDrivenEngineering.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Validates that all column names within a table are unique.
 * Duplicate column names would cause conflicts in code generation and database schema.
 */
public class UniqueColumnNamesValidator implements ModelValidator {
    
    private static final String NAME = "UniqueColumnNamesValidator";
    private static final String DESCRIPTION = "Ensures all column names are unique within each table";
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        if (config.getDatabase() == null || config.getDatabase().getTables() == null) {
            return results;
        }
        
        for (Table table : config.getDatabase().getTables()) {
            if (table == null || table.getName() == null || table.getColumns() == null) {
                continue;
            }
            
            Set<String> seenColumnNames = new HashSet<>();
            Set<String> duplicateColumnNames = new HashSet<>();
            
            // Identify duplicate column names
            for (Column column : table.getColumns()) {
                if (column == null || column.getName() == null) {
                    continue;
                }
                
                String columnName = column.getName();
                
                if (seenColumnNames.contains(columnName)) {
                    duplicateColumnNames.add(columnName);
                } else {
                    seenColumnNames.add(columnName);
                }
            }
            
            // Create error for each duplicate
            for (String duplicateColumnName : duplicateColumnNames) {
                String message = String.format(
                    "Duplicate column name '%s' in table '%s'",
                    duplicateColumnName,
                    table.getName()
                );
                
                String location = "Table '" + table.getName() + "'";
                
                results.add(ValidationResult.error(message, location, NAME));
            }
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
