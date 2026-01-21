package com.mde.generator.etl;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.etl.EtlModule;

import ModelDrivenEngineering.BackendConfig;
import ModelDrivenEngineering.ModelDrivenEngineeringPackage;
import Context.ContextPackage;

/**
 * ETL Transformation Engine
 * 
 * Executes ETL transformations to convert BackendConfig models (PIM)
 * into Context models (PSM) using Eclipse Epsilon ETL.
 * 
 * This class demonstrates the M2M (Model-to-Model) transformation phase
 * in the model-driven engineering pipeline.
 */
public class ETLTransformationEngine {

    private static final String ETL_SCRIPT_RESOURCE = "/etl/BackendConfigToContext.etl";

    /**
     * Execute ETL transformation with in-memory model (no intermediate files)
     * 
     * @param backendConfig BackendConfig model instance (in-memory)
     * @param outputModel   Path where the Context model will be saved
     * @return Path to the generated Context model
     * @throws Exception if transformation fails
     */
    public Path executeTransformation(BackendConfig backendConfig, Path outputModel) throws Exception {
        // Initialize EMF packages
        initializeEMF();

        // Create ETL module
        EtlModule etlModule = new EtlModule();

        try {
            // Load ETL script from classpath (works in JAR)
            File etlFile = loadResourceAsFile(ETL_SCRIPT_RESOURCE);
            if (etlFile == null || !etlFile.exists()) {
                throw new IllegalStateException("ETL script not found in classpath: " + ETL_SCRIPT_RESOURCE);
            }

            etlModule.parse(etlFile);

            // Create source model from in-memory object
            EmfModel sourceModel = createSourceModelFromObject(backendConfig);
            etlModule.getContext().getModelRepository().addModel(sourceModel);

            // Create and configure target model (Context)
            EmfModel targetModel = createTargetModel(outputModel);
            etlModule.getContext().getModelRepository().addModel(targetModel);

            // Execute transformation
            etlModule.execute();

            // Save target model
            targetModel.store();

            return outputModel;

        } catch (Exception e) {
            System.err.println("ETL Transformation failed: " + e.getMessage());
            throw e;
        } finally {
            // Cleanup
            etlModule.getContext().getModelRepository().dispose();
        }
    }

    /**
     * Execute ETL transformation
     * 
     * @param inputModel  Path to the BackendConfig model file
     * @param outputModel Path where the Context model will be saved
     * @return Path to the generated Context model
     * @throws Exception if transformation fails
     */
    public Path executeTransformation(Path inputModel, Path outputModel) throws Exception {
        System.out.println("===========================================");
        System.out.println("ETL TRANSFORMATION ENGINE");
        System.out.println("===========================================");
        System.out.println("Input (PIM):  " + inputModel);
        System.out.println("Output (PSM): " + outputModel);
        System.out.println("ETL Script:   " + ETL_SCRIPT_RESOURCE);
        System.out.println("===========================================\n");

        // Initialize EMF packages
        initializeEMF();

        // Create ETL module
        EtlModule etlModule = new EtlModule();

        try {
            // Load ETL script from classpath (works in JAR)
            File etlFile = loadResourceAsFile(ETL_SCRIPT_RESOURCE);
            if (etlFile == null || !etlFile.exists()) {
                throw new IllegalStateException("ETL script not found in classpath: " + ETL_SCRIPT_RESOURCE);
            }

            etlModule.parse(etlFile);

            // Create and configure source model (BackendConfig)
            EmfModel sourceModel = createSourceModel(inputModel);
            etlModule.getContext().getModelRepository().addModel(sourceModel);

            // Create and configure target model (Context)
            EmfModel targetModel = createTargetModel(outputModel);
            etlModule.getContext().getModelRepository().addModel(targetModel);

            // Execute transformation
            System.out.println("Executing ETL transformation...\n");
            etlModule.execute();

            // Save target model
            targetModel.store();

            System.out.println("\n===========================================");
            System.out.println("ETL TRANSFORMATION COMPLETE!");
            System.out.println("Output saved to: " + outputModel);
            System.out.println("===========================================\n");

            return outputModel;

        } catch (Exception e) {
            System.err.println("ETL Transformation failed: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            // Cleanup
            etlModule.getContext().getModelRepository().dispose();
        }
    }

    /**
     * Initialize EMF packages (Deprecated - now using dynamic loading)
     */
    private void initializeEMF() {
        // We still register the packages for URI resolution if needed,
        // but Epsilon models will point directly to Ecore files for dynamic features.
        EPackage.Registry.INSTANCE.put(ModelDrivenEngineeringPackage.eNS_URI, ModelDrivenEngineeringPackage.eINSTANCE);
        EPackage.Registry.INSTANCE.put(ContextPackage.eNS_URI, ContextPackage.eINSTANCE);

        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
                .put("xmi", new XMIResourceFactoryImpl());
    }

    /**
     * Create source model (BackendConfig) from in-memory object
     */
    private EmfModel createSourceModelFromObject(BackendConfig backendConfig) throws EolModelLoadingException {
        // Use the resource from the object if possible, or create one
        Resource resource = backendConfig.eResource();
        if (resource == null) {
            ResourceSet resourceSet = new ResourceSetImpl();
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
                    new XMIResourceFactoryImpl());
            URI tempUri = URI.createFileURI(System.getProperty("java.io.tmpdir") + "/in-memory-backend.xmi");
            resource = resourceSet.createResource(tempUri);
            resource.getContents().add(backendConfig);
        }

        EmfModel model = new EmfModel();
        model.setName("Source");
        model.setResource(resource);
        // Point to the Ecore file for dynamic metadata access
        model.setMetamodelFile(new File("model/MDE.ecore").getAbsolutePath());
        model.setReadOnLoad(false);
        model.setStoredOnDisposal(false);

        return model;
    }

    /**
     * Create source model (BackendConfig)
     */
    private EmfModel createSourceModel(Path modelPath) throws EolModelLoadingException {
        EmfModel model = new EmfModel();
        model.setName("Source");
        model.setModelFile(modelPath.toString());
        model.setMetamodelFile(new File("model/MDE.ecore").getAbsolutePath());
        model.setReadOnLoad(true);
        model.setStoredOnDisposal(false);
        model.load();

        return model;
    }

    /**
     * Create target model (Context)
     */
    private EmfModel createTargetModel(Path modelPath) throws EolModelLoadingException {
        EmfModel model = new EmfModel();
        model.setName("Target");
        model.setModelFile(modelPath.toString());
        model.setMetamodelFile(new File("model/Context.ecore").getAbsolutePath());
        model.setReadOnLoad(false);
        model.setStoredOnDisposal(false);
        model.load();

        return model;
    }

    /**
     * Load a resource from classpath and copy it to a temporary file.
     * This allows resources packaged in JARs to be used with File-based APIs.
     * 
     * @param resourcePath Path to resource (e.g., "/etl/script.etl")
     * @return Temporary File containing the resource content
     * @throws Exception if resource not found or copy fails
     */
    private File loadResourceAsFile(String resourcePath) throws Exception {
        InputStream resourceStream = getClass().getResourceAsStream(resourcePath);
        if (resourceStream == null) {
            throw new IllegalStateException("Resource not found in classpath: " + resourcePath);
        }

        // Create temp file with appropriate extension
        String extension = resourcePath.substring(resourcePath.lastIndexOf('.'));
        Path tempFile = Files.createTempFile("mde-etl-", extension);

        // Copy resource to temp file
        Files.copy(resourceStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        resourceStream.close();

        // Delete on exit
        tempFile.toFile().deleteOnExit();

        return tempFile.toFile();
    }

    /**
     * Test method - can be used for standalone testing
     */
    public static void main(String[] args) {
        try {
            ETLTransformationEngine engine = new ETLTransformationEngine();

            // Example usage
            Path input = Paths.get("examples/blog-example.yaml");
            Path output = Paths.get("target/blog-context.xmi");

            engine.executeTransformation(input, output);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
