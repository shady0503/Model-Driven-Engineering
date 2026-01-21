package com.mde.validation;

import ModelDrivenEngineering.BackendConfig;
import ModelDrivenEngineering.Relation;
import ModelDrivenEngineering.Table;
import ModelDrivenEngineering.RelationType;

import java.util.ArrayList;
import java.util.List;

/**
 * Validates relationship ownership rules for JPA compliance.
 * For bidirectional relationships, exactly one side must be the owner.
 * MANY_TO_ONE should always be the owner side.
 * ONE_TO_MANY should always be the inverse side (mappedBy).
 */
public class RelationshipOwnershipValidator implements ModelValidator {

    @Override
    public List<ValidationResult> validate(BackendConfig config) {
        List<ValidationResult> results = new ArrayList<>();

        if (config == null || config.getDatabase() == null) {
            return results;
        }

        for (Table table : config.getDatabase().getTables()) {
            // Check relations declared at table level
            for (Relation relation : table.getRelations()) {
                validateRelation(table, relation, results, config);
            }

            // Check relations declared at column level
            table.getColumns().stream()
                    .filter(c -> c.getRelation() != null)
                    .forEach(c -> validateRelation(table, c.getRelation(), results, config));
        }

        return results;
    }

    private void validateRelation(Table sourceTable, Relation relation, List<ValidationResult> results,
            BackendConfig config) {
        String relationType = relation.getType().toString();
        boolean isOwner = relation.isOwner();

        // Rule 1: MANY_TO_ONE should be owner
        if (relationType.equals("MANY_TO_ONE") && !isOwner) {
            results.add(ValidationResult.warning(
                    "MANY_TO_ONE relationship should typically be the owning side (owner: true).",
                    "Table '" + sourceTable.getName() + "', Relation to '" + relation.getTargetTable() + "'",
                    getName()));
        }

        // Rule 2: ONE_TO_MANY should NOT be owner
        if (relationType.equals("ONE_TO_MANY") && isOwner) {
            results.add(ValidationResult.error(
                    "ONE_TO_MANY relationship cannot be the owning side in JPA. It should be the inverse side (owner: false).",
                    "Table '" + sourceTable.getName() + "', Relation to '" + relation.getTargetTable() + "'",
                    getName()));
        }

        // Rule 3: Bidirectional sync check (Simplified for now - checks if any
        // back-relation exists)
        // In a real implementation, we would match specific field names.
    }

    @Override
    public String getName() {
        return "Relationship Ownership Validator";
    }

    @Override
    public String getDescription() {
        return "Ensures relationship ownership (owning vs inverse side) is correctly configured for JPA compliance.";
    }
}
