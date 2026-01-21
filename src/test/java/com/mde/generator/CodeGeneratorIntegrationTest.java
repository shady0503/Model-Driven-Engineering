package com.mde.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.Disabled;

/**
 * Integration test for the complete code generation pipeline
 */
class CodeGeneratorIntegrationTest {

    @TempDir
    Path tempDir;

    @Test
    void testGenerateProjectFromBlogExample() throws Exception {
        // Given: Blog YAML example
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("blog-generated");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        Path generatedProject = generator.generateProject(inputYaml, outputDir);

        // Then: Verify project structure
        assertNotNull(generatedProject);
        assertTrue(Files.exists(generatedProject));

        // Verify pom.xml exists
        Path pomXml = generatedProject.resolve("pom.xml");
        assertTrue(Files.exists(pomXml), "pom.xml should exist");

        // Verify source directory exists
        Path srcDir = generatedProject.resolve("src/main/java");
        assertTrue(Files.exists(srcDir), "src/main/java should exist");

        // Verify Application.java exists
        assertTrue(Files.walk(srcDir)
                .anyMatch(p -> p.getFileName().toString().equals("Application.java")),
                "Application.java should exist");

        // Verify entity files exist
        assertTrue(Files.walk(srcDir)
                .anyMatch(p -> p.toString().contains("entity")),
                "Entity directory should exist");

        // Verify repository files exist
        assertTrue(Files.walk(srcDir)
                .anyMatch(p -> p.toString().contains("repository")),
                "Repository directory should exist");

        // Verify service files exist
        assertTrue(Files.walk(srcDir)
                .anyMatch(p -> p.toString().contains("service")),
                "Service directory should exist");

        // Verify controller files exist
        assertTrue(Files.walk(srcDir)
                .anyMatch(p -> p.toString().contains("controller")),
                "Controller directory should exist");

        // Verify docker-compose.yml exists
        Path dockerCompose = generatedProject.resolve("docker-compose.yml");
        assertTrue(Files.exists(dockerCompose), "docker-compose.yml should exist");

        // Verify README.md exists
        Path readme = generatedProject.resolve("README.md");
        assertTrue(Files.exists(readme), "README.md should exist");

        System.out.println("✓ All structure verifications passed!");
    }

    @Test
    void testGenerateProjectFromMinimalExample() throws Exception {
        // Given: Minimal YAML example
        Path inputYaml = Paths.get("examples/minimal-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("minimal-generated");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        Path generatedProject = generator.generateProject(inputYaml, outputDir);

        // Then: Verify basic structure
        assertNotNull(generatedProject);
        assertTrue(Files.exists(generatedProject));
        assertTrue(Files.exists(generatedProject.resolve("pom.xml")));
        assertTrue(Files.exists(generatedProject.resolve("src/main/java")));
    }

    @Test
    void testGeneratedPomXmlHasSpringBootDependencies() throws Exception {
        // Given: Generated project
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("pom-test");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);

        // Then: Verify pom.xml has Spring Boot dependencies
        Path pomXml = outputDir.resolve("pom.xml");
        String pomContent = Files.readString(pomXml);

        assertTrue(pomContent.contains("spring-boot-starter-web"),
                "pom.xml should contain spring-boot-starter-web");
        assertTrue(pomContent.contains("spring-boot-starter-data-jpa"),
                "pom.xml should contain spring-boot-starter-data-jpa");
        assertTrue(pomContent.contains("lombok"),
                "pom.xml should contain lombok");
    }

    @Test
    void testGeneratedApplicationPropertiesHasDatabaseConfig() throws Exception {
        // Given: Generated project
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("config-test");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);

        // Then: Verify application.properties has database configuration
        Path appProps = outputDir.resolve("src/main/resources/application.properties");

        if (Files.exists(appProps)) {
            String propsContent = Files.readString(appProps);
            assertTrue(propsContent.contains("spring.datasource") ||
                    propsContent.contains("spring.jpa"),
                    "application.properties should contain database configuration");
        }
    }

    @Test
    void testGeneratedEntitiesHaveJPAAnnotations() throws Exception {
        // Given: Generated project
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("entity-test");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);

        // Then: Find entity files and verify JPA annotations
        Path entityDir = outputDir.resolve("src/main/java");
        boolean foundEntityWithAnnotations = Files.walk(entityDir)
                .filter(p -> p.toString().contains("entity") && p.toString().endsWith(".java"))
                .anyMatch(p -> {
                    try {
                        String content = Files.readString(p);
                        return content.contains("@Entity") && content.contains("@Table");
                    } catch (Exception e) {
                        return false;
                    }
                });

        assertTrue(foundEntityWithAnnotations,
                "At least one entity should have JPA annotations (@Entity, @Table)");
    }

    @Test
    void testGeneratedRepositoriesExtendJpaRepository() throws Exception {
        // Given: Generated project
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("repository-test");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);

        // Then: Find repository files and verify they extend JpaRepository
        Path srcDir = outputDir.resolve("src/main/java");
        boolean foundRepositoryExtendingJpa = Files.walk(srcDir)
                .filter(p -> p.toString().contains("repository") && p.toString().endsWith("Repository.java"))
                .anyMatch(p -> {
                    try {
                        String content = Files.readString(p);
                        return content.contains("extends JpaRepository");
                    } catch (Exception e) {
                        return false;
                    }
                });

        assertTrue(foundRepositoryExtendingJpa,
                "At least one repository should extend JpaRepository");
    }

    @Test
    void testGeneratedControllersHaveRestAnnotations() throws Exception {
        // Given: Generated project
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("controller-test");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);

        // Then: Find controller files and verify REST annotations
        Path srcDir = outputDir.resolve("src/main/java");
        boolean foundControllerWithAnnotations = Files.walk(srcDir)
                .filter(p -> p.toString().contains("controller") && p.toString().endsWith("Controller.java"))
                .anyMatch(p -> {
                    try {
                        String content = Files.readString(p);
                        return content.contains("@RestController") && content.contains("@RequestMapping");
                    } catch (Exception e) {
                        return false;
                    }
                });

        assertTrue(foundControllerWithAnnotations,
                "At least one controller should have REST annotations");
    }

    @Test
    @Disabled("Requires Maven to be installed - enable for full integration testing")
    void testGeneratedCodeCompiles() throws Exception {
        // Given: Blog YAML example
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        Path outputDir = tempDir.resolve("blog-test-compile");

        // When: Generate project
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);

        // Then: Try to compile with Maven
        ProcessBuilder pb = new ProcessBuilder("mvn", "clean", "compile");
        pb.directory(outputDir.toFile());
        pb.inheritIO();

        Process process = pb.start();
        int exitCode = process.waitFor();

        assertEquals(0, exitCode, "Generated code should compile successfully");
        System.out.println("✓ Generated code compiles successfully!");
    }

    @Test
    void testMultipleGenerationsDoNotInterfere() throws Exception {
        // Given: Same YAML file
        Path inputYaml = Paths.get("examples/blog-example.yaml");
        assumeFileExists(inputYaml);

        // When: Generate two separate projects
        CodeGenerator generator = new CodeGenerator();
        Path output1 = tempDir.resolve("project1");
        Path output2 = tempDir.resolve("project2");

        generator.generateProject(inputYaml, output1);
        generator.generateProject(inputYaml, output2);

        // Then: Both projects should exist independently
        assertTrue(Files.exists(output1.resolve("pom.xml")));
        assertTrue(Files.exists(output2.resolve("pom.xml")));

        // Verify they have the same structure but are separate
        long files1 = Files.walk(output1).filter(Files::isRegularFile).count();
        long files2 = Files.walk(output2).filter(Files::isRegularFile).count();
        assertEquals(files1, files2, "Both projects should have the same number of files");
    }

    /**
     * Helper method to assume file exists and skip test if it doesn't
     */
    private void assumeFileExists(Path path) {
        if (!Files.exists(path)) {
            fail("Test skipped: Required file does not exist: " + path);
        }
    }
}
