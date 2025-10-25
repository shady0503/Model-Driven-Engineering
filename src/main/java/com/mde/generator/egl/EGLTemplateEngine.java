package com.mde.generator.egl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import com.mde.generator.Context.ContextPackage;
import com.mde.generator.Context.EntityContext;
import com.mde.generator.Context.ProjectContext;

/**
 * EGL Template Engine
 * 
 * Executes EGL templates to generate Java source code from Context models (PSM).
 * This class demonstrates the M2T (Model-to-Text) transformation phase
 * in the model-driven engineering pipeline.
 */
public class EGLTemplateEngine {

    private static final String TEMPLATES_BASE_PATH = "templates/";
    private Path outputDirectory;
    private EmfModel contextModel;
    
    /**
     * Constructor
     * 
     * @param outputDirectory Directory where generated code will be written
     */
    public EGLTemplateEngine(Path outputDirectory) {
        this.outputDirectory = outputDirectory;
        initializeEMF();
    }
    
    /**
     * Execute all templates to generate complete Spring Boot project
     * 
     * @param contextModelPath Path to the Context XMI model
     * @return Path to the generated project root
     * @throws Exception if generation fails
     */
    public Path generateProject(Path contextModelPath) throws Exception {
        System.out.println("===========================================");
        System.out.println("EGL TEMPLATE ENGINE");
        System.out.println("===========================================");
        System.out.println("Context Model: " + contextModelPath);
        System.out.println("Output Dir:    " + outputDirectory);
        System.out.println("===========================================\n");
        
        // Load Context model
        loadContextModel(contextModelPath);
        
        // Get ProjectContext
        ProjectContext project = getProjectContext();
        if (project == null) {
            throw new IllegalStateException("No ProjectContext found in model");
        }
        
        System.out.println("Project: " + project.getArtifactId());
        System.out.println("Entities: " + project.getEntities().size());
        System.out.println();
        
        // Create directory structure
        createDirectoryStructure(project);
        
        // Generate files
        generateProjectFiles(project);
        generateEntityFiles(project);
        generateRepositoryFiles(project);
        generateServiceFiles(project);
        generateControllerFiles(project);
        generateConfigurationFiles(project);
        generateDockerFiles(project);
        generateReadme(project);
        
        // Cleanup
        contextModel.dispose();
        
        System.out.println("\n===========================================");
        System.out.println("CODE GENERATION COMPLETE!");
        System.out.println("Generated project at: " + outputDirectory);
        System.out.println("===========================================\n");
        
        return outputDirectory;
    }
    
    /**
     * Initialize EMF
     */
    private void initializeEMF() {
        EPackage.Registry.INSTANCE.put(ContextPackage.eNS_URI, ContextPackage.eINSTANCE);
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl());
    }
    
    /**
     * Load Context model
     */
    private void loadContextModel(Path modelPath) throws EolModelLoadingException {
        contextModel = new EmfModel();
        contextModel.setName("Context");
        contextModel.setModelFile(modelPath.toString());
        contextModel.setMetamodelUri(ContextPackage.eNS_URI);
        contextModel.setReadOnLoad(true);
        contextModel.setStoredOnDisposal(false);
        contextModel.load();
        
        System.out.println("✓ Context model loaded");
    }
    
    /**
     * Get ProjectContext from model
     */
    private ProjectContext getProjectContext() throws Exception {
        return (ProjectContext) contextModel.getAllOfType("ProjectContext").stream()
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Create directory structure for generated project
     */
    private void createDirectoryStructure(ProjectContext project) throws IOException {
        System.out.println("Creating directory structure...");
        
        // Base paths
        Path srcMain = outputDirectory.resolve("src/main");
        Path srcTest = outputDirectory.resolve("src/test");
        
        // Java package structure
        String packagePath = project.getPackageName().replace('.', '/');
        Path javaBase = srcMain.resolve("java").resolve(packagePath);
        
        // Create directories
        Files.createDirectories(javaBase.resolve("entity"));
        Files.createDirectories(javaBase.resolve("repository"));
        Files.createDirectories(javaBase.resolve("service"));
        Files.createDirectories(javaBase.resolve("controller"));
        Files.createDirectories(javaBase.resolve("config"));
        Files.createDirectories(srcMain.resolve("resources"));
        Files.createDirectories(srcTest.resolve("java").resolve(packagePath));
        
        System.out.println("✓ Directory structure created");
    }
    
    /**
     * Generate project files (pom.xml, Application.java)
     */
    private void generateProjectFiles(ProjectContext project) throws Exception {
        System.out.println("\nGenerating project files...");
        
        // pom.xml
        generateFromTemplate(
            "project/pom.egl",
            outputDirectory.resolve("pom.xml"),
            Map.of("project", project)
        );
        
        // Application.java
        String packagePath = project.getPackageName().replace('.', '/');
        Path appPath = outputDirectory.resolve("src/main/java")
            .resolve(packagePath)
            .resolve("Application.java");
            
        generateFromTemplate(
            "project/Application.egl",
            appPath,
            Map.of("project", project)
        );
        
        System.out.println("  ✓ pom.xml");
        System.out.println("  ✓ Application.java");
    }
    
    /**
     * Generate entity files
     */
    private void generateEntityFiles(ProjectContext project) throws Exception {
        System.out.println("\nGenerating entity files...");
        
        String packagePath = project.getPackageName().replace('.', '/');
        Path entityDir = outputDirectory.resolve("src/main/java")
            .resolve(packagePath)
            .resolve("entity");
        
        for (EntityContext entity : project.getEntities()) {
            Path entityFile = entityDir.resolve(entity.getClassName() + ".java");
            
            generateFromTemplate(
                "entity/Entity.egl",
                entityFile,
                Map.of("project", project, "entity", entity)
            );
            
            System.out.println("  ✓ " + entity.getClassName() + ".java");
        }
    }
    
    /**
     * Generate repository files
     */
    private void generateRepositoryFiles(ProjectContext project) throws Exception {
        System.out.println("\nGenerating repository files...");
        
        String packagePath = project.getPackageName().replace('.', '/');
        Path repoDir = outputDirectory.resolve("src/main/java")
            .resolve(packagePath)
            .resolve("repository");
        
        for (EntityContext entity : project.getEntities()) {
            String repositoryName = entity.getClassName() + "Repository";
            Path repoFile = repoDir.resolve(repositoryName + ".java");
            
            generateFromTemplate(
                "repository/Repository.egl",
                repoFile,
                Map.of("project", project, "entity", entity)
            );
            
            System.out.println("  ✓ " + repositoryName + ".java");
        }
    }
    
    /**
     * Generate service files
     */
    private void generateServiceFiles(ProjectContext project) throws Exception {
        System.out.println("\nGenerating service files...");
        
        String packagePath = project.getPackageName().replace('.', '/');
        Path serviceDir = outputDirectory.resolve("src/main/java")
            .resolve(packagePath)
            .resolve("service");
        
        for (EntityContext entity : project.getEntities()) {
            String serviceName = entity.getClassName() + "Service";
            Path serviceFile = serviceDir.resolve(serviceName + ".java");
            
            generateFromTemplate(
                "service/Service.egl",
                serviceFile,
                Map.of("project", project, "entity", entity)
            );
            
            System.out.println("  ✓ " + serviceName + ".java");
        }
    }
    
    /**
     * Generate controller files
     */
    private void generateControllerFiles(ProjectContext project) throws Exception {
        System.out.println("\nGenerating controller files...");
        
        String packagePath = project.getPackageName().replace('.', '/');
        Path controllerDir = outputDirectory.resolve("src/main/java")
            .resolve(packagePath)
            .resolve("controller");
        
        for (EntityContext entity : project.getEntities()) {
            String controllerName = entity.getClassName() + "Controller";
            Path controllerFile = controllerDir.resolve(controllerName + ".java");
            
            generateFromTemplate(
                "controller/Controller.egl",
                controllerFile,
                Map.of("project", project, "entity", entity)
            );
            
            System.out.println("  ✓ " + controllerName + ".java");
        }
    }
    
    /**
     * Generate configuration files (application.properties, application.yml)
     */
    private void generateConfigurationFiles(ProjectContext project) throws Exception {
        System.out.println("\nGenerating configuration files...");
        
        Path resourcesDir = outputDirectory.resolve("src/main/resources");
        Path appPropsFile = resourcesDir.resolve("application.properties");
        
        generateFromTemplate(
            "config/application.properties.egl",
            appPropsFile,
            Map.of("project", project)
        );
        
        System.out.println("  ✓ application.properties");
        
        // Generate JPA Auditing Config
        String packagePath = project.getPackageName().replace('.', '/');
        Path jpaConfigPath = outputDirectory.resolve("src/main/java")
            .resolve(packagePath)
            .resolve("config")
            .resolve("JpaAuditingConfig.java");
            
        generateFromTemplate(
            "config/JpaAuditingConfig.egl",
            jpaConfigPath,
            Map.of("project", project)
        );
        
        System.out.println("  ✓ JpaAuditingConfig.java");
    }
    
    /**
     * Generate Docker files (docker-compose.yml)
     */
    private void generateDockerFiles(ProjectContext project) throws Exception {
        System.out.println("\nGenerating Docker files...");
        
        Path dockerFile = outputDirectory.resolve("docker-compose.yml");
        
        generateFromTemplate(
            "docker/docker-compose.egl",
            dockerFile,
            Map.of("project", project)
        );
        
        System.out.println("  ✓ docker-compose.yml");
    }
    
    /**
     * Generate README.md
     */
    private void generateReadme(ProjectContext project) throws Exception {
        System.out.println("\nGenerating documentation...");
        
        Path readmeFile = outputDirectory.resolve("README.md");
        
        generateFromTemplate(
            "README.egl",
            readmeFile,
            Map.of("project", project)
        );
        
        System.out.println("  ✓ README.md");
    }
    
    /**
     * Generate file from EGL template
     */
    private void generateFromTemplate(String templatePath, Path outputFile, 
                                     Map<String, Object> variables) throws Exception {
        // Create EGL module
        EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
        EglTemplateFactoryModuleAdapter module = new EglTemplateFactoryModuleAdapter(factory);
        
        // Parse template
        File templateFile = new File(TEMPLATES_BASE_PATH + templatePath);
        if (!templateFile.exists()) {
            throw new IllegalStateException("Template not found: " + templatePath);
        }
        
        module.parse(templateFile);
        
        // Add Context model to module
        module.getContext().getModelRepository().addModel(contextModel);
        
        // Add variables to context
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            module.getContext().getFrameStack().put(entry.getKey(), entry.getValue());
        }
        
        // Execute template
        String generatedCode = (String) module.execute();
        
        // Write to file
        Files.createDirectories(outputFile.getParent());
        try (FileWriter writer = new FileWriter(outputFile.toFile())) {
            writer.write(generatedCode);
        }
        
        // Note: Don't dispose model repository here as contextModel is shared across all templates
        // The contextModel will be disposed once in generateProject() after all templates are processed
    }
}