package com.mde.generator.etl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.etl.EtlModule;

import com.mde.ModelDrivenEngineering.BackendConfig;
import com.mde.ModelDrivenEngineering.ModelDrivenPackage;
import com.mde.generator.Context.ContextPackage;

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

    private static final String ETL_SCRIPT_PATH = "src/main/resources/etl/BackendConfigToContext.etl";
    
    /**
     * Execute ETL transformation with in-memory model (no intermediate files)
     * 
     * @param backendConfig BackendConfig model instance (in-memory)
     * @param outputModel Path where the Context model will be saved
     * @return Path to the generated Context model
     * @throws Exception if transformation fails
     */
    public Path executeTransformation(BackendConfig backendConfig, Path outputModel) throws Exception {
        System.out.println("===========================================");
        System.out.println("ETL TRANSFORMATION ENGINE");
        System.out.println("===========================================");
        System.out.println("Input (PIM):  In-memory BackendConfig model");
        System.out.println("Output (PSM): " + outputModel);
        System.out.println("ETL Script:   " + ETL_SCRIPT_PATH);
        System.out.println("===========================================\n");
        
        // Initialize EMF packages
        initializeEMF();
        
        // Create ETL module
        EtlModule etlModule = new EtlModule();
        
        try {
            // Parse ETL script
            File etlFile = new File(ETL_SCRIPT_PATH);
            if (!etlFile.exists()) {
                throw new IllegalStateException("ETL script not found: " + ETL_SCRIPT_PATH);
            }
            
            etlModule.parse(etlFile);
            
            // Create source model from in-memory object
            EmfModel sourceModel = createSourceModelFromObject(backendConfig);
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
     * Execute ETL transformation
     * 
     * @param inputModel Path to the BackendConfig model file
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
        System.out.println("ETL Script:   " + ETL_SCRIPT_PATH);
        System.out.println("===========================================\n");
        
        // Initialize EMF packages
        initializeEMF();
        
        // Create ETL module
        EtlModule etlModule = new EtlModule();
        
        try {
            // Parse ETL script
            File etlFile = new File(ETL_SCRIPT_PATH);
            if (!etlFile.exists()) {
                throw new IllegalStateException("ETL script not found: " + ETL_SCRIPT_PATH);
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
     * Initialize EMF packages
     */
    private void initializeEMF() {
        // Register both metamodels
        EPackage.Registry.INSTANCE.put(ModelDrivenPackage.eNS_URI, ModelDrivenPackage.eINSTANCE);
        EPackage.Registry.INSTANCE.put(ContextPackage.eNS_URI, ContextPackage.eINSTANCE);
        
        // Register XMI resource factory
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl());
            
        System.out.println("✓ EMF packages registered");
    }
    
    /**
     * Create source model (BackendConfig) from in-memory object
     */
    private EmfModel createSourceModelFromObject(BackendConfig backendConfig) throws EolModelLoadingException {
        // Create a resource set
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(ModelDrivenPackage.eNS_URI, ModelDrivenPackage.eINSTANCE);
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        
        // Create a resource with a file URI (but we won't actually save to disk)
        URI tempUri = URI.createFileURI(System.getProperty("java.io.tmpdir") + "/in-memory-backend.xmi");
        Resource resource = resourceSet.createResource(tempUri);
        if (resource == null) {
            throw new RuntimeException("Failed to create EMF resource");
        }
        resource.getContents().add(backendConfig);
        
        // Create EMF model pointing to the in-memory resource
        EmfModel model = new EmfModel();
        model.setName("Source");
        model.setResource(resource);
        model.setMetamodelUri(ModelDrivenPackage.eNS_URI);
        model.setReadOnLoad(false);  // Already loaded in memory
        model.setStoredOnDisposal(false);  // Don't save when disposed
        // Don't call load() since the resource is already populated
        
        System.out.println("✓ Source model loaded (BackendConfig - in-memory)");
        return model;
    }
    
    /**
     * Create source model (BackendConfig)
     */
    private EmfModel createSourceModel(Path modelPath) throws EolModelLoadingException {
        EmfModel model = new EmfModel();
        model.setName("Source");
        model.setModelFile(modelPath.toString());
        model.setMetamodelUri(ModelDrivenPackage.eNS_URI);
        model.setReadOnLoad(true);
        model.setStoredOnDisposal(false);
        model.load();
        
        System.out.println("✓ Source model loaded (BackendConfig)");
        return model;
    }
    
    /**
     * Create target model (Context)
     */
    private EmfModel createTargetModel(Path modelPath) throws EolModelLoadingException {
        EmfModel model = new EmfModel();
        model.setName("Target");
        model.setModelFile(modelPath.toString());
        model.setMetamodelUri(ContextPackage.eNS_URI);
        model.setReadOnLoad(false);  // Target model starts empty
        model.setStoredOnDisposal(false);  // We'll store it manually
        model.load();
        
        System.out.println("✓ Target model initialized (Context)");
        return model;
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
