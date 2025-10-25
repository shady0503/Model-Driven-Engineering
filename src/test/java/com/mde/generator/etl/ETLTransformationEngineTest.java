package com.mde.generator.etl;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.mde.loader.FlexmiModelLoader;
import com.mde.ModelDrivenEngineering.BackendConfig;

/**
 * Unit tests for ETLTransformationEngine
 */
class ETLTransformationEngineTest {

    private ETLTransformationEngine engine;
    private FlexmiModelLoader loader;
    
    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        engine = new ETLTransformationEngine();
        loader = new FlexmiModelLoader();
    }

    @Test
    void testEngineInitialization() {
        // Given/When: Engine is created
        ETLTransformationEngine testEngine = new ETLTransformationEngine();
        
        // Then: Engine should not be null
        assertNotNull(testEngine);
    }

    @Test
    void testETLScriptExists() {
        // Given: ETL script path
        String scriptPath = "src/main/resources/etl/BackendConfigToContext.etl";
        
        // When: Check if file exists
        Path etlFile = Paths.get(scriptPath);
        
        // Then: File should exist
        assertTrue(Files.exists(etlFile), "ETL script should exist at: " + scriptPath);
    }

    @Test
    void testETLScriptNotEmpty() throws Exception {
        // Given: ETL script path
        Path etlFile = Paths.get("src/main/resources/etl/BackendConfigToContext.etl");
        
        // When: Read file size
        long fileSize = Files.size(etlFile);
        
        // Then: File should not be empty
        assertTrue(fileSize > 0, "ETL script should not be empty");
        assertTrue(fileSize > 1000, "ETL script should have substantial content");
    }

    @Test
    void testETLScriptHasRequiredRules() throws Exception {
        // Given: ETL script
        Path etlFile = Paths.get("src/main/resources/etl/BackendConfigToContext.etl");
        
        // When: Read script content
        String content = Files.readString(etlFile);
        
        // Then: Should contain all required rules
        assertTrue(content.contains("BackendConfigToProjectContext"), 
            "ETL should have BackendConfigToProjectContext rule");
        assertTrue(content.contains("TableToEntityContext"), 
            "ETL should have TableToEntityContext rule");
        assertTrue(content.contains("ColumnToFieldContext"), 
            "ETL should have ColumnToFieldContext rule");
        assertTrue(content.contains("RelationToRelationContext"), 
            "ETL should have RelationToRelationContext rule");
    }

    @Test
    void testETLScriptHasHelperOperations() throws Exception {
        // Given: ETL script
        Path etlFile = Paths.get("src/main/resources/etl/BackendConfigToContext.etl");
        
        // When: Read script content
        String content = Files.readString(etlFile);
        
        // Then: Should contain helper operations
        assertTrue(content.contains("toEntityName"), 
            "ETL should have toEntityName operation");
        assertTrue(content.contains("toCamelCase"), 
            "ETL should have toCamelCase operation");
        assertTrue(content.contains("mapToJavaType"), 
            "ETL should have mapToJavaType operation");
        assertTrue(content.contains("generateDependencies"), 
            "ETL should have generateDependencies operation");
    }

    @Test
    void testExecuteTransformationWithInvalidInput() {
        // Given: Non-existent input file
        Path inputModel = tempDir.resolve("non-existent.xmi");
        Path outputModel = tempDir.resolve("output.xmi");
        
        // When/Then: Should throw exception
        assertThrows(Exception.class, () -> {
            engine.executeTransformation(inputModel, outputModel);
        });
    }

    @Test
    void testETLScriptHasNoInvalidTernaryOperators() throws Exception {
        // Given: ETL script
        Path etlFile = Paths.get("src/main/resources/etl/BackendConfigToContext.etl");
        String content = Files.readString(etlFile);
        
        // When: Check for invalid ternary syntax
        boolean hasInvalidTernary = content.contains(" ? ") && content.contains(" : ");
        
        // Then: Should not have ternary operators (ETL doesn't support them)
        assertFalse(hasInvalidTernary, 
            "ETL script should not use ternary operators (? :) - use if-else blocks instead");
    }

    @Test
    void testETLScriptHasProperGuards() throws Exception {
        // Given: ETL script
        Path etlFile = Paths.get("src/main/resources/etl/BackendConfigToContext.etl");
        String content = Files.readString(etlFile);
        
        // When: Check for guard clauses
        int guardCount = content.split("guard :").length - 1;
        
        // Then: Should have guards for all transformation rules
        assertTrue(guardCount >= 4, 
            "ETL script should have guard clauses for all rules");
    }

    @Test
    void testETLScriptHasPreAndPostBlocks() throws Exception {
        // Given: ETL script
        Path etlFile = Paths.get("src/main/resources/etl/BackendConfigToContext.etl");
        String content = Files.readString(etlFile);
        
        // When: Check for pre and post blocks
        boolean hasPre = content.contains("pre {");
        boolean hasPost = content.contains("post {");
        
        // Then: Should have both pre and post blocks
        assertTrue(hasPre, "ETL script should have pre block");
        assertTrue(hasPost, "ETL script should have post block");
    }

    @Test
    void testETLScriptHasLazyAnnotations() throws Exception {
        // Given: ETL script
        Path etlFile = Paths.get("src/main/resources/etl/BackendConfigToContext.etl");
        String content = Files.readString(etlFile);
        
        // When: Check for @lazy annotations
        int lazyCount = content.split("@lazy").length - 1;
        
        // Then: Should have lazy rules for dependent transformations
        assertTrue(lazyCount >= 3, 
            "ETL script should have @lazy annotations for dependent rules");
    }
}
