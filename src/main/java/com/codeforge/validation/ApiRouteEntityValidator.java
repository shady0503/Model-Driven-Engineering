package com.codeforge.validation;

import Forge.Api;
import Forge.BackendConfig;
import Forge.Route;
import Forge.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Validates that API routes reference existing tables.
 * Every Route.entity must reference an existing Table.name.
 */
public class ApiRouteEntityValidator implements ModelValidator {
    
    private static final String NAME = "ApiRouteEntityValidator";
    private static final String DESCRIPTION = "Ensures API routes reference existing database tables";
    
    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();
        
        // Skip if no API configured
        Api api = config.getApi();
        if (api == null || api.getRoutes() == null) {
            return results;
        }
        
        // Build set of table names
        Set<String> tableNames = new HashSet<>();
        if (config.getDatabase() != null && config.getDatabase().getTables() != null) {
            for (Table table : config.getDatabase().getTables()) {
                if (table != null && table.getName() != null) {
                    tableNames.add(table.getName());
                }
            }
        }
        
        // Check each route
        for (Route route : api.getRoutes()) {
            if (route == null || route.getEntity() == null) {
                continue;
            }
            
            String entityName = route.getEntity();
            
            if (!tableNames.contains(entityName)) {
                String message = String.format(
                    "Route references non-existent entity '%s'. No table with this name exists.",
                    entityName
                );
                
                String location = "API Route for entity '" + entityName + "'";
                
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
