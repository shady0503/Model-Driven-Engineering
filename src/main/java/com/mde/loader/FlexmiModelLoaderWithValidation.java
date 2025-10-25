package com.mde.loader;

import com.mde.ModelDrivenEngineering.BackendConfig;
import com.mde.validation.ModelValidationEngine;
import com.mde.validation.ValidationResult;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Enhanced FlexmiModelLoader with integrated validation support.
 * This loader can optionally validate the model after loading.
 */
public class FlexmiModelLoaderWithValidation {

    private final ResourceSet resourceSet;
    private final ModelValidationEngine validationEngine;
    private final boolean autoValidate;
    private final boolean failOnValidationErrors;

    /**
     * Creates a new loader instance with default settings (no auto-validation)
     */
    public FlexmiModelLoaderWithValidation() {
        this(false, false);
    }

    /**
     * Creates a new loader instance with validation options
     * 
     * @param autoValidate If true, automatically validate after loading
     * @param failOnValidationErrors If true, throw LoadException when validation errors occur
     */
    public FlexmiModelLoaderWithValidation(boolean autoValidate, boolean failOnValidationErrors) {
        ModelPackageRegistrar.ensureRegistered();
        this.resourceSet = new ResourceSetImpl();
        this.validationEngine = ModelValidationEngine.createDefault();
        this.autoValidate = autoValidate;
        this.failOnValidationErrors = failOnValidationErrors;
    }

    /**
     * Loads a BackendConfig model from a YAML file
     *
     * @param filePath Path to the YAML file
     * @return Loaded BackendConfig instance
     * @throws LoadException if loading or validation fails
     */
    public BackendConfig load(String filePath) throws LoadException {
        // Validate input
        if (filePath == null) {
            throw new LoadException("File path cannot be null");
        }

        if (filePath.trim().isEmpty()) {
            throw new LoadException("File path cannot be empty");
        }

        // Create File object
        File file = new File(filePath);

        // Check file exists
        if (!file.exists()) {
            throw new LoadException("File not found: " + filePath);
        }

        // Check file is readable
        if (!file.canRead()) {
            throw new LoadException("File is not readable: " + filePath);
        }

        // Check file is actually a file (not directory)
        if (!file.isFile()) {
            throw new LoadException("Path is not a file: " + filePath);
        }

        try {
            // Convert file path to EMF URI
            URI uri = URI.createFileURI(file.getAbsolutePath());

            // Load the resource
            Resource resource = loadResource(uri);

            // Extract root object
            BackendConfig config = extractRootObject(resource);

            // Auto-validate if enabled
            if (autoValidate) {
                validateModel(config, filePath);
            }

            return config;

        } catch (LoadException e) {
            throw e;
        } catch (Exception e) {
            throw new LoadException("Failed to load model from: " + filePath, e);
        }
    }

    /**
     * Loads a BackendConfig model from a File object
     */
    public BackendConfig load(File file) throws LoadException {
        if (file == null) {
            throw new LoadException("File cannot be null");
        }
        return load(file.getAbsolutePath());
    }

    /**
     * Loads a BackendConfig model from a Path object
     */
    public BackendConfig load(Path path) throws LoadException {
        if (path == null) {
            throw new LoadException("Path cannot be null");
        }
        return load(path.toFile());
    }

    /**
     * Validates a BackendConfig model and returns validation results
     * 
     * @param config The model to validate
     * @return List of validation results
     */
    public List<ValidationResult> validate(BackendConfig config) {
        return validationEngine.validate(config);
    }

    /**
     * Validates a model and throws exception if there are errors (when configured)
     */
    private void validateModel(BackendConfig config, String filePath) throws LoadException {
        List<ValidationResult> results = validationEngine.validate(config);

        if (!results.isEmpty()) {
            // Print all validation results
            System.out.println("\nValidation results for: " + filePath);
            System.out.println(ModelValidationEngine.formatResults(results));

            // Check if we should fail on errors
            if (failOnValidationErrors) {
                List<ValidationResult> errors = validationEngine.validateErrors(config);
                if (!errors.isEmpty()) {
                    StringBuilder errorMsg = new StringBuilder();
                    errorMsg.append("Model validation failed with ")
                           .append(errors.size())
                           .append(" error(s):\n");
                    for (ValidationResult error : errors) {
                        errorMsg.append("  - ").append(error.getMessage()).append("\n");
                    }
                    throw new LoadException(errorMsg.toString());
                }
            }
        }
    }

    /**
     * Loads an EMF resource from the given URI
     */
    private Resource loadResource(URI uri) throws LoadException {
        try {
            Resource resource = resourceSet.getResource(uri, false);

            if (resource == null) {
                resource = resourceSet.createResource(uri);
            }

            if (!resource.isLoaded()) {
                Map<Object, Object> loadOptions = new HashMap<>();
                resource.load(loadOptions);
            }

            EcoreUtil.resolveAll(resourceSet);

            if (!resource.getErrors().isEmpty()) {
                StringBuilder errorMsg = new StringBuilder("Errors in YAML file:\n");
                for (Resource.Diagnostic error : resource.getErrors()) {
                    errorMsg.append("  Line ").append(error.getLine())
                            .append(": ").append(error.getMessage()).append("\n");
                }
                throw new LoadException(errorMsg.toString());
            }

            if (!resource.getWarnings().isEmpty()) {
                System.out.println("Warnings in YAML file:");
                for (Resource.Diagnostic warning : resource.getWarnings()) {
                    System.out.println("  Line " + warning.getLine() + ": " + warning.getMessage());
                }
            }

            return resource;

        } catch (IOException e) {
            throw new LoadException("IO error while loading resource", e);
        }
    }

    /**
     * Extracts the BackendConfig root object from the resource
     */
    private BackendConfig extractRootObject(Resource resource) throws LoadException {
        if (resource.getContents().isEmpty()) {
            throw new LoadException("No root element found in YAML file. File appears to be empty.");
        }

        Object rootObject = resource.getContents().get(0);

        if (!(rootObject instanceof BackendConfig)) {
            throw new LoadException(
                    "Root element is not a BackendConfig. Found: " +
                            rootObject.getClass().getSimpleName() +
                            ". Check that your YAML starts with 'BackendConfig:'"
            );
        }

        return (BackendConfig) rootObject;
    }

    /**
     * Gets the validation engine used by this loader
     */
    public ModelValidationEngine getValidationEngine() {
        return validationEngine;
    }
}
