package com.mde.validation;

import ModelDrivenEngineering.BackendConfig;
import ModelDrivenEngineering.Column;
import ModelDrivenEngineering.Relation;
import ModelDrivenEngineering.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Validates that foreign key relations reference existing tables.
 * Every Relation.targetTable must reference an existing Table.name.
 */
public class ForeignKeyTargetTableValidator implements ModelValidator {
    
    private static final String NAME = "ForeignKeyTargetTableValidator";
    private static final String DESCRIPTION = "Ensures foreign key relations reference existing tables";
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        if (config.getDatabase() == null || config.getDatabase().getTables() == null) {
            return results;
        }
        
        // Build a map of table names for quick lookup
        Map<String, Table> tableMap = new HashMap<>();
        for (Table table : config.getDatabase().getTables()) {
            if (table != null && table.getName() != null) {
                tableMap.put(table.getName(), table);
            }
        }
        
        // Check each relation
        for (Table table : config.getDatabase().getTables()) {
            if (table == null || table.getName() == null || table.getColumns() == null) {
                continue;
            }
            
            for (Column column : table.getColumns()) {
                if (column == null || column.getRelation() == null) {
                    continue;
                }
                
                Relation relation = column.getRelation();
                String targetTableName = relation.getTargetTable();
                
                if (targetTableName == null || targetTableName.trim().isEmpty()) {
                    continue;
                }
                
                // Check if target table exists
                if (!tableMap.containsKey(targetTableName)) {
                    String message = String.format(
                        "Relation in '%s.%s' references non-existent table '%s'",
                        table.getName(),
                        column.getName() != null ? column.getName() : "unknown",
                        targetTableName
                    );
                    
                    String location = String.format(
                        "Table '%s', Column '%s'",
                        table.getName(),
                        column.getName() != null ? column.getName() : "unknown"
                    );
                    
                    results.add(ValidationResult.error(message, location, NAME));
                }
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
