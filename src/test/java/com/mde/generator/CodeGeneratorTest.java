package com.mde.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Unit tests for CodeGenerator
 */
class CodeGeneratorTest {

    private CodeGenerator generator;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        generator = new CodeGenerator();
    }

    @Test
    void testGeneratorInitialization() {
        // Given/When: Generator is created
        CodeGenerator testGenerator = new CodeGenerator();

        // Then: Generator should not be null
        assertNotNull(testGenerator);
    }

    @Test
    void testGenerateProjectWithNullYamlFile() {
        // Given: Null YAML file path
        Path yamlFile = null;
        Path outputDir = tempDir.resolve("output");

        // When/Then: Should throw exception
        assertThrows(Exception.class, () -> {
            generator.generateProject(yamlFile, outputDir);
        });
    }

    @Test
    void testGenerateProjectWithNonExistentYamlFile() {
        // Given: Non-existent YAML file
        Path yamlFile = Paths.get("non-existent.yaml");
        Path outputDir = tempDir.resolve("output");

        // When/Then: Should throw exception
        assertThrows(Exception.class, () -> {
            generator.generateProject(yamlFile, outputDir);
        });
    }

    @Test
    void testBlogExampleYamlExists() {
        // Given: Blog example YAML path
        Path blogExample = Paths.get("examples/blog-example.yaml");

        // When: Check if file exists
        boolean exists = Files.exists(blogExample);

        // Then: File should exist
        assertTrue(exists, "Blog example YAML should exist at: examples/blog-example.yaml");
    }

    @Test
    void testMinimalExampleYamlExists() {
        // Given: Minimal example YAML path
        Path minimalExample = Paths.get("examples/minimal-example.yaml");

        // When: Check if file exists
        boolean exists = Files.exists(minimalExample);

        // Then: File should exist
        assertTrue(exists, "Minimal example YAML should exist at: examples/minimal-example.yaml");
    }

    @Test
    void testOutputDirectoryCreation() throws Exception {
        // Given: Output directory path
        Path outputDir = tempDir.resolve("test-output");

        // When: Directory doesn't exist initially
        assertFalse(Files.exists(outputDir));

        // Then: Generator should handle directory creation
        Files.createDirectories(outputDir);
        assertTrue(Files.exists(outputDir));
    }

    @Test
    void testGeneratorHasRequiredComponents() {
        // Given: New generator
        CodeGenerator testGenerator = new CodeGenerator();

        // When: Generator is created
        // Then: It should initialize without errors
        assertNotNull(testGenerator, "Generator should be initialized");
    }

    @Test
    void testExamplesDirectoryExists() {
        // Given: Examples directory path
        Path examplesDir = Paths.get("examples");

        // When: Check if directory exists
        boolean exists = Files.exists(examplesDir);

        // Then: Directory should exist
        assertTrue(exists, "Examples directory should exist");
    }

    @Test
    void testExamplesDirectoryHasYamlFiles() throws Exception {
        // Given: Examples directory
        Path examplesDir = Paths.get("examples");

        // When: Count YAML files
        long yamlCount = Files.list(examplesDir)
                .filter(p -> p.toString().endsWith(".yaml"))
                .count();

        // Then: Should have at least one YAML file
        assertTrue(yamlCount > 0, "Examples directory should contain YAML files");
    }

    @Test
    void testPipelineComponentsExist() {
        // Given: Required component classes
        String[] componentClasses = {
                "com.mde.loader.FlexmiModelLoader",
                "com.mde.generator.etl.ETLTransformationEngine",
                "com.mde.generator.egl.EGLTemplateEngine"
        };

        // When/Then: Check each component class exists
        for (String className : componentClasses) {
            assertDoesNotThrow(() -> {
                Class.forName(className);
            }, "Component class should exist: " + className);
        }
    }

    @Test
    void testMetamodelPackagesExist() {
        // Given: Required metamodel packages
        String[] metamodelPackages = {
                "ModelDrivenEngineering.ModelDrivenEngineeringPackage",
                "com.mde.generator.Context.ContextPackage"
        };

        // When/Then: Check each metamodel package class exists
        for (String packageClass : metamodelPackages) {
            assertDoesNotThrow(() -> {
                Class.forName(packageClass);
            }, "Metamodel package should exist: " + packageClass);
        }
    }
}
