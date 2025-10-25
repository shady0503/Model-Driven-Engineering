package com.mde.validation;

import com.mde.ModelDrivenEngineering.BackendConfig;
import com.mde.ModelDrivenEngineering.Column;
import com.mde.ModelDrivenEngineering.Relation;
import com.mde.ModelDrivenEngineering.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Validates that foreign key relations reference existing columns in target tables.
 * Every Relation.targetColumn must exist in the target Table.
 */
public class ForeignKeyTargetColumnValidator implements ModelValidator {
    
    private static final String NAME = "ForeignKeyTargetColumnValidator";
    private static final String DESCRIPTION = "Ensures foreign key relations reference existing columns in target tables";
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        if (config.getDatabase() == null || config.getDatabase().getTables() == null) {
            return results;
        }
        
        // Build a map of tables with their columns
        Map<String, Table> tableMap = new HashMap<>();
        Map<String, List<String>> tableColumnsMap = new HashMap<>();
        
        for (Table table : config.getDatabase().getTables()) {
            if (table == null || table.getName() == null) {
                continue;
            }
            
            tableMap.put(table.getName(), table);
            
            List<String> columnNames = new ArrayList<>();
            if (table.getColumns() != null) {
                for (Column col : table.getColumns()) {
                    if (col != null && col.getName() != null) {
                        columnNames.add(col.getName());
                    }
                }
            }
            tableColumnsMap.put(table.getName(), columnNames);
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
                String targetColumnName = relation.getTargetColumn();
                
                if (targetTableName == null || targetColumnName == null) {
                    continue;
                }
                
                // Skip if target table doesn't exist (another validator handles this)
                if (!tableMap.containsKey(targetTableName)) {
                    continue;
                }
                
                // Check if target column exists in target table
                List<String> targetColumns = tableColumnsMap.get(targetTableName);
                if (targetColumns == null || !targetColumns.contains(targetColumnName)) {
                    String message = String.format(
                        "Relation references non-existent column '%s' in table '%s'",
                        targetColumnName,
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
