package com.mde.validation;

import com.mde.ModelDrivenEngineering.BackendConfig;
import com.mde.ModelDrivenEngineering.Column;
import com.mde.ModelDrivenEngineering.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Validates that each table has at least one primary key column.
 * This is a critical requirement for database tables.
 */
public class PrimaryKeyValidator implements ModelValidator {
    
    private static final String NAME = "PrimaryKeyValidator";
    private static final String DESCRIPTION = "Ensures each table has at least one primary key column";
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        if (config.getDatabase() == null || config.getDatabase().getTables() == null) {
            return results;
        }
        
        for (Table table : config.getDatabase().getTables()) {
            if (table == null || table.getName() == null) {
                continue;
            }
            
            boolean hasPrimaryKey = false;
            
            if (table.getColumns() != null) {
                for (Column column : table.getColumns()) {
                    if (column != null && column.isPrimary()) {
                        hasPrimaryKey = true;
                        break;
                    }
                }
            }
            
            if (!hasPrimaryKey) {
                String message = String.format(
                    "Table '%s' has no primary key. Add 'primary: true' to at least one column.",
                    table.getName()
                );
                
                results.add(ValidationResult.error(
                    message,
                    "Table '" + table.getName() + "'",
                    NAME
                ));
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
