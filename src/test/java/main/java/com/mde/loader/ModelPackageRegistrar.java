package com.mde.loader;

import com.mde.ModelDrivenEngineering.ModelDrivenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;

public class ModelPackageRegistrar {

    // Flag to track registration status
    private static boolean isRegistered = false;

    // Static initialization block - runs when class is first loaded
    static {
        try {
            registerPackage();
        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: Failed to register Ecore package");
            e.printStackTrace();
            throw new RuntimeException("Cannot initialize model package", e);
        }
    }

    // Private constructor - this is a utility class
    private ModelPackageRegistrar() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Ensures the package is registered. Can be called multiple times safely.
     */
    public static void ensureRegistered() {
        // Static block already handles registration
        // This method is here for explicit calls if needed
        if (!isRegistered) {
            // This shouldn't happen, but just in case
            registerPackage();
        }
    }

    /**
     * Performs the actual package registration
     */
    private static void registerPackage() {
        System.out.println("Registering Ecore package...");

        // Step 1: Initialize the package (triggers EMF initialization)
        ModelDrivenPackage ModelDriven = ModelDrivenPackage.eINSTANCE;

        // Step 2: Register the package in EMF's global registry
        EPackage.Registry globalRegistry = EPackage.Registry.INSTANCE;

        // Check if already registered
        if (!globalRegistry.containsKey(ModelDrivenPackage.eNS_URI)) {
            globalRegistry.put(ModelDrivenPackage.eNS_URI, ModelDriven);
            System.out.println("  ✓ Package registered with URI: " + ModelDrivenPackage.eNS_URI);
        } else {
            System.out.println("  ℹ Package already registered");
        }

        // Step 3: Register Flexmi resource factory for YAML files
        Resource.Factory.Registry factoryRegistry = Resource.Factory.Registry.INSTANCE;

        // Register for .yaml extension
        if (!factoryRegistry.getExtensionToFactoryMap().containsKey("yaml")) {
            factoryRegistry.getExtensionToFactoryMap().put("yaml", new FlexmiResourceFactory());
            System.out.println("  ✓ Flexmi factory registered for .yaml files");
        }

        // Register for .flexmi extension (alternative extension)
        if (!factoryRegistry.getExtensionToFactoryMap().containsKey("flexmi")) {
            factoryRegistry.getExtensionToFactoryMap().put("flexmi", new FlexmiResourceFactory());
            System.out.println("  ✓ Flexmi factory registered for .flexmi files");
        }

        // Set flag
        isRegistered = true;
        System.out.println("Package registration complete!");
    }
}