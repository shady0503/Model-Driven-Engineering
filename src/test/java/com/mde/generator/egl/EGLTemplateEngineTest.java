package com.mde.generator.egl;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.mde.generator.Context.ContextFactory;
import com.mde.generator.Context.ProjectContext;
import com.mde.generator.Context.EntityContext;
import com.mde.generator.Context.FieldContext;

/**
 * Unit tests for EGLTemplateEngine
 */
class EGLTemplateEngineTest {

    @TempDir
    Path tempDir;

    private EGLTemplateEngine engine;

    @BeforeEach
    void setUp() {
        engine = new EGLTemplateEngine(tempDir);
    }

    @Test
    void testEngineInitialization() {
        // Given/When: Engine is created
        EGLTemplateEngine testEngine = new EGLTemplateEngine(tempDir);
        
        // Then: Engine should not be null
        assertNotNull(testEngine);
    }

    @Test
    void testTemplateDirectoryExists() {
        // Given: Template directory path
        String templatesPath = "templates";
        
        // When: Check if directory exists
        Path templatesDir = Paths.get(templatesPath);
        
        // Then: Directory should exist
        assertTrue(Files.exists(templatesDir), 
            "Templates directory should exist at: " + templatesPath);
    }

    @Test
    void testRequiredTemplatesExist() {
        // Given: Required template paths
        String[] requiredTemplates = {
            "templates/project/pom.egl",
            "templates/project/application.egl",
            "templates/project/Application.egl",
            "templates/entity/Entity.egl",
            "templates/repository/Repository.egl",
            "templates/service/Service.egl",
            "templates/controller/Controller.egl",
            "templates/docker/docker-compose.egl",
            "templates/README.egl"
        };
        
        // When/Then: Check each template exists
        for (String templatePath : requiredTemplates) {
            Path template = Paths.get(templatePath);
            assertTrue(Files.exists(template), 
                "Required template should exist: " + templatePath);
        }
    }

    @Test
    void testTemplatesNotEmpty() throws Exception {
        // Given: Template files
        String[] templates = {
            "templates/project/pom.egl",
            "templates/entity/Entity.egl"
        };
        
        // When/Then: Each template should have content
        for (String templatePath : templates) {
            Path template = Paths.get(templatePath);
            long size = Files.size(template);
            assertTrue(size > 0, 
                "Template should not be empty: " + templatePath);
        }
    }

    @Test
    void testTemplatesHaveEGLSyntax() throws Exception {
        // Given: Entity template
        Path entityTemplate = Paths.get("templates/entity/Entity.egl");
        
        // When: Read template content
        String content = Files.readString(entityTemplate);
        
        // Then: Should contain EGL syntax markers
        assertTrue(content.contains("[%") || content.contains("[*"), 
            "Template should contain EGL syntax markers [% or [*");
    }

    @Test
    void testOutputDirectoryCreation() throws Exception {
        // Given: Output directory
        Path outputDir = tempDir.resolve("test-output");
        
        // When: Create engine with output directory
        EGLTemplateEngine testEngine = new EGLTemplateEngine(outputDir);
        
        // Then: Engine should be created successfully
        assertNotNull(testEngine);
    }

    @Test
    void testGenerateProjectWithNonExistentModel() {
        // Given: Non-existent context model
        Path nonExistentModel = tempDir.resolve("non-existent.xmi");
        
        // When/Then: Should throw exception
        assertThrows(Exception.class, () -> {
            engine.generateProject(nonExistentModel);
        });
    }

    @Test
    void testCreateDirectoryStructure() throws Exception {
        // Given: Output directory
        Path outputDir = tempDir.resolve("project-structure-test");
        Files.createDirectories(outputDir);
        
        // When: Test directory structure would be created
        // Note: We can't fully test without a valid Context model,
        // but we can verify the engine handles the output directory
        EGLTemplateEngine testEngine = new EGLTemplateEngine(outputDir);
        
        // Then: Engine should be ready
        assertNotNull(testEngine);
        assertTrue(Files.exists(outputDir));
    }

    @Test
    void testTemplatePathConfiguration() {
        // Given: Template base path
        String expectedBasePath = "templates/";
        
        // When: Check if templates are accessible
        Path basePath = Paths.get(expectedBasePath);
        
        // Then: Base path should exist
        assertTrue(Files.exists(basePath), 
            "Template base path should exist: " + expectedBasePath);
    }
}
