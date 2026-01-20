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
 * Validates that table and column names don't use Java reserved keywords.
 * Using reserved keywords would cause compilation errors in generated code.
 */
public class JavaReservedKeywordValidator implements ModelValidator {
    
    private static final String NAME = "JavaReservedKeywordValidator";
    private static final String DESCRIPTION = "Ensures table and column names don't use Java reserved keywords";
    
    // Java reserved keywords (source: Java Language Specification)
    private static final Set<String> JAVA_KEYWORDS = new HashSet<>(Arrays.asList(
        // Reserved keywords
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
        "class", "const", "continue", "default", "do", "double", "else", "enum",
        "extends", "final", "finally", "float", "for", "goto", "if", "implements",
        "import", "instanceof", "int", "interface", "long", "native", "new", "package",
        "private", "protected", "public", "return", "short", "static", "strictfp",
        "super", "switch", "synchronized", "this", "throw", "throws", "transient",
        "try", "void", "volatile", "while",
        
        // Literal keywords
        "true", "false", "null",
        
        // Module keywords (Java 9+)
        "module", "requires", "exports", "opens", "to", "uses", "provides", "with",
        
        // Special identifiers
        "var", "record", "sealed", "permits", "yield"
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
            if (table.getName() != null && isJavaKeyword(table.getName())) {
                String message = String.format(
                    "'%s' is a Java reserved keyword and cannot be used as a table name",
                    table.getName()
                );
                
                String location = "Table '" + table.getName() + "'";
                
                results.add(ValidationResult.error(message, location, NAME));
            }
            
            // Check column names
            if (table.getColumns() != null) {
                for (Column column : table.getColumns()) {
                    if (column == null || column.getName() == null) {
                        continue;
                    }
                    
                    if (isJavaKeyword(column.getName())) {
                        String message = String.format(
                            "'%s' is a Java reserved keyword and cannot be used as a column name",
                            column.getName()
                        );
                        
                        String location = String.format(
                            "Table '%s', Column '%s'",
                            table.getName() != null ? table.getName() : "unknown",
                            column.getName()
                        );
                        
                        results.add(ValidationResult.error(message, location, NAME));
                    }
                }
            }
        }
        
        return results;
    }
    
    /**
     * Checks if the given name is a Java keyword (case-insensitive)
     */
    private boolean isJavaKeyword(String name) {
        return name != null && JAVA_KEYWORDS.contains(name.toLowerCase());
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
