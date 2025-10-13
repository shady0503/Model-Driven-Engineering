package com.mde.loader;

import com.mde.ModelDrivenEngineering.BackendConfig;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FlexmiModelLoader {

    // ResourceSet manages model resources
    private final ResourceSet resourceSet;

    /**
     * Creates a new loader instance
     */
    public FlexmiModelLoader() {
        // Ensure package is registered
        ModelPackageRegistrar.ensureRegistered();

        // Create resource set for loading models
        this.resourceSet = new ResourceSetImpl();
    }

    /**
     * Loads a BackendConfig model from a YAML file
     *
     * @param filePath Path to the YAML file
     * @return Loaded BackendConfig instance
     * @throws LoadException if loading fails
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

            // Extract and return root object
            return extractRootObject(resource);

        } catch (LoadException e) {
            // Re-throw LoadException as-is
            throw e;
        } catch (Exception e) {
            // Wrap other exceptions
            throw new LoadException("Failed to load model from: " + filePath, e);
        }
    }
    /**
     * Loads a BackendConfig model from a File object
     *
     * @param file File object
     * @return Loaded BackendConfig instance
     * @throws LoadException if loading fails
     */
    public BackendConfig load(File file) throws LoadException {
        if (file == null) {
            throw new LoadException("File cannot be null");
        }

        return load(file.getAbsolutePath());
    }
    /**
     * Loads a BackendConfig model from a Path object
     *
     * @param path Path object
     * @return Loaded BackendConfig instance
     * @throws LoadException if loading fails
     */
    public BackendConfig load(Path path) throws LoadException {
        if (path == null) {
            throw new LoadException("Path cannot be null");
        }

        return load(path.toFile());
    }

    /**
     * Loads an EMF resource from the given URI
     */
    private Resource loadResource(URI uri) throws LoadException {
        try {
            // Try to get existing resource or create new one
            Resource resource = resourceSet.getResource(uri, false);

            if (resource == null) {
                // Create new resource
                resource = resourceSet.createResource(uri);
            }

            // Load the resource if not already loaded
            if (!resource.isLoaded()) {
                // Create load options
                Map<Object, Object> loadOptions = new HashMap<>();

                // Load the resource (Flexmi parses YAML here)
                resource.load(loadOptions);
            }

            // Resolve all cross-references
            EcoreUtil.resolveAll(resourceSet);

            // Check for errors
            if (!resource.getErrors().isEmpty()) {
                StringBuilder errorMsg = new StringBuilder("Errors in YAML file:\n");
                for (Resource.Diagnostic error : resource.getErrors()) {
                    errorMsg.append("  Line ").append(error.getLine())
                            .append(": ").append(error.getMessage()).append("\n");
                }
                throw new LoadException(errorMsg.toString());
            }

            // Check for warnings (log but don't fail)
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
        // Check if resource has contents
        if (resource.getContents().isEmpty()) {
            throw new LoadException("No root element found in YAML file. File appears to be empty.");
        }

        // Get first element
        Object rootObject = resource.getContents().get(0);

        // Check if it's a BackendConfig
        if (!(rootObject instanceof BackendConfig)) {
            throw new LoadException(
                    "Root element is not a BackendConfig. Found: " +
                            rootObject.getClass().getSimpleName() +
                            ". Check that your YAML starts with 'BackendConfig:'"
            );
        }

        // Cast and return
        return (BackendConfig) rootObject;
    }
}