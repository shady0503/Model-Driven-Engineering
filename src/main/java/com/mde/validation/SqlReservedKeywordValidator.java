package com.mde.validation;

import ModelDrivenEngineering.BackendConfig;
import ModelDrivenEngineering.Column;
import ModelDrivenEngineering.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Validates that table and column names don't use SQL reserved keywords.
 * Using SQL keywords can cause issues with database queries and require escaping.
 */
public class SqlReservedKeywordValidator implements ModelValidator {
    
    private static final String NAME = "SqlReservedKeywordValidator";
    private static final String DESCRIPTION = "Warns when table and column names use SQL reserved keywords";
    
    // SQL reserved keywords (common across PostgreSQL, MySQL, SQL Server, Oracle)
    private static final Set<String> SQL_KEYWORDS = new HashSet<>(Arrays.asList(
        // Common SQL reserved keywords
        "select", "insert", "update", "delete", "from", "where", "join", "inner",
        "outer", "left", "right", "on", "as", "order", "by", "group", "having",
        "union", "all", "distinct", "limit", "offset", "fetch", "top", "into",
        "values", "set", "create", "alter", "drop", "table", "index", "view",
        "database", "schema", "trigger", "procedure", "function", "constraint",
        "primary", "foreign", "key", "references", "unique", "check", "default",
        "not", "null", "and", "or", "in", "between", "like", "exists", "case",
        "when", "then", "else", "end", "is", "true", "false", "unknown",
        
        // PostgreSQL specific
        "serial", "bigserial", "smallserial", "uuid", "json", "jsonb", "array",
        "returning", "conflict", "exclude", "ilike", "similar", "any", "some",
        
        // Data types (common)
        "integer", "int", "bigint", "smallint", "decimal", "numeric", "real",
        "double", "float", "char", "varchar", "text", "boolean", "bool", "date",
        "time", "timestamp", "interval", "binary", "blob", "clob",
        
        // Other common keywords
        "grant", "revoke", "commit", "rollback", "begin", "transaction", "savepoint",
        "cascade", "restrict", "no", "action", "initially", "deferred", "immediate",
        "temporary", "temp", "global", "local", "temporary", "if", "for", "do",
        
        // Additional reserved words
        "user", "current", "session", "system", "admin", "usage", "execute",
        "with", "without", "recursive", "lateral", "cross", "natural", "using",
        "over", "partition", "window", "rows", "range", "preceding", "following",
        "unbounded", "current_row", "current_date", "current_time", "current_timestamp",
        
        // Common problematic names
        "user", "order", "group", "table", "column", "index", "database", "schema",
        "trigger", "view", "type", "role", "grant", "option", "cascade", "restrict"
    ));
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        if (config.getDatabase() == null || config.getDatabase().getTables() == null) {
            return results;
        }
        
        for (Table table : config.getDatabase().getTables()) {
            if (table == null) {
                continue;
            }
            
            // Check table name
            if (table.getName() != null && isSqlKeyword(table.getName())) {
                String message = String.format(
                    "'%s' is an SQL reserved keyword. Consider renaming or be prepared to escape it in queries.",
                    table.getName()
                );
                
                String location = "Table '" + table.getName() + "'";
                
                results.add(ValidationResult.warning(message, location, NAME));
            }
            
            // Check column names
            if (table.getColumns() != null) {
                for (Column column : table.getColumns()) {
                    if (column == null || column.getName() == null) {
                        continue;
                    }
                    
                    if (isSqlKeyword(column.getName())) {
                        String message = String.format(
                            "'%s' is an SQL reserved keyword. Consider renaming or be prepared to escape it in queries.",
                            column.getName()
                        );
                        
                        String location = String.format(
                            "Table '%s', Column '%s'",
                            table.getName() != null ? table.getName() : "unknown",
                            column.getName()
                        );
                        
                        results.add(ValidationResult.warning(message, location, NAME));
                    }
                }
            }
        }
        
        return results;
    }
    
    /**
     * Checks if the given name is an SQL keyword (case-insensitive)
     */
    private boolean isSqlKeyword(String name) {
        return name != null && SQL_KEYWORDS.contains(name.toLowerCase());
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
