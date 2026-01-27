package com.codeforge.validation;

import Forge.BackendConfig;
import Forge.Column;
import Forge.DataType;
import Forge.Relation;
import Forge.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Validates that foreign key source and target columns have compatible data types.
 * Type mismatches can cause database constraint errors.
 */
public class ForeignKeyTypeCompatibilityValidator implements ModelValidator {
    
    private static final String NAME = "ForeignKeyTypeCompatibilityValidator";
    private static final String DESCRIPTION = "Ensures foreign key source and target columns have matching data types";
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        if (config.getDatabase() == null || config.getDatabase().getTables() == null) {
            return results;
        }
        
        // Build a map of tables and their columns with types
        Map<String, Map<String, DataType>> tableColumnsTypeMap = new HashMap<>();
        
        for (Table table : config.getDatabase().getTables()) {
            if (table == null || table.getName() == null || table.getColumns() == null) {
                continue;
            }
            
            Map<String, DataType> columnTypes = new HashMap<>();
            for (Column col : table.getColumns()) {
                if (col != null && col.getName() != null && col.getType() != null) {
                    columnTypes.put(col.getName(), col.getType());
                }
            }
            tableColumnsTypeMap.put(table.getName(), columnTypes);
        }
        
        // Check each relation for type compatibility
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
                String targetColumnName = relation.getTargetColumn();
                
                if (targetTableName == null || targetColumnName == null) {
                    continue;
                }
                
                // Skip if target table doesn't exist (another validator handles this)
                if (!tableColumnsTypeMap.containsKey(targetTableName)) {
                    continue;
                }
                
                Map<String, DataType> targetColumns = tableColumnsTypeMap.get(targetTableName);
                
                // Skip if target column doesn't exist (another validator handles this)
                if (!targetColumns.containsKey(targetColumnName)) {
                    continue;
                }
                
                // Get types
                DataType sourceType = column.getType();
                DataType targetType = targetColumns.get(targetColumnName);
                
                // Check if types match
                if (sourceType != null && targetType != null && sourceType != targetType) {
                    String message = String.format(
                        "Type mismatch in foreign key: %s.%s (%s) → %s.%s (%s)",
                        table.getName(),
                        column.getName() != null ? column.getName() : "unknown",
                        sourceType.getLiteral(),
                        targetTableName,
                        targetColumnName,
                        targetType.getLiteral()
                    );
                    
                    String location = String.format(
                        "Table '%s', Column '%s'",
                        table.getName(),
                        column.getName() != null ? column.getName() : "unknown"
                    );
                    
                    results.add(ValidationResult.warning(message, location, NAME));
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
