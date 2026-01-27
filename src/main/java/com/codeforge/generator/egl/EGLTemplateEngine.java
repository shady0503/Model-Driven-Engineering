package com.codeforge.generator.egl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import Forge.ForgePackage;
import Forge.BackendConfig;
import Forge.Table;
import Forge.Project;

/**
 * EGL Template Engine
 * 
 * Executes EGL templates to generate Java source code from SpringContext models
 * (PSM).
 * This class demonstrates the M2T (Model-to-Text) transformation phase
 * in the model-driven engineering pipeline.
 */
public class EGLTemplateEngine {

    private static final String TEMPLATES_BASE_RESOURCE = "/templates/";
    private Path outputDirectory;
    private EmfModel forgeModel;
    private Path tempTemplatesDir;

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
     * @param config BackendConfig model
     * @return Path to the generated project root
     * @throws Exception if generation fails
     */
    public Path generateProjectFromForge(BackendConfig config) throws Exception {
        Path tempModelPath = Files.createTempFile("forge-", ".xmi");
        saveModelToXmi(config, tempModelPath);

        loadForgeModel(tempModelPath);

        Project project = config.getProject();
        if (project == null) {
            throw new IllegalStateException("No Project found in model");
        }

        createDirectoryStructure(project);

        generateProjectFiles(project);
        generateEntityFiles(project);
        generateRepositoryFiles(project);
        generateServiceFiles(project);
        generateControllerFiles(project);
        generateExceptionFiles(project);

        String packagePath = project.getGroupId().replace('.', '/');
        Path exceptionHandlerPath = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("controller")
                .resolve("GlobalExceptionHandler.java");
        generateFromTemplate(
                "project/GlobalExceptionHandler.egl",
                exceptionHandlerPath,
                Map.of("project", project));

        generateConfigurationFiles(project);
        generateDockerFiles(project);
        generateReadme(project);

        forgeModel.dispose();
        Files.deleteIfExists(tempModelPath);

        return outputDirectory;
    }

    private void initializeEMF() {
        EPackage.Registry.INSTANCE.put(ForgePackage.eNS_URI, ForgePackage.eINSTANCE);
        org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
                .put("xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
    }

    private void saveModelToXmi(BackendConfig config, Path path) throws IOException {
        org.eclipse.emf.ecore.resource.Resource.Factory factory = new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl();
        org.eclipse.emf.ecore.resource.Resource resource = factory
                .createResource(org.eclipse.emf.common.util.URI.createFileURI(path.toString()));
        resource.getContents().add(config);
        resource.save(null);
    }

    private void loadForgeModel(Path modelPath) throws EolModelLoadingException {
        forgeModel = new EmfModel();
        forgeModel.setName("Forge");
        forgeModel.setModelFile(modelPath.toString());
        forgeModel.setMetamodelUri(ForgePackage.eNS_URI);
        forgeModel.setReadOnLoad(true);
        forgeModel.setStoredOnDisposal(false);
        forgeModel.load();
    }

    private void createDirectoryStructure(Project project) throws IOException {
        Path srcMain = outputDirectory.resolve("src/main");
        Path srcTest = outputDirectory.resolve("src/test");

        String packageName = project.getGroupId();
        String packagePath = packageName.replace('.', '/');
        Path javaBase = srcMain.resolve("java").resolve(packagePath);

        Files.createDirectories(javaBase.resolve("entity"));
        Files.createDirectories(javaBase.resolve("repository"));
        Files.createDirectories(javaBase.resolve("service"));
        Files.createDirectories(javaBase.resolve("controller"));
        Files.createDirectories(javaBase.resolve("config"));
        Files.createDirectories(srcMain.resolve("resources"));
        Files.createDirectories(srcTest.resolve("java").resolve(packageName));
    }

    private void generateProjectFiles(Project project) throws Exception {
        generateFromTemplate(
                "project/pom.egl",
                outputDirectory.resolve("pom.xml"),
                Map.of("project", project));

        String packagePath = project.getGroupId().replace('.', '/');
        Path appPath = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("Application.java");

        generateFromTemplate(
                "project/Application.egl",
                appPath,
                Map.of("project", project));
    }

    private void generateEntityFiles(Project project) throws Exception {
        String packagePath = project.getGroupId().replace('.', '/');
        Path entityDir = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("entity");

        BackendConfig config = (BackendConfig) project.eContainer();
        for (Table table : config.getDatabase().getTables()) {
            Path entityFile = entityDir.resolve(table.getName() + ".java");

            generateFromTemplate(
                    "entity/SpringEntity.egl",
                    entityFile,
                    Map.of("project", project, "entity", table));
        }
    }

    private void generateRepositoryFiles(Project project) throws Exception {
        String packagePath = project.getGroupId().replace('.', '/');
        Path repoDir = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("repository");

        BackendConfig config = (BackendConfig) project.eContainer();
        for (Table table : config.getDatabase().getTables()) {
            String repositoryName = table.getName() + "Repository";
            Path repoFile = repoDir.resolve(repositoryName + ".java");

            generateFromTemplate(
                    "repository/Repository.egl",
                    repoFile,
                    Map.of("project", project, "entity", table));
        }
    }

    private void generateServiceFiles(Project project) throws Exception {
        String packagePath = project.getGroupId().replace('.', '/');
        Path serviceDir = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("service");

        BackendConfig config = (BackendConfig) project.eContainer();
        for (Table table : config.getDatabase().getTables()) {
            String serviceName = table.getName() + "Service";
            Path serviceFile = serviceDir.resolve(serviceName + ".java");

            generateFromTemplate(
                    "service/Service.egl",
                    serviceFile,
                    Map.of("project", project, "entity", table));
        }
    }

    private void generateControllerFiles(Project project) throws Exception {
        String packagePath = project.getGroupId().replace('.', '/');
        Path controllerDir = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("controller");

        BackendConfig config = (BackendConfig) project.eContainer();
        for (Table table : config.getDatabase().getTables()) {
            String controllerName = table.getName() + "Controller";
            Path controllerFile = controllerDir.resolve(controllerName + ".java");

            generateFromTemplate(
                    "controller/Controller.egl",
                    controllerFile,
                    Map.of("project", project, "entity", table));
        }
    }

    private void generateExceptionFiles(Project project) throws Exception {
        String packagePath = project.getGroupId().replace('.', '/');
        Path exceptionDir = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("exception");

        generateFromTemplate(
                "exception/ResourceNotFoundException.egl",
                exceptionDir.resolve("ResourceNotFoundException.java"),
                Map.of("project", project));
    }

    private void generateConfigurationFiles(Project project) throws Exception {
        Path resourcesDir = outputDirectory.resolve("src/main/resources");
        Path appPropsFile = resourcesDir.resolve("application.properties");

        generateFromTemplate(
                "config/application.properties.egl",
                appPropsFile,
                Map.of("project", project));

        String packagePath = project.getGroupId().replace('.', '/');
        Path jpaConfigPath = outputDirectory.resolve("src/main/java")
                .resolve(packagePath)
                .resolve("config")
                .resolve("JpaAuditingConfig.java");

        generateFromTemplate(
                "config/JpaAuditingConfig.egl",
                jpaConfigPath,
                Map.of("project", project));
    }

    private void generateDockerFiles(Project project) throws Exception {
        generateFromTemplate(
                "docker/docker-compose.egl",
                outputDirectory.resolve("docker-compose.yml"),
                Map.of("project", project));

        generateFromTemplate(
                "docker/Dockerfile.egl",
                outputDirectory.resolve("Dockerfile"),
                Map.of("project", project));

        generateFromTemplate(
                "docker/dockerignore.egl",
                outputDirectory.resolve(".dockerignore"),
                Map.of("project", project));
    }

    private void generateReadme(Project project) throws Exception {
        generateFromTemplate(
                "README.egl",
                outputDirectory.resolve("README.md"),
                Map.of("project", project));
    }

    private void generateFromTemplate(String templatePath, Path outputFile,
            Map<String, Object> variables) throws Exception {
        EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
        @SuppressWarnings("deprecation")
        EglTemplateFactoryModuleAdapter module = new EglTemplateFactoryModuleAdapter(factory);

        File templateFile = loadTemplateAsFile(templatePath);
        if (templateFile == null || !templateFile.exists()) {
            throw new IllegalStateException("Template not found: " + templatePath);
        }

        factory.setRoot(tempTemplatesDir.toUri());

        module.parse(templateFile);
        module.getContext().getModelRepository().addModel(forgeModel);

        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            module.getContext().getFrameStack().put(entry.getKey(), entry.getValue());
        }

        String generatedCode = (String) module.execute();

        Files.createDirectories(outputFile.getParent());
        try (FileWriter writer = new FileWriter(outputFile.toFile())) {
            writer.write(generatedCode);
        }
    }

    private File loadTemplateAsFile(String templatePath) throws Exception {
        if (tempTemplatesDir == null) {
            loadTemplates();
        }

        Path targetPath = tempTemplatesDir.resolve(templatePath);
        if (!Files.exists(targetPath)) {
            throw new IllegalStateException("Template not found in temp directory: " + templatePath);
        }

        return targetPath.toFile();
    }

    private void loadTemplates() throws Exception {
        tempTemplatesDir = Files.createTempDirectory("CodeForge-templates");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Files.walk(tempTemplatesDir)
                        .sorted((a, b) -> b.compareTo(a))
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (IOException e) {
            }
        }));

        URI uri = getClass().getResource(TEMPLATES_BASE_RESOURCE).toURI();
        Path baseSourcePath;
        FileSystem fileSystem = null;

        if (uri.getScheme().equals("jar")) {
            fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
            baseSourcePath = fileSystem.getPath(TEMPLATES_BASE_RESOURCE);
        } else {
            baseSourcePath = Path.of(uri);
        }

        try (Stream<Path> walk = Files.walk(baseSourcePath)) {
            for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
                Path source = it.next();
                Path relative = baseSourcePath.relativize(source);
                Path target = tempTemplatesDir.resolve(relative.toString());

                if (Files.isDirectory(source)) {
                    Files.createDirectories(target);
                } else {
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } finally {
            if (fileSystem != null) {
                fileSystem.close();
            }
        }
    }
}
